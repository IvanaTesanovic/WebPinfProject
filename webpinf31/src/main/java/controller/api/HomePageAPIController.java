package controller.api;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.AnalitikaIzvoda;
import model.Banka;
import model.DnevnoStanjeRacuna;
import model.Drzava;
import model.Klijent;
import model.Kliring;
import model.KursUValuti;
import model.KursnaLista;
import model.NaseljenoMesto;
import model.RTGS;
import model.Racun;
import model.SPTable;
import model.nalog.NalogZaPrenos;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import api.constants.ForeignKeys;
import api.constants.MimeTypes;
import api.constants.RequestMappings;
import api.constants.TableColumns;
import connection.DBConnection;
import service.AnalitikaIzvodaService;
import service.BankaService;
import service.DnevnaStanjaRacunaService;
import service.DrzavaService;
import service.KlijentService;
import service.KliringService;
import service.KursUValutiService;
import service.KursnaListaService;
import service.NaseljenoMestoService;
import service.RacunService;
import service.SPTableService;
import util.Column;
import service.RTGSService;

@RestController
@RequestMapping(RequestMappings.HOMEPAGE_API)
public class HomePageAPIController {
	
	@Autowired
	DrzavaService drzavaService;
	
	@Autowired
	NaseljenoMestoService nasMestaService;
	
	@Autowired
	BankaService bankaService;
	
	@Autowired
	KlijentService klijentiService;
	
	@Autowired
	RacunService racunService;
	
	@Autowired
	RTGSService rtgsService;
	
	@Autowired
	KliringService kliringService;
	
	@Autowired
	KursnaListaService kursnaListaService;
	
	@Autowired
	KursUValutiService kursUValutiService;
	
	@Autowired
	AnalitikaIzvodaService analitikaIzvodaService;
	
	@Autowired
	DnevnaStanjaRacunaService dnevnaStanjaRacunaService;
	
	@Autowired
	SPTableService sptableService;
	
	/** TODO IMPORT & POZIVANJE USKLADISTENE PROCEDURE **/
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IMPORT, produces = MimeTypes.UPLOAD_FILE)
	public String importNaloga(MultipartHttpServletRequest request) {
		
		Iterator<String> itr =  request.getFileNames();
	    MultipartFile mpf = request.getFile(itr.next());
	    
	    File file = new File(System.getProperty("user.home"), mpf.getOriginalFilename());
	    
	    try {
	    	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
	    	stream.write(mpf.getBytes());
	    	stream.close();
	    	
		    JAXBContext jaxbContext = JAXBContext.newInstance(NalogZaPrenos.class);
	    	
	    	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    	NalogZaPrenos nalog = (NalogZaPrenos)jaxbUnmarshaller.unmarshal(file);
	    	
	    	java.util.Date utilDate = nalog.getDatumValute().toGregorianCalendar().getTime();
	    	java.sql.Date datumValute = new java.sql.Date(utilDate.getTime());
	    	
	    	/** tabela sadrzi trigger nad insertom koji poziva uskladistenu proceduru **/

	    	sptableService.save(new SPTable(nalog.getIDPoruke(), nalog.getDuznik(), nalog.getPoverilac(), nalog.getSvrhaPlacanja(),
	    			datumValute, nalog.getRacunDuznika().getBrojRacuna(),
	    			String.valueOf(nalog.getRacunDuznika().getBrojModela()),
	    			nalog.getRacunDuznika().getPozivNaBroj(), nalog.getRacunPoverioca().getBrojRacuna(),
	    			String.valueOf(nalog.getRacunPoverioca().getBrojModela()), nalog.getRacunPoverioca().getPozivNaBroj(),
	    			nalog.isHitno(), nalog.getOznakaValute(), nalog.getIznos(), true));

	    	return "";
	    	
//	    catch(SQLGrammarException e) {
//	    	System.out.println("-------------------------------------------------------------");
//	    	System.out.println(e.getCause().getMessage());
//	    	return e.getCause().getMessage();
//	    }
//	    catch(JAXBException e) {
//	    	return e.getMessage();
//	    }
//	    catch(IOException e) {
//	    	return e.getMessage();
	    } catch (Exception e) {
	    	if(e.getCause() instanceof SQLGrammarException) {
	    		SQLServerException eee = (SQLServerException)e.getCause().getCause();
	    		return eee.getMessage();
	    	}
	    	return e.getMessage();
		}
	}
	
//		PreparedStatement proc_stmt;
//		try {
//			proc_stmt = DBConnection.getConnection().prepareStatement("exec Nalog ?,?,?,? ");
//			/*@BROJ_RACUNA_DUZNIKA VARCHAR(255),
//			@BROJ_RACUNA_POVERIOCA VARCHAR(255),	
//			@IZNOS DECIMAL(15,2),
//    		@OK BIT OUTPUT*/
//			proc_stmt.setEscapeProcessing(true);
//		    proc_stmt.setQueryTimeout(90);
//			proc_stmt.setString(1, "123-2345456788989-33");
//			proc_stmt.setString(2, "123-2343336788989-33");
//			proc_stmt.setBigDecimal(3, new BigDecimal(10.00));
//			proc_stmt.setBoolean(4, true);
//		    proc_stmt.executeUpdate();
//		    //DBConnection.getConnection().close();
////		   if(rs.next())
////			   System.out.println(rs.getString(1));
//		    
//		    /* cstmt.execute();
//        rs = cstmt.getResultSet();
//        if (rs.next()) {
//            averageWeight = rs.getDouble(1);
//        }*/
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	
	/** TODO GET TABELE **/
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.ANALITIKE_IZVODA, produces = MimeTypes.APPLICATION_JSON)
	public List<AnalitikaIzvoda> getanalitikaIzvoda() {
		return analitikaIzvodaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.BANKE, produces = MimeTypes.APPLICATION_JSON)
	public List<Banka> getBanke() {
		return bankaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DNEVNA_STANJA, produces = MimeTypes.APPLICATION_JSON)
	public List<DnevnoStanjeRacuna> getDnevnoStanjeRacuna() {
		return dnevnaStanjaRacunaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DRZAVE, produces = MimeTypes.APPLICATION_JSON)
	public List<Drzava> getDrzave() {
		return drzavaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KLIJENTI, produces = MimeTypes.APPLICATION_JSON)
	public List<Klijent> getKlijenti() {
		return klijentiService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KLIRING, produces = MimeTypes.APPLICATION_JSON)
	public List<Kliring> getKliring() {
		return kliringService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSNA_LISTA, produces = MimeTypes.APPLICATION_JSON)
	public List<KursnaLista> getKursnaLista() {
		return kursnaListaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSEVI, produces = MimeTypes.APPLICATION_JSON)
	public List<KursUValuti> getKursevi() {
		return kursUValutiService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.NASELJENA_MESTA, produces = MimeTypes.APPLICATION_JSON)
	public List<NaseljenoMesto> getNaseljenaMesta() {
		return nasMestaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RACUNI, produces = MimeTypes.APPLICATION_JSON)
	public List<Racun> getRacuni() {
		return racunService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RTGS, produces = MimeTypes.APPLICATION_JSON)
	public List<RTGS> getRTGS() {
		return rtgsService.listAll();
	}
	/** END GET TABELE**/
	
	/** TODO GET ONE OBJECT **/
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DRZAVE + "/{id}", produces = MimeTypes.APPLICATION_JSON)
	public Drzava getDrzava(@Validated @PathVariable final Long id) {
		return drzavaService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.ANALITIKE_IZVODA + "/{id}", produces = MimeTypes.APPLICATION_JSON)
	public AnalitikaIzvoda getAnalitikaIzvoda(@Validated @PathVariable final Long id) {
		return analitikaIzvodaService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.BANKE + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public Banka getBanka (@Validated @PathVariable final Long id){
		return  bankaService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DNEVNA_STANJA + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public DnevnoStanjeRacuna getDnevnoStanjeRacuna(@Validated @PathVariable final Long id){
		return  dnevnaStanjaRacunaService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KLIJENTI + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public Klijent getKlijent(@Validated @PathVariable final Long id){
		return  klijentiService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KLIRING + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public Kliring getKliring (@Validated @PathVariable final Long id){
		return  kliringService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSNA_LISTA + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public KursnaLista getKursnaLista(@Validated @PathVariable final Long id){
		return kursnaListaService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSEVI + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public KursUValuti getKursUvaluti (@Validated @PathVariable final Long id){
		return kursUValutiService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.NASELJENA_MESTA + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public NaseljenoMesto getNaseljenoMesto(@Validated @PathVariable final Long id){
		return  nasMestaService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RACUNI + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public Racun getRacun (@Validated @PathVariable final Long id){
		return racunService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RTGS + "/{id}", produces = MimeTypes.APPLICATION_JSON )
	public RTGS getRTGS (@Validated @PathVariable final Long id){
		return rtgsService.findById(id);
	}
	/**END GET ONE OBJECT **/
	
	
	/** TODO GET KOLONE **/
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DRZAVE + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getDrzaveKolone() {
		return TableColumns.getColumns("drzave");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.NASELJENA_MESTA + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getMestaKolone() {
		return TableColumns.getColumns("naseljenaMesta");
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.BANKE + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getBankeKolone() {
		return TableColumns.getColumns("banke");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KLIJENTI + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getKlijentiKolone() {
		return TableColumns.getColumns("klijenti");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RACUNI + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getRacuniKolone() {
		return TableColumns.getColumns("racuni");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RTGS + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getRtgsKolone() {
		return TableColumns.getColumns("rtgs");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KLIRING + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getKliringKolone() {
		return TableColumns.getColumns("kliring");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSNA_LISTA + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getKursnaListaKolone() {
		return TableColumns.getColumns("kursnaLista");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSEVI + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getKurseviKolone() {
		return TableColumns.getColumns("kursevi");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.ANALITIKE_IZVODA + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getAnalitikeIzvodaKolone() {
		return TableColumns.getColumns("analitikeIzvoda");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DNEVNA_STANJA + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getDnevnaStanjaKolone() {
		return TableColumns.getColumns("dnevnaStanja");
	}
	/** END GET KOLONE **/
	
	/** TO DO GET FOREIGN KEYS**/
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.NASELJENA_MESTA + RequestMappings.FOREIGN_KEY, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<String> getFKNaseljenoMesto(){
		return ForeignKeys.getForeignKeys("naseljenaMesta");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.ANALITIKE_IZVODA + RequestMappings.FOREIGN_KEY, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<String> getFKAnalitikeIzvoda(){
		return ForeignKeys.getForeignKeys("analitikeIzvoda");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DNEVNA_STANJA + RequestMappings.FOREIGN_KEY, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<String> getFKDnevnaStanja(){
		return ForeignKeys.getForeignKeys("dnevnaStanja");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KLIRING + RequestMappings.FOREIGN_KEY, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<String> getFKKliring(){
		return ForeignKeys.getForeignKeys("kliring");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSNA_LISTA + RequestMappings.FOREIGN_KEY, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<String> getFKKursnaLista(){
		return ForeignKeys.getForeignKeys("kursnaLista");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.KURSEVI + RequestMappings.FOREIGN_KEY, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<String> getFKKursevi(){
		return ForeignKeys.getForeignKeys("kursevi");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RACUNI + RequestMappings.FOREIGN_KEY, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<String> getFKRacuni(){
		return ForeignKeys.getForeignKeys("racuni");
	}
	/** END GET FOREIGN KEYS**/
	
	
	/** TODO DELETE TABLE ROWS **/
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.DRZAVE + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDrzavaRow(@Validated @PathVariable final Long id) {

//        try {
            final Drzava drzava = new Drzava();
            drzava.setId(id);
//            groupIdentityValidator.validate(group, null);
            drzavaService.deleteRow(id);
//        } catch (final DataIntegrityViolationException e) {
//            throw new DeleteEntityException("deleteError");
//        }
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.BANKE + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBankaRow(@Validated @PathVariable final Long id) {
		final Banka banka = new Banka();
		banka.setId(id);
		bankaService.deleteRow(id);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.RTGS + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRtgsRow(@Validated @PathVariable final Long id) {
		final RTGS rtgs = new RTGS();
		rtgs.setId(id);
		rtgsService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.NASELJENA_MESTA + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMestoRow(@Validated @PathVariable final Long id) {
		final NaseljenoMesto naseljenoMesto = new NaseljenoMesto();
		naseljenoMesto.setId(id);
		nasMestaService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.RACUNI + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRacuniRow(@Validated @PathVariable final Long id) {
		final Racun racun = new Racun();
		racun.setId(id);
		racunService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.ANALITIKE_IZVODA + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAnalitikeRow(@Validated @PathVariable final Long id) {
		final AnalitikaIzvoda analitika = new AnalitikaIzvoda();
		analitika.setId(id);
		analitikaIzvodaService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.DNEVNA_STANJA + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDnevnaStanjaRow(@Validated @PathVariable final Long id) {
		final DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna();
		dnevnoStanjeRacuna.setId(id);
		dnevnaStanjaRacunaService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.KLIJENTI + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteKlijentiRow(@Validated @PathVariable final Long id) {
		final Klijent klijent = new Klijent();
		klijent.setId(id);
		klijentiService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.KLIRING + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteKliringRow(@Validated @PathVariable final Long id) {
		final Kliring kliring = new Kliring();
		kliring.setId(id);
		kliringService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.KURSEVI + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteKurseviRow(@Validated @PathVariable final Long id) {
		final KursUValuti kurs = new KursUValuti();
		kurs.setId(id);
		kursUValutiService.deleteRow(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.KURSNA_LISTA + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteKursnaListaRow(@Validated @PathVariable final Long id) {
		final KursnaLista kursnaLista = new KursnaLista();
		kursnaLista.setId(id);
		kursnaListaService.deleteRow(id);
	}
	
	/** END DELETE TABLE ROWS **/

	
}

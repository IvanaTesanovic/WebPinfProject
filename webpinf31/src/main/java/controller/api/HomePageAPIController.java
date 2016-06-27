package controller.api;

import java.util.ArrayList;
import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.constants.MimeTypes;
import api.constants.RequestMappings;
import api.constants.TableColumns;
import service.AnalitikaIzvodaService;
//github.com/IvanaTesanovic/WebPinfProject
import service.BankaService;
import service.DnevnaStanjaRacunaService;
import service.DrzavaService;
import service.KlijentService;
import service.KliringService;
import service.KursUValutiService;
import service.KursnaListaService;
import service.NaseljenoMestoService;
import service.RacunService;
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
	
	/** GET TABELE **/
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
	
	
	/** GET KOLONE **/
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
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.RTGS + RequestMappings.KOLONE, produces = MimeTypes.APPLICATION_JSON)
	public ArrayList<Column> getRtgsKolone() {
		return TableColumns.getColumns("rtgs");
	}
	
	
	
	/** END GET KOLONE **/ 
	
	
	/** DELETE TABLE ROWS **/
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
	
	/** END DELETE TABLE ROWS **/
	
}

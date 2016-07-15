package controller.api;

import model.AnalitikaIzvoda;
import model.Kliring;
import model.Valuta;
import model.nalog.NalogZaPrenos;
import model.nalog.TRacun;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.AnalitikaIzvodaService;
import service.DnevnaStanjaRacunaService;
import service.NaseljenoMestoService;
import service.ValutaService;
//import service.VrstePlacanjaService;
import api.constants.RequestMappings;
//import dto.AnalitikaIzvodaDTO;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.ANALITIKE_IZVODA)
public class AnalitikeIzvodaAPIController {

	@Autowired
	AnalitikaIzvodaService analitikaIzvodaService;
	/*	
	@Autowired
	DnevnaStanjaRacunaService dnevnaStanjaRacunaService;
	
	@Autowired
	VrstePlacanjaService vpService;
	
	@Autowired
	NaseljenoMestoService nmService;
	*/
	@Autowired
	ValutaService valutaService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public void dodaj(/*@RequestBody AnalitikaIzvodaDTO obj*/) {
	
		analitikaIzvodaService.save(new AnalitikaIzvoda()); }/*(obj.getDuznik(), obj.getPoverilac(), obj.getSvrha_placanja(), obj.getDatum_prijema(),
				obj.getDatum_valute(), obj.getRacun_duznika(), obj.getRacun_poverioca(), obj.getModel_odobrenja(), obj.getModel_zaduzenja(),
				obj.getPoziv_na_broj_odobrenja(),obj.getPoziv_na_broj_zaduzenja(),obj.getHitno(), obj.getIznos(), obj.getTip_greske(),
				obj.getStatus(), dnevnaStanjaRacunaService.findById(Long.parseLong(obj.getId_dnevnog_stanja_racuna())),
				vpService.findById(Long.parseLong(obj.getId_vrste_placanja())), valutaService.findById(Long.parseLong(obj.getId_valute())),
				nmService.findById(Long.parseLong(obj.getId_naseljenog_mesta())))); 
	} */
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.EXPORT)
	public void export(@RequestBody AnalitikaIzvoda obj) {
		
		try {
			File file = new File(System.getProperty("user.home"), "izvod_" + obj.getId_poruke() + ".xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(model.nalog.NalogZaPrenos.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
			NalogZaPrenos nalog = new NalogZaPrenos();
			nalog.setDuznik(obj.getDuznik());
			nalog.setIDPoruke(obj.getId_poruke());
			nalog.setIznos(new BigDecimal(obj.getIznos()));
			nalog.setHitno(obj.getHitno());
			
			if(obj.getId_valute() != null) {
				Valuta valuta = valutaService.findById(obj.getId_valute().getId());
				nalog.setOznakaValute(valuta.getOznaka_valute());
			}
			else
				nalog.setOznakaValute(null);
				
			
			nalog.setPoverilac(obj.getPoverilac());

			TRacun racunDuznika = new TRacun();
			racunDuznika.setBrojModela(new BigInteger(obj.getModel_zaduzenja()));
			racunDuznika.setBrojRacuna(obj.getRacun_duznika());
			racunDuznika.setPozivNaBroj(obj.getPoziv_na_broj_zaduzenja());
			TRacun racunPoverioca = new TRacun();
			racunPoverioca.setBrojModela(new BigInteger(obj.getModel_odobrenja()));
			racunPoverioca.setBrojRacuna(obj.getRacun_poverioca());
			racunPoverioca.setPozivNaBroj(obj.getPoziv_na_broj_odobrenja());
			
			nalog.setRacunDuznika(racunDuznika);
			nalog.setRacunPoverioca(racunPoverioca);
			nalog.setSvrhaPlacanja(obj.getSvrha_placanja());
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(obj.getDatum_valute());
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			GregorianCalendar c1 = new GregorianCalendar();
			c1.setTime(obj.getDatum_prijema());
			XMLGregorianCalendar date22 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c1);
			
			nalog.setDatumNaloga(date22);
			nalog.setDatumValute(date2);
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(nalog, file);
		}
			catch(Exception e) {
				e.printStackTrace();
		}
		
	}
	
}

package controller.api;

import model.Kliring;
import model.RTGS;
import model.Valuta;
import model.rtgs.TRacun;

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

import service.KliringService;
import service.ValutaService;
import api.constants.RequestMappings;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.KLIRING)
public class KliringAPIController {

	@Autowired
	KliringService service;
	
	@Autowired
	ValutaService valutaService;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public void dodaj(@RequestBody Kliring obj) {
		service.save(new Kliring());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.EXPORT)
	public void export(@RequestBody Kliring obj) {
		
		try {
			File file = new File(System.getProperty("user.home"), "kliring_" + obj.getId_poruke() + ".xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(model.kliring.Kliring.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			model.kliring.Kliring kliring = new model.kliring.Kliring();
			
			kliring.setIDPoruke(obj.getId_poruke());
			kliring.setIznos(new BigDecimal(obj.getUkupan_iznos()));
			kliring.setObracunskiRacunBankeDuznika(obj.getObracunski_racun_banke_duznika());
			kliring.setObracunskiRacunBankePoverioca(obj.getObracunski_racun_banke_poverioca());
			
			if(obj.getId_valute() != null) {
				Valuta valuta = valutaService.findById(Long.parseLong(obj.getId_valute()));
				kliring.setOznakaValute(valuta.getOznaka_valute());
			}
			else
				kliring.setOznakaValute(null);
				
			kliring.setSWIFTBankeDuznika(obj.getSwift_banke_duznika());
			kliring.setSWIFTBankePoverioca(obj.getSwift_banke_poverioca());
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(obj.getDatum_valute());
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			GregorianCalendar c1 = new GregorianCalendar();
			c1.setTime(obj.getDatum_naloga());
			XMLGregorianCalendar date22 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c1);
			
			kliring.setDatumNaloga(date22);
			kliring.setDatumValute(date2);
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(kliring, file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	
}

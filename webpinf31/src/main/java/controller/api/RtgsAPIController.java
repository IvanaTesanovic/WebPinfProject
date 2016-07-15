package controller.api;

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

import api.constants.RequestMappings;
import model.RTGS;
import model.Valuta;
import model.rtgs.TRacun;
import service.RTGSService;
import service.ValutaService;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.RTGS)
public class RtgsAPIController {
	
	@Autowired
	RTGSService service;
	
	@Autowired
	ValutaService valutaService;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public void dodaj(@RequestBody RTGS obj) {
		service.save(new RTGS());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.EXPORT)
	public void export(@RequestBody RTGS obj) {
		
		try {
			File file = new File(System.getProperty("user.home"), "rtgs_" + obj.getId_poruke() + ".xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(model.rtgs.RTGS.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
			model.rtgs.RTGS rtgs = new model.rtgs.RTGS();
			rtgs.setDuznik(obj.getDuznik());
			rtgs.setIDPoruke(obj.getId_poruke());
			rtgs.setIznos(new BigDecimal(obj.getUkupan_iznos()));
			rtgs.setObracunskiRacunBankeDuznika(obj.getObracunski_racun_banke_duznika());
			rtgs.setObracunskiRacunBankePoverioca(obj.getObracunski_racun_banke_poverioca());
			
			if(obj.getId_valute() != null) {
				Valuta valuta = valutaService.findById(Long.parseLong(obj.getId_valute()));
				rtgs.setOznakaValute(valuta.getOznaka_valute());
			}
			else
				rtgs.setOznakaValute(null);
				
			
			rtgs.setPoverilac(obj.getPoverilac());

			TRacun racunDuznika = new TRacun();
			racunDuznika.setBrojModela(new BigInteger(obj.getModel_zaduzenja()));
			racunDuznika.setBrojRacuna(obj.getRacun_duznika());
			racunDuznika.setPozivNaBroj(obj.getPoziv_na_broj_zaduzenja());
			TRacun racunPoverioca = new TRacun();
			racunPoverioca.setBrojModela(new BigInteger(obj.getModel_odobrenja()));
			racunPoverioca.setBrojRacuna(obj.getRacun_poverioca());
			racunPoverioca.setPozivNaBroj(obj.getPoziv_na_broj_odobrenja());
			
			rtgs.setRacunDuznika(racunDuznika);
			rtgs.setRacunPoverioca(racunPoverioca);
			rtgs.setSvrhaPlacanja(obj.getSvrha_placanja());
			rtgs.setSWIFTBankeDuznika(obj.getSwift_banke_duznika());
			rtgs.setSWIFTBankePoverioca(obj.getSwift_banke_poverioca());
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(obj.getDatum_valute());
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			GregorianCalendar c1 = new GregorianCalendar();
			c1.setTime(obj.getDatum_naloga());
			XMLGregorianCalendar date22 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c1);
			
			rtgs.setDatumNaloga(date22);
			rtgs.setDatumValute(date2);
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(rtgs, file);
		}
			catch(Exception e) {
				e.printStackTrace();
		}
		 
	}


}

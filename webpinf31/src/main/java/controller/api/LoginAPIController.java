package controller.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.MimeTypes;
import api.constants.RequestMappings;
import dto.KorisnikDTO;
import model.Korisnik;
import service.KorisnikService;

@RestController
@RequestMapping(RequestMappings.LOGIN_API)
public class LoginAPIController {
	
	@Autowired
	KorisnikService korisnikService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MimeTypes.APPLICATION_JSON)
	public String getString() {
		return "logfdgfgin";
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MimeTypes.APPLICATION_JSON, consumes = MimeTypes.APPLICATION_JSON)
	public Korisnik loginUser(@RequestBody KorisnikDTO korisnikDTO, HttpServletResponse response) {

		if(korisnikService.findByKorisnickoIme(korisnikDTO.getKorisnickoIme()) != null)
			return new Korisnik(korisnikDTO.getKorisnickoIme(), korisnikDTO.getLozinka());
		else
			return null;
	}

}

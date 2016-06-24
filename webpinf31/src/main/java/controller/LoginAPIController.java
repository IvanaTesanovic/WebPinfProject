package controller;

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

@RestController
@RequestMapping(RequestMappings.LOGIN_API)
public class LoginAPIController {
	
	@RequestMapping(method = RequestMethod.GET, produces = MimeTypes.APPLICATION_JSON)
	public String getString() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST/*, produces = MimeTypes.APPLICATION_JSON, consumes = MimeTypes.APPLICATION_JSON*/)
	public ResponseEntity<Korisnik> loginUser(@RequestBody KorisnikDTO korisnikDTO) {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(korisnikDTO.getKorisnickoIme());
		
		if(korisnikDTO != null)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}

package controller.api;

import java.util.List;

import model.Banka;
import model.Drzava;
import model.NaseljenoMesto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import service.BankaService;
import service.DrzavaService;
import service.NaseljenoMestoService;
import api.constants.MimeTypes;
import api.constants.RequestMappings;

@RestController
@RequestMapping(RequestMappings.HOMEPAGE_API)
public class HomePageAPIController {
	
	@Autowired
	DrzavaService drzavaService;
	
	@Autowired
	BankaService bankaService;
	
	@Autowired
	NaseljenoMestoService nasMestaService;
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.DRZAVE, produces = MimeTypes.APPLICATION_JSON)
	public List<Drzava> getDrzave() {
		return drzavaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.BANKE, produces = MimeTypes.APPLICATION_JSON)
	public List<Banka> getBanke() {
		return bankaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = RequestMappings.NASELJENA_MESTA, produces = MimeTypes.APPLICATION_JSON)
	public List<NaseljenoMesto> getNaseljenaMesta() {
		return nasMestaService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = RequestMappings.DRZAVE + RequestMappings.OBRISI + "{id}", produces = MimeTypes.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Validated @PathVariable final Long id) {
//        try {
            final Drzava drzava = new Drzava();
            drzava.setId(id);
//            groupIdentityValidator.validate(group, null);
            drzavaService.deleteRow(id);
//        } catch (final DataIntegrityViolationException e) {
//            throw new DeleteEntityException("deleteError");
//        }
    }
}

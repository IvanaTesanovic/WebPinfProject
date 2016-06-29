package authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Korisnik;
import model.Uloga;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import repository.KorisnikRepository;

/**
 * Customized authentication provider.
 * 
 * @author m.radojcic
 * 
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private KorisnikRepository korisnikRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String) authentication.getPrincipal();
		String credentials = (String) authentication.getCredentials();

		Korisnik korisnik = korisnikRepository.findByKorisnickoIme(username);
		validacijaKorisnika(korisnik, credentials);
		List<GrantedAuthority> authorities = loadAuthorities(korisnik);

		return new UsernamePasswordAuthenticationToken(username, credentials,authorities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	/**
	 * 
	 * @param korisnik
	 * @param credentials
	 */
	private void validacijaKorisnika(Korisnik korisnik, String credentials) {
		if (korisnik == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		if (!validacijaKorisnickeSifre(credentials, korisnik)) {
			throw new BadCredentialsException("Login failed");
		}

	}

	/**
	 * 
	 * @param credentials
	 * @param korisnik
	 * @return
	 */
	private boolean validacijaKorisnickeSifre(String credentials, Korisnik korisnik) {
		boolean returnValue = false;
		if (StringUtils.isNotBlank(korisnik.getLozinka())) {
			returnValue = credentials.equals(korisnik.getLozinka());
		}
		return returnValue;
	}
	
	private List<GrantedAuthority> loadAuthorities(Korisnik korisnik) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Collection<Uloga> uloge = korisnik.getUloge();
		for (Uloga ul : uloge) {
			authorities.add(new SimpleGrantedAuthority(ul.getUloga()));
		}
		return authorities;
	}

}

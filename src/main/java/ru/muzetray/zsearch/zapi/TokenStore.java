package ru.muzetray.zsearch.zapi;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import ru.muzetray.zsearch.services.SearchByArtistService;

@Service
public class TokenStore {
	private String token;

	private SearchByArtistService service;

	public TokenStore(SearchByArtistService service) {
		this.service = service;
	}

	@PostConstruct
	public String getToken() {
		if ( token != null ) {
			return token;
		}
		synchronized (this) {
			if ( token == null ) {
				token = service.getToken();
			}
		}
		return token;
	}
}

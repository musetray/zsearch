package ru.muzetray.zsearch.integration;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.muzetray.zsearch.services.SearchByArtistService;
import ru.muzetray.zsearch.zapi.ZApi;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest

public class SearchByArtistServiceTest {

	@Autowired
	private SearchByArtistService service;
	@Autowired
	private ZApi api;

	@Test
	public void testAutocomplete() {
		JsonNode korn = api.autocomplete( "korn" );
		System.out.println( korn.toString() );
	}

	@Test
	public void testArtist() {
		JsonNode korn = api.artist( 1021L );
		System.out.println( korn.toString() );
	}

	@Test
	public void getToken() {
		String token = service.getToken();
		assertThat( token ).isNotBlank();
		System.out.println( token );
	}

	@Test
	public void getOptions() {
		JsonNode options = service.getOptions();
		assertThat( options ).isNotNull();
		System.out.println( options.toString() );
	}
}
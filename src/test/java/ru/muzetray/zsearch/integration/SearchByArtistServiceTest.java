package ru.muzetray.zsearch.integration;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.muzetray.zsearch.services.SearchByArtistService;
import ru.muzetray.zsearch.zapi.ZApi;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SearchByArtistServiceTest {

	@Autowired
	private SearchByArtistService service;
	@Autowired
	private ZApi api;

	@Test
	public void testAutocomplete() {
		JsonNode korn = api.autocomplete( "korn" );
		log.info( "Response: {}", korn );

	}

	@Test
	public void testArtist() {
		JsonNode korn = api.artist( 1021L );
		log.info( "Response: {}", korn );

	}

	@Test
	public void getToken() {
		String token = service.getToken();
		log.info( "Response: {}", token );

		assertThat( token ).isNotBlank();
	}

	@Test
	public void getOptions() {
		JsonNode options = service.getOptions();
		log.info( "Response: {}", options );
		assertThat( options ).isNotNull();
	}
}
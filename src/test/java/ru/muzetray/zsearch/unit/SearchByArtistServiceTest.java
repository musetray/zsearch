package ru.muzetray.zsearch.unit;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import ru.muzetray.zsearch.services.SearchByArtistService;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class SearchByArtistServiceTest {

	@Test
	public void getClientSecret2() {
		String clientSecret = SearchByArtistService.d( "llf7116f22c" );
		assertThat( clientSecret ).isEqualTo( "HlVMxcYgC" );
	}
}
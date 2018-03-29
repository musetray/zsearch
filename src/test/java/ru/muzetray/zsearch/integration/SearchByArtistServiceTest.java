package ru.muzetray.zsearch.integration;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.muzetray.zsearch.services.SearchByArtistService;
import ru.muzetray.zsearch.zapi.ZaycevApi;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SearchByArtistServiceTest {

    @Autowired
    private SearchByArtistService service;
    @Autowired
    private ZaycevApi api;

    @Test
    public void testAutocomplete() {
        JsonNode korn = api.autocomplete("korn");
        log.info("Response: {}", korn);

    }

    @Test
    public void testArtist() {
        ZaycevApi.ArtistResponse artist = api.artist(1021L);
        assertThat(artist.getArtist().getName()).isEqualTo("30 Seconds to Mars");
    }

    @Test
    public void getToken() {
        String token = service.getToken();
        log.info("Response: {}", token);

        assertThat(token).isNotBlank();
    }

    @Test
    public void getOptions() {
        ZaycevApi.OptionsResponse options = api.options();
        log.info("Response: {}", options);
        assertThat(options).isNotNull();
    }

    @Test
    @Ignore
    public void getDownloadUrl() {
        ZaycevApi.TrackPlayResponse response = api.trackPlay(7069942L);
        assertThat(response.url).endsWith(".mp3");
        log.info("Download url: {}", response.url);

        service.downloadFile(response.url);
    }
}
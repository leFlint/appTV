package fr.epsi.appTV.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import fr.epsi.appTV.services.JSONDeserializer;
import fr.epsi.appTV.models.Serie;
import org.junit.Test;

import org.springframework.test.annotation.Rollback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


public class JSONDeserializerTest {


    JSONDeserializer jsonDeserializer = new JSONDeserializer();

    List<Serie> listeResults = new ArrayList();
    List<String> listGenres = new ArrayList();

    public JSONDeserializerTest() throws IOException {
    }

    @Test
    @Rollback
    public void shouldGetWhenNameSearch() throws JsonParseException, JsonMappingException, Exception {
        listeResults = jsonDeserializer.rechercheParNom("Futurama");
        assertThat(listeResults.contains("249"));
    }

    @Test
    @Rollback
    public void getGenres() throws Exception {
        listGenres = jsonDeserializer.getGenres();
        assertThat(listGenres).isNotNull();
        assertThat(listGenres).contains("Comedy");
        assertThat(listGenres).contains("Animation");
    }

    @Test
    @Rollback
    public void shouldGetWhenGenreSearch() throws JsonParseException, JsonMappingException, Exception  {
        listeResults = jsonDeserializer.rechercheParGenre("Comedy");
        assertThat(listeResults.contains("Futurama"));
    }

    @Test
    @Rollback
    public void rechercheParActeur() throws JsonParseException, JsonMappingException, Exception  {
        listeResults = jsonDeserializer.rechercheParActeur("Winona Ryder");
        assertThat(listeResults.contains("Stranger Things"));

    }

    @Test
    public void tri() throws JsonParseException, JsonMappingException, Exception  {
    }

}
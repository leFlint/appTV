package fr.epsi.appTV.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import fr.epsi.appTV.Acteur;
import fr.epsi.appTV.JSONDeserializer;
import fr.epsi.appTV.Serie;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.annotation.Rollback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.when;


public class JSONDeserializerTest {


    JSONDeserializer jsonDeserializer = new JSONDeserializer();

    List<Serie> listeSeries = new ArrayList();

    public JSONDeserializerTest() throws IOException {
    }

    @Test
    @Rollback
    public void shouldGetWhenNameSearch() throws JsonParseException, JsonMappingException, Exception {
        listeSeries = jsonDeserializer.rechercheParNom("Futurama");
        assertThat(listeSeries.contains("249"));
    }

    @Test
    public void getGenres() throws Exception {

    }

    @Test
    @Rollback
    public void shouldGetWhenGenreSearch() throws JsonParseException, JsonMappingException, Exception  {
        listeSeries = jsonDeserializer.rechercheParGenre("Comedy");
        assertThat(listeSeries.contains("Futurama"));
    }

    @Test
    public void rechercheParActeur() throws JsonParseException, JsonMappingException, Exception  {
        listeSeries = jsonDeserializer.rechercheParActeur("Winona Ryder");
        assertThat(listeSeries.contains("Stranger Things"));

    }

    @Test
    public void tri() throws JsonParseException, JsonMappingException, Exception  {
    }

}
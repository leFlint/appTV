package fr.epsi.appTV.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.epsi.appTV.AppTVApplication;
import fr.epsi.appTV.models.Acteur;
import fr.epsi.appTV.models.Data;
import fr.epsi.appTV.models.Serie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api")
public class JSONDeserializer {

    static Data DATA = null;

    public JSONDeserializer() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream jsonResourceURL = AppTVApplication.class.getResourceAsStream("/data/series.json");
        DATA = mapper.readValue(jsonResourceURL, Data.class);
    }


    @RequestMapping("/rechercheParTitre")
    public List<Serie> rechercheParNom(@RequestParam(required = true) String nom) {
        List<Serie> resultat = new ArrayList();
        for (Serie serie : DATA.getSeries()) {
            if (serie.getSeriesName().toLowerCase().contains(nom.toLowerCase())) {
                resultat.add(serie);
            }
        }
        return resultat;
    }

    @RequestMapping("/getGenres")
    public List<String> getGenres() {
        List<String> resultat = new ArrayList();
        for (Serie serie : DATA.getSeries()) {
            for (String g : serie.getGenre()) {
                resultat.add(g);
            }
        }
        return resultat;
    }

    @RequestMapping("/rechercheParGenre")
    public List<Serie> rechercheParGenre(@RequestParam(required = true, name = "genre") String genreRecherche) {
        List<Serie> resultat = new ArrayList();
        for (Serie serie : DATA.getSeries()) {
            for (String genre : serie.getGenre()) {
                if (genre.toLowerCase().contains(genreRecherche.toLowerCase())) {
                    resultat.add(serie);
                }
            }
        }
        return resultat;
    }

    @RequestMapping("/rechercheParActeur")
    public List<Serie> rechercheParActeur(@RequestParam(required = true, name = "acteur") String acteurRecherche) {
        List<Long> idSeries = new ArrayList();
        List<Serie> resultat = new ArrayList();
        for (Acteur acteur : DATA.getActors()) {
            if (acteur.getName().toLowerCase().contains(acteurRecherche.toLowerCase())) {
                idSeries.add(acteur.getSeriesId());
            }
        }
        for (Serie serie : DATA.getSeries()) {
            if (idSeries.contains(serie.getId())) {
                resultat.add(serie);
            }
        }
        return resultat;
    }

    @RequestMapping("/tri")
    public List<Serie> tri(
            @RequestParam(required = false, name = "alpha", defaultValue = "0") boolean alphabetique,
            @RequestParam(required = false, name = "note", defaultValue = "0") boolean note) {
        List<Serie> resultat = new ArrayList(Arrays.asList(DATA.getSeries()));
        if (alphabetique) {
            Collections.sort(resultat, new Comparator<Serie>() {

                @Override
                public int compare(Serie s1, Serie s2) {
                    return s1.getSeriesName().compareTo(s2.getSeriesName());
                }
            });
        }
        if (note) {
            Collections.sort(resultat, new Comparator<Serie>() {

                @Override
                public int compare(Serie s1, Serie s2) {
                    return Double.valueOf(s2.getSiteRating()).compareTo(s1.getSiteRating());
                }
            });
        }
        return resultat;
    }

}


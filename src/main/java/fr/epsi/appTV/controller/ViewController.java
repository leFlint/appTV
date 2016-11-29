package fr.epsi.appTV.controller;


import fr.epsi.appTV.services.JSONDeserializer;
import fr.epsi.appTV.models.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    JSONDeserializer api;

    @RequestMapping("/")
    public ModelAndView view(@RequestParam(value = "rechercheParTitre", required = false) String nomRecherche,
                              @RequestParam(value = "rechercheParGenre", required = false) String genreRecherche,
                              @RequestParam(value = "rechercheParActeur", required = false) String acteurRecherche,
                              @RequestParam(required = false, name = "triAlpha", defaultValue = "0") boolean triAlphabetique,
                              @RequestParam(required = false, name = "triNote", defaultValue = "0") boolean triNote,
                              Map<String, Object> model) {
        List<Serie> resultats = api.tri(triAlphabetique, triNote);
        if (nomRecherche != null && !nomRecherche.isEmpty()) {
            buildResultat(resultats, api.rechercheParNom(nomRecherche));
        }
        if (genreRecherche != null && !genreRecherche.isEmpty()) {
            buildResultat(resultats, api.rechercheParGenre(genreRecherche));
        }
        if (acteurRecherche != null && !acteurRecherche.isEmpty()) {
            buildResultat(resultats, api.rechercheParActeur(acteurRecherche));
        }
        model.put("resultats", resultats);
        model.put("genres", api.getGenres());
        return new ModelAndView("view", model);
    }

    private void buildResultat(List<Serie> resultatFinal, List<Serie> resultats) {
        if (resultatFinal.isEmpty()) {
            resultatFinal.addAll(resultats);
        } else {
            Iterator<Serie> it = resultatFinal.iterator();
            while (it.hasNext()) {
                if (!resultats.contains(it.next())) {
                    it.remove();
                }
            }
        }
    }

}

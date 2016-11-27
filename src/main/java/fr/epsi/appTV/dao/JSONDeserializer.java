package fr.epsi.appTV.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.epsi.appTV.models.Serie;

import java.util.List;


public class JSONDeserializer {
    public static final String JSON_PATH = "/resources/db/series.json";

    Gson gson = new GsonBuilder().create();
    List<Serie> serie = gson.fromJson(JSON_PATH, List.class);

}

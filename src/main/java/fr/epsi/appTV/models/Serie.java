package fr.epsi.appTV.models;



import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Serie {

    private long id;
    private String nom;
    private List<Genre> genres;
    private List<Acteur> acteurs;
    private int note;
}

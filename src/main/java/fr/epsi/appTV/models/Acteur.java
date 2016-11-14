package fr.epsi.appTV.models;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Acteur {

    private long id;
    private String nom;
    private String nickname;
    private long serieId;
}

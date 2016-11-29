package fr.epsi.appTV.models;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Acteur {

    private long id;
    private long seriesId;
    private String name;
    private String role;
    private long sortOrder;
    private String image;
    private long imageAuthor;
    private String imageAdded;
    private String lastUpdated;

}

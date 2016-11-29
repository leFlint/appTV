package fr.epsi.appTV.models;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Data {

    private Serie series[];
    private Acteur actors[];

}

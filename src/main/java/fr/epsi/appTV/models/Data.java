package fr.epsi.appTV;


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

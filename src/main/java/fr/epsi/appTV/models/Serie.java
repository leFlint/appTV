package fr.epsi.appTV.models;



import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Serie {

    private long id;
    private String seriesName;
    private String overview;
    private double siteRating;
    private String[] aliases;
    private String banner;
    private long seriesId;
    private String status;
    private String firstAired;
    private String network;
    private String networkId;
    private String runtime;
    private String[] genre;
    private long lastUpdated;
    private String airsDayOfWeek;
    private String airsTime;
    private String rating;
    private String imdbId;
    private String zap2itId;
    private String added;
    private long siteRatingCount;
    private long addedBy;
}

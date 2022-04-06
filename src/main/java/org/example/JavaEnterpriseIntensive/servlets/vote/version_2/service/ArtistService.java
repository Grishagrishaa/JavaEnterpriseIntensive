package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistService {

    private static ArtistService instance;

    private ArtistService(){}

    private List<String> artists = new ArrayList<>(Arrays.asList(
            "Представитель группы ЛЕС", "Меладзе", "Бурановские Бабушки", "Eminem"
    ));

    public List<String> getArtists() {
        return artists;
    }

    public void add(String artist){
        artists.add(artist);
    }

    public boolean isPart(int artistNumber){
        return (artistNumber <= artists.size() && artistNumber > 0);
    }

    public static ArtistService getInstance(){
        if(instance == null){
            instance = new ArtistService();
        }
        return instance;
    }

}


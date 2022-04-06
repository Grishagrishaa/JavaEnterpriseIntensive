package org.example.JavaEnterpriseIntensive.servlets.vote.version_ilya.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtistsService {

    private static final ArtistsService instance = new ArtistsService();

    private List<String> artists = new ArrayList<>(Arrays.asList(
            "Круг", "Evanessence", "Eminem", "Бах"
    ));

    private ArtistsService() {
    }

    public List<String> getArtists(){
        return artists;
    }

    public void add(String artist){
        artists.add(artist);
    }

    public boolean isExist(int index){
        int size = artists.size();
        return index >= 0 && index < size;
    }

    public static ArtistsService getInstance() {
        return instance;
    }
}

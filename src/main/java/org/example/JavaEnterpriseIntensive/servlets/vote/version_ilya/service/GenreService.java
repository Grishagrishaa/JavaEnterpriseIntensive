package org.example.JavaEnterpriseIntensive.servlets.vote.version_ilya.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreService {

    private static final GenreService instance = new GenreService();

    private List<String> genre = new ArrayList<>(Arrays.asList(
            "Частушки", "Реп", "Рок", "ХиП-ХоП",
            "Клаssика", "Джаз", "Блюз", "....."
    ));

    private GenreService() {
    }

    public List<String> getGenres(){
        return genre;
    }

    public void add(String genre){
        this.genre.add(genre);
    }

    public boolean isExist(int index){
        int size = genre.size();
        return index >= 0 && index < size;
    }

    public static GenreService getInstance() {
        return instance;
    }
}

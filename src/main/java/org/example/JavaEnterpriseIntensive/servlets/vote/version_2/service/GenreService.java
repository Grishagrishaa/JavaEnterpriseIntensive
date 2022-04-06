package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreService {
    private static GenreService instance;

    private GenreService(){}

    private List<String> genList = new ArrayList<>(Arrays.asList(
            "Поп-музыка",
            "Классическая музыка",
            "Рок",
            "Блюз",
            "Ритм-н-блюз (R’n’B)",
            "Блюз",
            "Шансон",
            "Электро",
            "Хип-хоп",
            "Метал"
    ));

    public List<String> getGenList() {
        return genList;
    }

    public void add(String genre){
        genList.add(genre);
    }

    public boolean isPart(int[] GenreNumbers){
        for (int genreNumber : GenreNumbers) {
            if(!(genreNumber > 0 && genreNumber <= genList.size())){
                return false;
            }
        }
        return true;
    }


    public static GenreService getInstance(){
        if(instance == null){
            instance = new GenreService();
        }
        return instance;
    }
}

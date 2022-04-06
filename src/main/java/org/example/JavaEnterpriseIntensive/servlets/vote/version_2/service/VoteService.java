package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.core.dto.VoteDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteService {

    private static VoteService instance;

    private ArtistService arService = ArtistService.getInstance();
    private GenreService genService = GenreService.getInstance();
    private List<VoteDto> voteBox = new ArrayList<>();


    private Map<String, Integer> topArtists = new HashMap<>();
    private Map<String, Integer> topGenres = new HashMap<>();

    private VoteService(){}


    public void check(VoteDto voteList){

    if(voteList.getGenres().length < 3 && voteList.getGenres().length > 5){//ПРОВЕРКА КОЛИЧЕСТВА УКАЗАННЫХ ЖАНРОВ
        throw new IllegalArgumentException("Неверное количество жанров");
    }

    if (!genService.isPart(voteList.getGenres())){//ПРОВЕРКА ВАЛИДНОСТИ ЖАНРА
        throw new IllegalArgumentException("Нет такого жанра");
    }


    if (!arService.isPart(voteList.getArtist())){//ПРОВЕРКА ВАЛИДНОСТИ АРТИСТА
        throw new IllegalArgumentException("Нет такого артиста");
        }
    }

    public void save(VoteDto voteList){
        check(voteList);
        voteBox.add(voteList);

    }

    public Map<String, Integer> getTopArtists() {
        List<String> artistsList = arService.getArtists();

        for (VoteDto voteList : voteBox) {
            String key = artistsList.get(voteList.getArtist()-1);

            if(!topArtists.containsKey(key)){
                topArtists.put(key, 1);
            }else{
                topArtists.replace(key, topArtists.get(key),topArtists.get(key) + 1 );
            }
        }
        return topArtists;
    }


    public Map<String, Integer> getTopGenres() {
        List<String> genresList = genService.getGenList();
        for (VoteDto voteList : voteBox) {
            int[] selectedGenres = voteList.getGenres();
            for (int index : selectedGenres) {
                String key = genresList.get(index);
                if(!topGenres.containsKey(key)){
                    topGenres.put(key,1);
                }else{
                    topGenres.replace(key, topGenres.get(key),topGenres.get(key) + 1 );
                }
            }
        }
        return topGenres;
    }

    public List<String> getBioList(){
        List<String> bioList = new ArrayList<>();
        for (VoteDto voteList : voteBox) {
            bioList.add(voteList.getBio());
        }
        return bioList;
    }


    public int[] stringToInt(String[] strArray){
        int[] intArray = new int[strArray.length];
        for (int i = 0; i <strArray.length ; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static VoteService getInstance(){
        if(instance == null){
            instance = new VoteService();
        }
        return instance;
    }
}

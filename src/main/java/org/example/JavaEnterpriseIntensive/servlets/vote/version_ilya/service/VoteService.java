package org.example.JavaEnterpriseIntensive.servlets.vote.version_ilya.service;


import org.example.JavaEnterpriseIntensive.servlets.vote.version_ilya.core.dto.VoteDto;

public class VoteService {

    private static final VoteService instance = new VoteService();

    private ArtistsService artistsService;
    private GenreService genreService;

    private VoteService() {
        this.artistsService = ArtistsService.getInstance();
        this.genreService = GenreService.getInstance();
    }

    public void check(VoteDto vote){
        if(vote.getGenres().length < 3 || vote.getGenres().length > 5){
            throw new IllegalArgumentException("Жанров слишком мало! или много!");
        }
        if(!this.artistsService.isExist(vote.getArtist())){
            throw new IllegalArgumentException("Такого артиста не существует");
        }
        for (int genre : vote.getGenres()) {
            if(!this.genreService.isExist(genre)){
                throw new IllegalArgumentException("Такого жанра не существует");
            }
        }
    }

    public void save(VoteDto vote){
        check(vote);

    }

    public static VoteService getInstance() {
        return instance;
    }
}

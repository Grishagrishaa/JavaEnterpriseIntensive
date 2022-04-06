package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.core.dto;

public class VoteDto {
    private int artist;
    private int[] genres;
    private String bio;

    public VoteDto(int artist, int[] genres, String bio) {
        this.artist = artist;
        this.genres = genres;
        this.bio = bio;
    }

    public int getArtist() {
        return artist;
    }

    public void setArtist(int artist) {
        this.artist = artist;
    }

    public int[] getGenres() {
        return genres;
    }

    public void setGenres(int[] genres) {
        this.genres = genres;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

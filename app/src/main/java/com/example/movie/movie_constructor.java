package com.example.movie;

public class movie_constructor {

    private String original_title;
    private String release_date;
    private String poster_path;


    public movie_constructor(String original_title, String release_date, String poster_path) {
        this.original_title = original_title;
        this.release_date = release_date;
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}

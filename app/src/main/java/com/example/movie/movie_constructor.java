package com.example.movie;

public class movie_constructor {

    private String original_title;
    private String release_date;
    private String poster_path;
    private String original_language;
    private String vote_average;
    private String overview;

    // all item coanstructor

    public movie_constructor (String original_title, String release_date, String poster_path, String original_language, String vote_average, String overview) {
        this.original_title = original_title;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.vote_average = vote_average;
        this.overview = overview;
    }

    //old constructor
//    public movie_constructor(String original_title, String release_date, String poster_path) {
//        this.original_title = original_title;
//        this.release_date = release_date;
//        this.poster_path = poster_path;
//    }


    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    //old gatter setter with three items
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

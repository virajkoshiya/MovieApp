package com.example.movie;

public class movie_cons_fav {

    private String original_title;
    private String release_date;
    private String poster_path;
    private String getOriginal_language;
    private String getVote_average;
    private String getOverview;

    public movie_cons_fav(String original_title, String release_date, String poster_path, String getOriginal_language, String getVote_average, String getOverview) {
        this.original_title = original_title;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.getOriginal_language = getOriginal_language;
        this.getVote_average = getVote_average;
        this.getOverview = getOverview;
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

    public String getGetOriginal_language() {
        return getOriginal_language;
    }

    public void setGetOriginal_language(String getOriginal_language) {
        this.getOriginal_language = getOriginal_language;
    }

    public String getGetVote_average() {
        return getVote_average;
    }

    public void setGetVote_average(String getVote_average) {
        this.getVote_average = getVote_average;
    }

    public String getGetOverview() {
        return getOverview;
    }

    public void setGetOverview(String getOverview) {
        this.getOverview = getOverview;
    }
}
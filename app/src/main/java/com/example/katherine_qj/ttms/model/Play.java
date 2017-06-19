package com.example.katherine_qj.ttms.model;

/**
 * Created by katherine on 6/6/17.
 */

public class Play {
    private int  play_id;
    private int  studio_id;
    private String  play_start;
    private String  play_end;
    private  int film_id;
    private String  film_name;

    public int getPlay_id() {
        return play_id;
    }

    public void setPlay_id(int play_id) {
        this.play_id = play_id;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public String getPlay_start() {
        return play_start;
    }

    public void setPlay_start(String play_start) {
        this.play_start = play_start;
    }

    public String getPlay_end() {
        return play_end;
    }

    public void setPlay_end(String play_end) {
        this.play_end = play_end;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }
}

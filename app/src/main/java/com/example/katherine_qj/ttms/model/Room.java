package com.example.katherine_qj.ttms.model;

/**
 * Created by katherine on 6/7/17.
 */

public class Room {
    private int studio_id;
    private String studio_name;
    private int studio_row_count;
    private int studio_col_count;
    private int studio_flag;

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public String getStudio_name() {
        return studio_name;
    }

    public void setStudio_name(String studio_name) {
        this.studio_name = studio_name;
    }

    public int getStudio_row_count() {
        return studio_row_count;
    }

    public void setStudio_row_count(int studio_row_count) {
        this.studio_row_count = studio_row_count;
    }

    public int getStudio_col_count() {
        return studio_col_count;
    }

    public void setStudio_col_count(int studio_col_count) {
        this.studio_col_count = studio_col_count;
    }

    public int getStudio_flag() {
        return studio_flag;
    }

    public void setStudio_flag(int studio_flag) {
        this.studio_flag = studio_flag;
    }
}

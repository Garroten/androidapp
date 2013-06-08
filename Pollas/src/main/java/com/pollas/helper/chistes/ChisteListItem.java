package com.pollas.helper.chistes;

/**
 * Created by rafaelgarrote on 08/06/13.
 */
public class ChisteListItem {
    private int idImage;
    private String title;
    private String text;

    public ChisteListItem(int idImage, String title, String text) {
        this.idImage = idImage;
        this.title = title;
        this.text = text;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

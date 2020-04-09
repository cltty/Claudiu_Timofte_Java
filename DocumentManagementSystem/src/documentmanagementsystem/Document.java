/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentmanagementsystem;

import java.io.Serializable;

/**
 *
 * @author Claudiu
 */
public class Document implements Serializable {
    private int id;
    private String type;
    private String title;
    private String author;
    private String coAuthor;
    private String value;
    
    public Document() {}
    
    public Document(int id, String type, String title, String author, String coAuthor, String value) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.author = author;
        this.coAuthor = coAuthor;
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCoAuthor(String coAuthor) {
        this.coAuthor = coAuthor;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setTitle(String title) {
        this.name = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }
    
    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getCoAuthor() {
        return coAuthor;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Document[id: " + this.id + ", type:" + this.type + ", title:" + this.title + ", author:" + this.author + ", coAuthor:"+ this.coAuthor + ", value:"+ this.value;
    }
    
    
}
}

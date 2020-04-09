/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

/**
 *
 * @author Claudiu
 */
public class Album {
    int id;
    int artId;
    int releaseYear;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelease_year(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }
    
    
}

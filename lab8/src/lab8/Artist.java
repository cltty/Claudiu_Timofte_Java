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
public class Artist {
    int id;
    String Name;
    String country;
    
    public Artist(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return country;
    }
    
    .
    
}

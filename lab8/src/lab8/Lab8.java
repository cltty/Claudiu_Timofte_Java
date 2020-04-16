/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;


import java.sql.*;
/**
 *
 * @author Claudiu
 */
public class Lab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) Throws SQLException {
        ArtistController ac = new ArtistController(Database.getDatabaseInstance("jdbc:oracle:thin:@localhost:1521:XE", "STUDENT", "student"));
        AlbumController ab = new AlbumController(Database.getDatabaseInstance("jdbc:oracle:thin:@localhost:1521:XE", "STUDENT", "student"));
        Artist artist = new Artist(1, "Johhny", "America");
        Album album = new Album(1, 1, 2002, "New Album");
        
        ac.addArtist(artist);
    }
    
}

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
public class ArtistController {
    private Connection connection;
    
    public ArtistController(Database databaseInstance){
        this.connection = databaseInstance.connection;
    }
    
    public void addArtist(Artist artistToAdd) {
        String sqlFindMaxID = "SELECT max(id) FROM artisti";
        int maxID = -1;
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlFindMaxID);

            if (true == rs.next()) {
                maxID = rs.getInt(1);
                System.out.println("ID MAXIM : " + maxID);
            }
            maxID ++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String sql = "INSERT INTO artisti VALUES(?, ?, ?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, maxID);
            prepStmt.setString(2, artistToAdd.getNume());
            prepStmt.setString(3, artistToAdd.getCountry());
            
            
            prepStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Artist findArtistByName(String name) {
        String sql = "SELECT * FROM artisti WHERE NAME = ?";
        Artist artist = null;
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);     
            ResultSet rs = stmt.executeQuery();
            
            if (true == rs.next()) {
                artist = new Artist(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return artist;
    }    
}

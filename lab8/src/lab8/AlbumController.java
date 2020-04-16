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

import java.sql.*;

public class AlbumController {
    private Connection connection;

    public AlbumController(Database databaseInstance) {
       this.connection = databaseInstance.connection;
    }

    public void addAlbum(Album albumToAdd) throws SQLException {
        String sqlFindMaxID = "SELECT max(id) FROM albume";
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
        
        String sql = "INSERT INTO albume VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setInt(1, maxID);
            prepStmt.setInt(2, albumToAdd.getArtId());
            prepStmt.setInt(3, albumToAdd.getReleaseYear());
            prepStmt.setString(4, albumToAdd.getName());
            
            prepStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Album findAlbumByArtist(Artist artist) {
        String sql = "SELECT * FROM albume WHERE artist_id = ?";
        Album album = null;
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, artist.getId());     
            ResultSet rs = stmt.executeQuery();
            
            if (true == rs.next()) {
                album = new Album(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return album;
    }

}

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
public class ArtistController {
    List<Array> artists;
    
    public ArtistController() throws SQLException {
        Database db = new Database();
        Connection dbConn = dbConn.createConnection("myDB", "");
        Statement stmt = dbConn.createStatement();
        ResultSet rows = stmt.executeQuery("SELECT * FROM artists");
        
        while (true == rows.next()) {
            Artist artist = new Artist(rows.getInt(1), rows.getString(2), rows.getString(3));
            artists.add(artist);
        }
    }
    
    public void create(String name, String country) throws SQLException {
        Database db = new Database();
        Connection dbConn = dbConn.createConnection("myDB", "");
        Statement stmt = dbConn.createStatement();
        Artist artist = new Artist(artists.size() + 1, name, country);
        artists.add(artist);
        stmt.executeUpdate("INSERT INTO artists values(" + (artists.size() + 1) + ", " + name + ", " + country + ")");
    }
    
    
}

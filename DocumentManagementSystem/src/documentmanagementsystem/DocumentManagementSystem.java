/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentmanagementsystem;

package java.beans;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Claudiu
 */


public class DocumentManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Document a = new Document(1, "Article", "Modern Lifestyle", "Johnny", "Kevin", "0$");
        Document b = new Document(2, "Book", "Harry Potter", "JK Rowling", "", "50$");
        
        Catalog c = new Catalog();

        c.addDoc(b);
        c.addDoc(a);

        HandleCatalog handler = new HandleCatalog(c);
        
        //save()
        handler.save("catalog.txt");
        
        //load()
        System.out.println("Loaded documents:");
        Catalog loadedObject = new Catalog();
        loadedObject = handler.load("catalog.txt");
        System.out.println(loadedObject);

        /*
        *view()
        *String path = "c:\\bdlog.txt";
        *handler.view(path);
        */
        
        handler.view();// will open nothingToSee.txt
    }
}

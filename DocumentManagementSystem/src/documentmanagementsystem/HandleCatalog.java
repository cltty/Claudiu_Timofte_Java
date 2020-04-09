/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentmanagementsystem;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Claudiu
 */
public class HandleCatalog {

    private Catalog catalog;

    public HandleCatalog() {
    }

    public HandleCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void save(String filename) {  
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(filename));
            objOutput.writeObject(this.catalog);
            objOutput.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void save() {
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream("default1.ser"));
            objOutput.writeObject(this.catalog);
            objOutput.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Catalog load(String filename) {
        try {
            if (filename.equals(".")) {
                throw new MyException("Forbidden character!");
            }
        } catch (MyException e) {
            e.getStackTrace();
            //System.out.println("smth went wrong");
            return null;
        }
        
        try {
            ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(filename));
            Catalog tmp = new Catalog();
            tmp = (Catalog) objInput.readObject();
            objInput.close();
            return tmp;
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            return null;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
    
    public void view() {
        try {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            desktop.open(new File("nothingToSee.txt"));
        } catch(FileNotFoundException e) {
            e.getStackTrace();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
    
    public void view(String fullPath) {
        try {
            if (filename.equals(".")) {
                throw new MyException("Forbidden character!");
            }
        } catch (MyException e) {
            e.getStackTrace();
            //System.out.println("smth went wrong");
            return null;
        }
        try {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            desktop.open(new File(fullPath));
            //desktop.open(new File("c:\\bdlog.txt"));
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

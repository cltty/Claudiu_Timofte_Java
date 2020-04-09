/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentmanagementsystem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Claudiu
 */
public class Catalog implements Serializable {
   private List<Object> docs = new ArrayList<Object>();
   
   public Catalog() {}
   
   public void addDoc(Document doc) {
       docs.add(doc);
   }
   
   @Override
   public String toString() {
       String result = "";
       for (Object index: docs) {
           result += index.toString();
           result += "\n";
       }
       return result;
   }
}

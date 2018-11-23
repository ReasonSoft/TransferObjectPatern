/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uttt.busines;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mx.edu.uttt.transfer.peliculasVO;
import mx.edu.uttt.bd.control.controlPelicula;

/**
 *
 * @author crist
 */
public class peliculaBO {
List<peliculasVO> peli;
    public peliculaBO() {
        
    }
    
    public void deletePeliculas(peliculasVO pelicula){
        
        JOptionPane.showMessageDialog(null, "Se eliminó la pelicula: "+pelicula.getTitulo());
    }
   public ArrayList<peliculasVO> getAllPeliculasVO(){
       controlPelicula cPeli=new controlPelicula();
       
    return cPeli.consultarTodo();
    }
   public void updatePelicula(peliculasVO pelicula){
   JOptionPane.showMessageDialog(null,"Se actualizó la pelicula: "+pelicula.getTitulo() );
    }
   public void addPelicula(peliculasVO pelicula){
       controlPelicula cPeli=new controlPelicula();
        if (cPeli.insertar(pelicula)) {
         JOptionPane.showMessageDialog(null,"Se agregó la pelicula: "+pelicula.getTitulo(),"Info",JOptionPane.INFORMATION_MESSAGE);   
        }else{
        JOptionPane.showMessageDialog(null, "No se agregó la pelicula: "+pelicula.getTitulo(),"Error",JOptionPane.ERROR_MESSAGE);
        }
   
   }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uttt.bd.operasiones;

import java.util.ArrayList;

/**
 *
 * @author crist
 */
public interface operasiones {
     boolean insertar (Object obj);
     
    boolean eliminar (Object obj);
    
    boolean actualizar (Object obj);
    
     ArrayList<Object> consultarTodo();
}

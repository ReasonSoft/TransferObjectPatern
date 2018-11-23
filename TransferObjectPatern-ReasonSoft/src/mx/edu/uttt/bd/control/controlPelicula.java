/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uttt.bd.control;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.edu.uttt.bd.conexion.conexion;
import mx.edu.uttt.transfer.peliculasVO;
import mx.edu.uttt.bd.operasiones.operasiones;
/**
 *
 * @author crist
 */
public class controlPelicula extends conexion implements operasiones{

    @Override
    public boolean insertar(Object obj) {
        peliculasVO peli=(peliculasVO)(obj);
        String query="insert into tablapelicula values(?,?,?,?,?)";
        try{
            Connection con=super.obtenerConexion();
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getGenero());
            ps.setString(3, peli.getDescripcion());
            ps.setDouble(4, peli.getPrecio());
            ps.setInt(5, peli.getStock());
            ps.executeUpdate();
            System.out.println(ps);
            return true;
        }catch(Exception e){
        e.getMessage();
        return false;
        }
    }

    @Override
    public boolean eliminar(Object obj) {
peliculasVO peli=(peliculasVO)(obj);
        String query="delete from tablapelicula where id=?";
        try{
            Connection con=super.obtenerConexion();
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, peli.getId());
            ps.executeUpdate();
            System.out.println(ps);
            return true;
        }catch(Exception e){
        e.getMessage();
        return false;
        }
    }

    @Override
    public boolean actualizar(Object obj) {
peliculasVO peli=(peliculasVO)(obj);
        String query="UPDATE tablapelicula SET Titulo=?, Genero=?, Descripcion=?, Precio=?, Stock=? where id =?";
        try{
            Connection con=super.obtenerConexion();
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getGenero());
            ps.setString(3, peli.getDescripcion());
            ps.setDouble(4, peli.getPrecio());
            ps.setInt(5, peli.getStock());
            ps.setInt(6, peli.getId());
            ps.executeUpdate();
            System.out.println(ps);
            return true;
        }catch(Exception e){
        e.getMessage();
        return false;
        }
    }    

    @Override
    public ArrayList<peliculasVO> consultarTodo() {
        ArrayList<Object> peliL=new ArrayList<Object>();
        PreparedStatement cst;
        Connection con=super.obtenerConexion();
        ResultSet rs;
        try {
            cst=con.prepareStatement("select * from tablapelicula");
            rs=cst.executeQuery();
            System.out.println(cst+" "+rs);
            while(rs.next()){
               peliculasVO peli=new peliculasVO();
              
            peli.setId(rs.getInt(1));
            peli.setTitulo(rs.getString(2));
            peli.setGenero(rs.getString(3));
            peli.setDescripcion(rs.getString(4));
            peli.setPrecio(rs.getDouble(5));
            peli.setStock(rs.getInt(6));
            
            peliL.add(peli);
            
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
    return peliL; 
    }
    
}

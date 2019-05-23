package producto.dao;

import conexion.ConexionBD;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import producto.dominio.Producto;

public class ProductoDAOImp implements ProductoDAO {

    @Override
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        //definir un formato numero segun la region
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRANCE);
        Number numero;
        String lineDatos;
        
        try( BufferedReader archivo= Files.newBufferedReader(Paths.get("producto2.txt"))) {
            while(archivo.readLine() != null){
                
                archivo.readLine();
                lineDatos=archivo.readLine().trim();
                numero= formatoNumero.parse(lineDatos);
                int codigo=numero.intValue();
                archivo.readLine();
                lineDatos=archivo.readLine().trim();
                String nombre= lineDatos;
                archivo.readLine();
                lineDatos=archivo.readLine().trim();
                String descripcion= lineDatos;
                archivo.readLine();
                lineDatos=archivo.readLine().trim();
                numero=formatoNumero.parse(lineDatos);
                double precio = numero.doubleValue();
                Producto pro = new Producto(codigo,nombre,descripcion,precio);
                productos.add(pro);
            }
        } catch (ParseException e) {
         System.out.println("exce");
        }catch(IOException ex){
            System.out.println("exce");
        }
       
        
        return  productos;
        
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
public void reescribirproducto(List<Producto> product){
/*Escribir fichero */
}
}

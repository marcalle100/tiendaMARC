package app.principal;

import empleado.dao.EmpleadoDAOImp;
import empleado.dominio.Empleado;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;
import tienda.control.GestionTienda;

public class MainApp {

    public static void main(String[] args) {
        
        GestionTienda gestionTienda = new GestionTienda();
        gestionTienda.iniciar();
       // ProductoDAOImp test = new ProductoDAOImp();
        
      //  for (Producto leerProducto : test.leerProductos()) {
      //      System.out.println(leerProducto.toString());
      //  }
        /*    EmpleadoDAOImp emple = new EmpleadoDAOImp();
            
           for (Empleado leerEmpleado : emple.leerEmpleados()) {
               System.out.println(leerEmpleado.toString());
        }*/
        
    }

}

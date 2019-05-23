package producto.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;

public class GestionaProductos {
    private List<Producto> factura = new ArrayList<>();
    ProductoDAOImp productoDAOImp = new ProductoDAOImp();
public void añadirproducto(int opcion){
    ProductoDAOImp test = new ProductoDAOImp();
    Producto productodeseado = test.leerProductos().get(opcion);
    factura.add(productodeseado);
}
public void visualizarpreciototal(int opcion){
    double preciototal=0.0;
    for (Producto producto : factura) {
        preciototal+=producto.getPrecio();
       
        
    }
    System.out.println("precio de la factura "+preciototal);
}
public void imprimirfactura(int opcion){
    System.out.println("factura");
    for (Producto producto : factura) {
        System.out.println(producto.toString());
    }
}
public void modificarnombre(int opcion){
    System.out.println("Introduce nuevo nombre");
    Scanner lector = new Scanner (System.in);
    String nuevonombre= lector.next();
    ProductoDAOImp test = new ProductoDAOImp();
    test.leerProductos().get(opcion).setNombre(nuevonombre);
    productoDAOImp.reescribirproducto(test.leerProductos());
    
}
public void modificarcodigo (int opcion){
       System.out.println("Introduce nuevo codigo");
    Scanner lector = new Scanner (System.in);
    int nuevocodigo= lector.nextInt();
    ProductoDAOImp test = new ProductoDAOImp();
    test.leerProductos().get(opcion).setCodigo(nuevocodigo);
    productoDAOImp.reescribirproducto(test.leerProductos());
    
}
public void modificarprecio(int opcion){
    System.out.println("Introduce nuevo precio");
    Scanner lector = new Scanner (System.in);
    double nuevoprecio= lector.nextInt();
    ProductoDAOImp test = new ProductoDAOImp();
    test.leerProductos().get(opcion).setPrecio(nuevoprecio);
    productoDAOImp.reescribirproducto(test.leerProductos());
}

}

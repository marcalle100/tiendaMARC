package empleado.dao;

import conexion.ConexionBD;
import empleado.dominio.Empleado;
import java.sql.SQLException;
import java.util.List;
import empleado.dao.EmpleadoDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import producto.dominio.Producto;

public class EmpleadoDAOImp implements EmpleadoDAO {

    public static void reescribirpasswod(List<Empleado> leerEmpleados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        //definir un formato numero segun la region
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRANCE);
        Number numero;
        String lineDatos;

        try (var archivo = Files.newBufferedReader(Paths.get("empleado4.txt"))) {
            while ((archivo.readLine()) != null) {
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineDatos);
                int codigo = numero.intValue();

                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                String nombre = lineDatos;

                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                String apellidos = lineDatos;

                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                String contraseña = lineDatos;

                Empleado empleado = new Empleado(codigo, nombre, apellidos, contraseña);
                empleados.add(empleado);
            }
        } catch (ParseException | IOException e) {
            System.out.println("ex");
        }

        return empleados;

    }

    @Override
    public Empleado getEmpleadoPorCodigo(int codigo) {
        Empleado empleado = null;
        String query = "SELECT * FROM empleados where e_codigo = " + codigo;

        try (
                var conexion = ConexionBD.conectar();
                var sentencia = conexion.createStatement();
                var resultado = sentencia.executeQuery(query)) {

            resultado.next();
            var code = resultado.getInt("e_codigo");
            var nombre = resultado.getString("e_nombre");
            var apellidos = resultado.getString("e_apellidos");
            var password = resultado.getString("e_password");
            empleado = new Empleado(codigo, nombre, apellidos, password);

        } catch (SQLException e) {
            System.out.println("Error al cargar empleado con el codigo " + codigo);
        }

        return empleado;
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
public void reescribirpassword(List<Empleado> emple){
/*Escribir fichero */
}
}

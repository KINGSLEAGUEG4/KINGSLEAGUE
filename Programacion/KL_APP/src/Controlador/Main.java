package Controlador;

import Modelo.BaseDato;
import Modelo.TUsuarios;
import Modelo.Usuario;
import Vista.vLogin;
import Vista.vPrincipal;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author
 * @version 1.0
 */
public class Main {

    private static JFrame vPrincipal;
    private static JFrame vLogin;
    private static JFrame vEquipos;
    private static JFrame vClasificacion;
    private static JFrame vPartidos;
    private static Usuario usuario;
    public static void main(String[] args){
        // Test para probar conexion con la base de datos
        /*
        try {
            BaseDato.abrirConexion();
            PreparedStatement ps = BaseDato.getCon().prepareStatement("Select * from Jugadores");
            ResultSet resultado = ps.executeQuery();
            while (resultado.next())
                System.out.println(resultado.getString("nombre"));
        } catch (Exception e){
            System.out.println("Error");
        } */
        crearVentanaLogin();
    }
    public static void crearVentanaLogin(){
        vLogin = new JFrame("vLogin");
        vLogin.setContentPane(new vLogin().getpPrincipal());
        vLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vLogin.pack();
        vLogin.setVisible(true);
    }

    public static void crearVentanaPrincipal(String admin) {
        vLogin.dispose();
        vPrincipal = new JFrame("vPrincipal");
        vPrincipal.setContentPane(new vPrincipal(admin).getpPrincipal());
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.pack();
        vPrincipal.setVisible(true);
    }

    /* public static void crearVentanaClasificacion() {
        vLogin.dispose();
        vClasificacion = new JFrame("vClasificacion");
        vClasificacion.setContentPane(new vPrincipal().getpPrincipal());
        vClasificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vClasificacion.setLocationRelativeTo(null);
        vClasificacion.pack();
        vClasificacion.setVisible(true);
    }

    public static void crearVentanaPartidos() {
        vLogin.dispose();
        vPartidos = new JFrame("vPartidos");
        vPartidos.setContentPane(new vPrincipal().getpPrincipal());
        vPartidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPartidos.setLocationRelativeTo(null);
        vPartidos.pack();
        vPartidos.setVisible(true);
    }

     */

    public static void validarUsuario(String nombre, String password) throws Exception {
        usuario = TUsuarios.buscarPorUsernamePassword(new Usuario(nombre, password));
        if (usuario != null){
            if (usuario.getAdmin().equalsIgnoreCase("S")) Main.crearVentanaPrincipal("S");
            else Main.crearVentanaPrincipal("N");
        } else throw new Exception("El usuario o la contraseña son incorrectos");
    }
}
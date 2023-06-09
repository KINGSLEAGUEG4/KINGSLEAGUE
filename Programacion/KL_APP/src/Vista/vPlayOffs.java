package Vista;

import Controlador.Main;
import Modelo.ClasesBasesDatos.TEquipo;
import Modelo.ClasesBasesDatos.TPartido;
import Modelo.ClasesBasesDatos.TTemporadas;
import Modelo.ClasesObjetos.Equipo;
import Modelo.ClasesObjetos.Partido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class vPlayOffs {
    /**
     * Label del nombre
     */
    private JLabel lNombre;
    /**
     * Menu de base de datos
     */
    private JMenuItem miBaseDatos;
    /**
     * Menu de usuarios
     */
    private JMenuItem miUsuarios;
    /**
     * Menu del icono del perfil
     */
    private JMenu mIconoPerfil;
    /**
     * Label del nombre del menu
     */
    private JLabel lNombreMenu;
    /**
     * Label del tipo de usuario
     */
    private JLabel lTipoUsuario;
    /**
     * Menu del perfil
     */
    private JMenuItem miPerfil;
    /**
     * Menu del panel de admin
     */
    private JMenuItem miPanel;
    /**
     * Menu de cerrar sesion
     */
    private JMenuItem miCerrarSesion;
    /**
     * Menu de clasificacion
     */
    private JMenuItem miClasificacion;
    /**
     * Menu de partidos
     */
    private JMenuItem miPartidos;
    /**
     * Menu del equipo
     */
    private JMenuItem miEquipo;
    /**
     * Panel que tiene todos los componentes
     */
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JPanel pCombo;
    private JPanel pDatos;
    private JPanel pCuartosIzqTop;
    private JPanel pFinal;
    private JPanel pCuartosDerTop;
    private JPanel pCuartosIzqBot;
    private JPanel pCuartosDerBot;
    private JPanel pFinalDer;
    private JPanel pFinalIzq;
    private JPanel pSemiIzqTop;
    private JPanel pSemiIzq;
    /**
     * Menu de PlayOffs
     */
    private JMenuItem miPlayOffs;
    /**
     * Label de la tabla clasificacion en la posicion 1
     */
    private JLabel lPosicion1;
    /**
     * Label de la tabla clasificacion en la posicion 8
     */
    private JLabel lPosicion8;
    /**
     * Label de la tabla clasificacion en la posicion 4
     */
    private JLabel lPosicion4;
    /**
     * Label de la tabla clasificacion en la posicion 5
     */
    private JLabel lPosicion5;
    /**
     * Label de la tabla clasificacion en la posicion 2
     */
    private JLabel lPosicion2;
    /**
     * Label de la tabla clasificacion en la posicion 7
     */
    private JLabel lPosicion7;
    /**
     * Label de la tabla clasificacion en la posicion 3
     */
    private JLabel lPosicion3;
    /**
     * Label de la tabla clasificacion en la posicion 6
     */
    private JLabel lPosicion6;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 1
     */
    private JLabel lEquipo1;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 8
     */
    private JLabel lEquipo8;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 4
     */
    private JLabel lEquipo4;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 5
     */
    private JLabel lEquipo5;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 2
     */
    private JLabel lEquipo2;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 7
     */
    private JLabel lEquipo7;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 3
     */
    private JLabel lEquipo3;
    /**
     * Label del nombre de la tabla clasificacion en la posicion 6
     */
    private JLabel lEquipo6;
    /**
     * Label del nombre de equipo de la semifinal arriba a la izquierda
     */
    private JLabel lEquipoSemiIzqTop;
    /**
     * Label del nombre de equipo de la semifinal arriba a la izquierda
     */
    private JLabel lEquipoSemiIzqBot;
    /**
     * Label del nombre de equipo de la semifinal abajo a la izquierda
     */
    private JLabel lEquipoSemiDerTop;
    /**
     * Label del nombre de equipo de la semifinal arriba a la derecha
     */
    private JLabel lEquipoSemiDerBot;
    /**
     * Label del nombre de equipo de la final derecha
     */
    private JLabel lEquipoFinalDer;
    /**
     * Label del nombre de equipo de la final izquierda
     */
    private JLabel lEquipoFinalIzq;
    /**
     * Menu del panel principal
     */
    private JMenuItem miPrincipal;
    /**
     * Label del equipo ganador
     */
    private JPanel pGanador;

    /**
     * Constructor de la ventana
     * @param admin Para ocultar las cosas de administrador
     * @throws Exception
     */
    public vPlayOffs(String admin) throws Exception {
        inicializar();
        semis();
        finalKL();
        if (!admin.equalsIgnoreCase("S"))
            ocultarCosasAdmin();

        miPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaPartidos(admin);
            }
        });

        miClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                try {
                    Main.crearVentanaClasificacion(admin);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        miEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaEquipos(admin);
            }
        });

        miPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaPerfil(admin);
            }
        });

        miCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaLogin();
            }
        });

        miPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vPlayOffs.dispose();
                Main.crearVentanaPrincipal(admin);
            }
        });
    }

    /**
     * Para ocultar las cosas de administrador
     */
    public void ocultarCosasAdmin() {
        miPanel.setVisible(false);
        miBaseDatos.setVisible(false);
        miUsuarios.setVisible(false);
    }

    /**
     * Para inicializar los estilos y datos de la ventana
     * @throws Exception
     */
    public void inicializar() throws Exception {

        lNombreMenu.setText(Main.buscarNombre());
        lNombre.setText(Main.buscarNombre());

        if (Main.buscarAdmin().equalsIgnoreCase("S")) {
            lTipoUsuario.setText("Administrador");
        } else {
            lTipoUsuario.setText("Usuario");
        }

        miPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPlayOffs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPartidos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miClasificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miBaseDatos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mIconoPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));

        datos();
    }

    /**
     * Para obtener los datos
     * @throws Exception
     */
    public void datos() throws Exception {

        ArrayList<Object> listaArrays = TTemporadas.buscarClasificacion();
        Main.listaEquipos = (ArrayList<Equipo>) listaArrays.get(0);
        Main.listaPosicion = (ArrayList<Integer>) listaArrays.get(6);

        lPosicion1.setText(Main.listaPosicion.get(0).toString());
        lEquipo1.setText(Main.listaEquipos.get(0).getNombre());
        lPosicion8.setText(Main.listaPosicion.get(7).toString());
        lEquipo8.setText(Main.listaEquipos.get(7).getNombre());

        lPosicion4.setText(Main.listaPosicion.get(3).toString());
        lEquipo4.setText(Main.listaEquipos.get(3).getNombre());
        lPosicion5.setText(Main.listaPosicion.get(4).toString());
        lEquipo5.setText(Main.listaEquipos.get(4).getNombre());

        lPosicion2.setText(Main.listaPosicion.get(1).toString());
        lEquipo2.setText(Main.listaEquipos.get(1).getNombre());
        lPosicion7.setText(Main.listaPosicion.get(6).toString());
        lEquipo7.setText(Main.listaEquipos.get(6).getNombre());

        lPosicion3.setText(Main.listaPosicion.get(2).toString());
        lEquipo3.setText(Main.listaEquipos.get(2).getNombre());
        lPosicion6.setText(Main.listaPosicion.get(5).toString());
        lEquipo6.setText(Main.listaEquipos.get(5).getNombre());

    }

    /**
     * Para ver los equipos de las semifinales
     * @throws Exception
     */
    public void semis() throws Exception {
        Equipo preset = new Equipo();
        preset.setNombre(lEquipo1.getText());
        Equipo equipoLocal = TEquipo.buscarPorNombre(preset);
        preset = new Equipo();
        preset.setNombre(lEquipo8.getText());
        Equipo equipoVisitante = TEquipo.buscarPorNombre(preset);
        Partido partido = new Partido();
        partido.setLocal(equipoLocal);
        partido.setVisitante(equipoVisitante);
        Partido partido2 = TPartido.buscarSemis(partido);
        int n = Main.obtenerGanador(partido2);
        if (n == 1) {
            lEquipoSemiIzqTop.setText(equipoLocal.getNombre());
        } else {
            lEquipoSemiIzqTop.setText(equipoVisitante.getNombre());
        }

        Equipo preset2 = new Equipo();
        preset2.setNombre(lEquipo4.getText());
        Equipo equipoLocal2 = TEquipo.buscarPorNombre(preset2);
        preset2 = new Equipo();
        preset2.setNombre(lEquipo5.getText());
        Equipo equipoVisitante2 = TEquipo.buscarPorNombre(preset2);
        Partido partido3 = new Partido();
        partido3.setLocal(equipoLocal);
        partido3.setVisitante(equipoVisitante);
        Partido partido4 = TPartido.buscarSemis(partido3);
        n = Main.obtenerGanador(partido4);
        if (n == 1) {
            lEquipoSemiIzqBot.setText(equipoLocal2.getNombre());
        } else {
            lEquipoSemiIzqBot.setText(equipoVisitante2.getNombre());
        }

        Equipo preset3 = new Equipo();
        preset3.setNombre(lEquipo2.getText());
        Equipo equipoLocal3 = TEquipo.buscarPorNombre(preset3);
        preset3 = new Equipo();
        preset3.setNombre(lEquipo7.getText());
        Equipo equipoVisitante3 = TEquipo.buscarPorNombre(preset3);
        Partido partido5 = new Partido();
        partido5.setLocal(equipoLocal);
        partido5.setVisitante(equipoVisitante);
        Partido partido6 = TPartido.buscarSemis(partido5);
        n = Main.obtenerGanador(partido6);
        if (n == 1) {
            lEquipoSemiDerTop.setText(equipoLocal3.getNombre());
        } else {
            lEquipoSemiDerTop.setText(equipoVisitante3.getNombre());
        }

        Equipo preset4 = new Equipo();
        preset4.setNombre(lEquipo3.getText());
        Equipo equipoLocal4 = TEquipo.buscarPorNombre(preset4);
        preset4 = new Equipo();
        preset4.setNombre(lEquipo6.getText());
        Equipo equipoVisitante4 = TEquipo.buscarPorNombre(preset4);
        Partido partido7 = new Partido();
        partido7.setLocal(equipoLocal);
        partido7.setVisitante(equipoVisitante);
        Partido partido8 = TPartido.buscarSemis(partido7);
        n = Main.obtenerGanador(partido8);
        if (n == 1) {
            lEquipoSemiDerBot.setText(equipoLocal4.getNombre());
        } else {
            lEquipoSemiDerBot.setText(equipoVisitante4.getNombre());
        }
    }

    /**
     * Para poner el ganador de la final
     * @throws Exception
     */
    public void finalKL() throws Exception {
        Equipo preset = new Equipo();
        preset.setNombre(lEquipo1.getText());
        Equipo equipoLocal = TEquipo.buscarPorNombre(preset);
        preset = new Equipo();
        preset.setNombre(lEquipo5.getText());
        Equipo equipoVisitante = TEquipo.buscarPorNombre(preset);
        Partido partido = new Partido();
        partido.setLocal(equipoLocal);
        partido.setVisitante(equipoVisitante);
        Partido partido2 = TPartido.buscarSemis(partido);
        int n = Main.obtenerGanador(partido2);
        if (n == 1) {
            lEquipoFinalIzq.setText(equipoLocal.getNombre());
        } else {
            lEquipoFinalIzq.setText(equipoVisitante.getNombre());
        }


        Equipo preset2 = new Equipo();
        preset2.setNombre(lEquipo6.getText());
        Equipo equipoLocal2 = TEquipo.buscarPorNombre(preset2);
        preset2 = new Equipo();
        preset2.setNombre(lEquipo7.getText());
        Equipo equipoVisitante2 = TEquipo.buscarPorNombre(preset2);
        Partido partido3 = new Partido();
        partido3.setLocal(equipoLocal);
        partido3.setVisitante(equipoVisitante);
        Partido partido4 = TPartido.buscarSemis2(partido3);
         n = Main.obtenerGanador(partido4);
        if (n == 1) {
            lEquipoFinalDer.setText(equipoLocal2.getNombre());
        } else {
            lEquipoFinalDer.setText(equipoVisitante2.getNombre());
        }
    }
    public JPanel getpPrincipal() {
        return pPrincipal;
    }


}




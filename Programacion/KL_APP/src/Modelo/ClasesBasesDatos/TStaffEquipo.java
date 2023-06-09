package Modelo.ClasesBasesDatos;

import Modelo.ClasesObjetos.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class TStaffEquipo {
    /**
     * Para insertar un nuevo Staff en un equipo
     * @param staffEquipo Instancia de StaffEquipo
     * @throws SQLException
     */
    public static void insert(StaffEquipo staffEquipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("INSERT INTO equipos_staffs (id_equipo,id_staff,sueldo,fecha_inicio,fecha_fin) values (?,?,?,?,?,?)");
        ps.setInt(1,staffEquipo.getEquipo().getID());
        ps.setInt(2,staffEquipo.getStaff().getID());
        ps.setDouble(3,staffEquipo.getSueldo());
        ps.setDate(4, Date.valueOf(staffEquipo.getFechaInicio()));
        ps.setDate(5,Date.valueOf(staffEquipo.getFechaFin()));
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para borrar un staff de un equipo
     * @param staffEquipo Instancia de StaffEquipo
     * @return
     * @throws SQLException
     */
    public static int delete(StaffEquipo staffEquipo) throws SQLException {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("DELETE FROM equipos_staffs where id_staff = ?");
        ps.setInt(1,staffEquipo.getStaff().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
        return 0;
    }

    /**
     * Para updatear un staff de un equipo
     * @param staffEquipo Instancia de StaffEquipo
     * @throws Exception
     */
    public static void update(StaffEquipo staffEquipo) throws Exception
    {
        BaseDato.abrirConexion();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("update equipos_staffs set sueldo = ?, fecha_inicio = ?, fecha_fin = ? where id_staff = ?");
        ps.setDouble(1,staffEquipo.getSueldo());
        ps.setDate(2, Date.valueOf(staffEquipo.getFechaInicio()));
        ps.setDate(3, Date.valueOf(staffEquipo.getFechaFin()));
        ps.setInt(4,staffEquipo.getStaff().getID());
        ps.executeUpdate();
        BaseDato.cerrarConexion();
    }

    /**
     * Para buscar todos los staff de los equipos
     * @return ArrayList de StaffEquipo
     * @throws Exception
     */
    public static ArrayList<StaffEquipo> buscarTodos() throws Exception {
        BaseDato.abrirConexion();
        ArrayList<StaffEquipo> listaStaffsEquipos = new ArrayList<>();
        PreparedStatement ps = BaseDato.getCon().prepareStatement("select * from equipos_staffs");
        ResultSet result = ps.executeQuery();
        while (result.next()){
            StaffEquipo staffEquipo = new StaffEquipo(tStaffs.buscarPorId(new Staff(result.getInt("id_staff"))),TEquipo.buscarPorId(new Equipo(result.getInt("id_equipo"))), result.getDate("fecha_inicio").toLocalDate(), result.getDate("fecha_fin").toLocalDate(),result.getDouble("sueldo"));
            listaStaffsEquipos.add(staffEquipo);
        }
        BaseDato.cerrarConexion();
        return listaStaffsEquipos;
    }
}

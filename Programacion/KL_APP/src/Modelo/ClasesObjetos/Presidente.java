package Modelo.ClasesObjetos;

/**
 * @author Explotacion de Iker
 * @version 1.0
 * @see Equipo
 * @see Persona
 */
public class Presidente extends Persona {
    /**
     * Objeto Equipo
     */
    private Equipo equipo;

    /**
     * Constructor vacio de Presidente
     */
    public Presidente() {
    }

    /**
     * Constructor completo de Presidente
     * Para instanciar un Presidente con todos los atributos
     * @param ID
     * @param nombre
     * @param apellido
     * @param DNI
     * @param equipo
     */
    public Presidente(int ID, String nombre, String apellido, String DNI, Equipo equipo) {
        super(ID, nombre, apellido, DNI);
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}

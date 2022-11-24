import java.util.UUID;

/**
 * Clase Jugador - Define y maneja los datos de los jugadores-Conductores
 *
 * */
public class Jugador {
    UUID idJugador;
    String nombreJugador;

    //Constructor
    public Jugador(String nombreJugador) {
        setIdJugador();
        this.nombreJugador = nombreJugador;
    }

    //Devuelve el id del Jugador
    public UUID getIdJugador() {
        return idJugador;
    }

    //Asigna el id del Jugador
    public void setIdJugador() {
        this.idJugador = UUID.randomUUID();
    }
    //Devuelve el nombre del Jugador
    public String getNombreJugador() {
        return nombreJugador;
    }
    //Asigna el nombre del Jugador
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }


    //Devuelve el nombre del jugador con formato
    public String getNombreJugadorFormateado() {
        String details = "\nNombre Jugador: " + getNombreJugador();
        return details;
    }
}

import java.util.ArrayList;
import java.util.UUID;

/**
 * Clase Carrera - Define y maneja los datos de la carrera actual, contiene informacion sobre los
 * coches que participan, estados de carrera y una lista de clasificados segun orden de llegada a la meta
 *
 * */
public class Carrera {
    UUID idCarrera;
    int distanciaPista;
    ArrayList<Coche> coches;
    ArrayList<Coche> resultado;
    EstadoCarrera estadoCarrera;


    //Constructor
    public Carrera(int distanciaPista, ArrayList<Coche> coches) {
        setIdCarrera();
        this.distanciaPista = distanciaPista;
        this.coches = coches;
        this.estadoCarrera = EstadoCarrera.Previa;
        this.resultado = new ArrayList<>();
    }

    //Da la orden de largada a todos los coches
    public void largada() {
        for (Coche coche: coches) {
            coche.setCocheEnCarrera();
        }
        this.setEstadoCorriendo();
    }

    //Devuelve el valor ID de la carrera
    public UUID getIdCarrera() {
        return idCarrera;
    }

    //Asigna un valor unico de Id
    public void setIdCarrera() {
        this.idCarrera = UUID.randomUUID();
    }

    //devuelve la distancia de la pista (en Metros)
    public int getDistanciaPista() {
        return distanciaPista;
    }

    //Asigna la distancia de la pista (en Metros)
    public void setDistanciaPista(int distanciaPista) {
        this.distanciaPista = distanciaPista;
    }

    //Devuelve la lista de coches que participa en la carrera
    public String getCoches() {
        String lista = "";
        for (Coche coche:coches) {
            lista += coche.getDetalles();
        }
        return lista;
    }

    //Agrega el coche a la lista de clasificacion
    public void clasificarCoche(Coche coche){
        resultado.add(coche);
    }

    //Devuelve el estado actual de la carrera
    public EstadoCarrera getEstadoCarrera() {
        return estadoCarrera;
    }
    //Cambia el estado de la carrera a Corriendo
    public void setEstadoCorriendo() {
        this.estadoCarrera = EstadoCarrera.Corriendo;
    }

    //Cambia el estado de la carrera a Terminada
    public void setEstadoTerminada() {
        this.estadoCarrera = EstadoCarrera.Terminada;
    }

    //Devuelve los datos de la carrera
    public String getDetalles() {
        String details ="\nDistancia de pista: " + getDistanciaPista() +" metros" +
                "\nEstado de Carrera: " + getEstadoCarrera() +
                "\nCoches: " + getCoches() +
                "\nPodio: A definir";

        return details;
    }

    //Estados de la carrera
    public enum EstadoCarrera {
        Previa, Corriendo, Terminada
    }
}

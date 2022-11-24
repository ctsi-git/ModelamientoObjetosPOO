import java.util.UUID;

/**
 * Clase Coche - Define y maneja los datos de los coches que participan en la carrera
 *
 * */
public class Coche {
    UUID idCoche;
    UUID idJugador;
    int posicionInicial;
    int metrosRecorridos;
    Estado estado;

    //Constructor
    public Coche(UUID idJugador, int posicionInicial) {
        setIdCoche();
        this.idJugador = idJugador;
        this.posicionInicial = posicionInicial;
        this.metrosRecorridos = 0;
        this.estado = Estado.EnEspera;

    }

    //Devuelve el ID del coche
    public String getIdCoche() {
        return idCoche.toString();
    }
    //Asigna el ID del coche
    public void setIdCoche() {
        this.idCoche = UUID.randomUUID();
    }
    //Devuelve el id del conductor del coche
    public UUID getIdJugador() {
        return idJugador;
    }

    //Devuelve el numero posicion en la grilla del coche
    public int getPosicionInicial() {
        return posicionInicial;
    }

    //Devuelve el estado del coche
    public Estado getEstado() {
        return estado;
    }



    //Devuelve los metros recorridos por el coche
    public int getMetrosRecorridos() {
        return metrosRecorridos;
    }
    //Asigna los metros recorridos por el coche
    public void setMetrosRecorridos(int metrosRecorridos) {
        this.metrosRecorridos += metrosRecorridos;
    }

    //devuelve la cantidad de metros que avanza el coche
    public int calcularMetros(){
        return  Utils.getRandomNumber(1,6) * 100;
    }

    //Avanza el coche
    public void avanzarCoche(){
        setMetrosRecorridos(calcularMetros()); //asigna la cantidad de metros que devuelve la funcion calcularMetros()
    }

    //Cambia el estado del coche a EnCarrera
    public void setCocheEnCarrera(){
        this.estado=Estado.EnCarrera;
    }
    //Cambia el estado del coche a Detenido
    public void setEstadoDetenido(){
        this.estado=Estado.Detenido;
    }

    //Devuelve los datos del coche
    public String getDetalles() {
        String details ="\nPosicion Inicial: " + getPosicionInicial() +
                " - Kilometros recorridos: " + getMetrosRecorridos();

        return details;
    }


    //Estados del coche
    public enum Estado{
        Detenido, EnCarrera, EnEspera
    }
}

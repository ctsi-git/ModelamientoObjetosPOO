import java.util.ArrayList;
import java.util.UUID;

/**
 * Juego de coches - se busca generar un juego de coches donde cada uno tiene un jugador/conductor,
 * los coches se colocan en una pista. Los coches avanzan cada turno, recorriendo una cantidad de metros
 * al azar segun el resultado de tirar un dado de 1 a 6. El valor dado se multiplica por 100 y esa es la
 * distancia que avanza. Gana el primero que cruce la meta. Al final se debe mostrar el podio de los 3 primeros
 * jugadores clasificados.
 *
 * @author Edinson Acosta Gancharov
 * */

public class JuegoCoches {

    //Declaracion de variables
    public static ArrayList<Jugador> jugadores = new ArrayList<>();
    public static ArrayList<Coche> coches = new ArrayList<>();
    public static Carrera carreraActual;

    //Metodo main
    public static void main(String[] args) {

        System.out.println("\n** Juego de Coches **");

        System.out.println("\nCargando jugadores.....");
        cargarJugadores(); //carga la lista de jugadores/conductores

        System.out.println("\nAsignando coches.....");
        cargarCoches(); //carga la lista de coches con sus conductores

        System.out.println("\nPreparando Carrera.....");
        iniciarCarrera(); //inicializa los datos de la carrera

        //consulta si se debe comenzar la carrera
        if (Utils.AskYesNo("Iniciar Carrera")) {
            System.out.println("\n3..2..1....GO....");

            carreraActual.largada(); //Orden de largada
            CorrerCarrera(); //Control de carrera
        }

        //pausa
        Utils.pressEnterToContinue();

        //Fin
        System.out.println("\n** Fin del Programa **");

    }

    //Procesamiento de la carrera
    private static void CorrerCarrera() {

        int cochesEnCarrera = carreraActual.coches.size(); //cantidad de coches en carrera

        //mientras haya coches corriendo se mantiene el ciclo
        while (carreraActual.getEstadoCarrera() == Carrera.EstadoCarrera.Corriendo) {

            //recorre la lista de coches en carrera
            for (Coche coche : carreraActual.coches) {
                //verifica que el coche actual aun este corriendo
                if (coche.getEstado() == Coche.Estado.EnCarrera) {

                    coche.avanzarCoche(); //adelanta el coche

                    //verifica que el coche haya pasado la meta
                    if (coche.getMetrosRecorridos() >= carreraActual.getDistanciaPista()) {
                        coche.setEstadoDetenido(); //detiene el coche y cambia su estado
                        carreraActual.clasificarCoche(coche); //agrega el coche a la lista de clasificados
                        cochesEnCarrera--; //elimina uno a la lista de coches en carrera
                    }
                }
            }
            //verifica si aun quedan coches en carrera
            if (cochesEnCarrera <= 0) {
                carreraActual.setEstadoTerminada(); //si no hay mas coches termina la carrera
            }
        }

        //Muestra el listado de coches segun el orden de clasificacion
        int idx = 1;
        System.out.println("\n** Resultado de la Carrera **");
        for (Coche coche : carreraActual.resultado) {
            System.out.print("\n" + idx +
                    " ) Conductor: " + getNombreJugadorPorID(coche.getIdJugador())+
                    " - Posicion inicial: " + coche.getPosicionInicial());
            idx++;

            if(idx > 3){ //si ya mostro los 3 primeros terminar el ciclo
                break;
            }
        }
    }

    //Devuelve el nombre del jugador buscandolo por su ID
    private static String getNombreJugadorPorID(UUID idJugador) {
        for (Jugador jugador : jugadores) { // recorre la lista de jugadores
            if (jugador.getIdJugador() == idJugador) { //verifica si coinciden los ID
                return jugador.getNombreJugador(); //devuelve el nombre
            }
        }
        return "Error. Jugador no valido"; //mensaje de error
    }

    //inicializa los valores para una nueva carrera
    private static void iniciarCarrera() {

        carreraActual = new Carrera(Utils.getRandomNumber(2500, 9500), coches); //crea una instancia de Carrera

        System.out.println(carreraActual.getDetalles()); //muestra los detalles de la carrera
    }

    //agrega elementos a la lista de jugadores
    private static void cargarCoches() {

        int idx = 1;
        for (Jugador jugador : jugadores) { //recorre la lista de jugadores

            Coche nuevoCoche = new Coche(jugador.getIdJugador(), idx); //crea una instancia de coche
            coches.add(nuevoCoche); //agrega el nuevo coche a la lista de coches

            //muestra los detalles
            System.out.print("\nPosicion Inicial: " + idx +
                    " - Conductor: " + jugador.getNombreJugador() +
                    " - Estado coche: " + nuevoCoche.getEstado() + "\n");

            idx++; //aumenta el indice
        }
        //pausa
        Utils.pressEnterToContinue();
    }

    //agrega elementos a la lista de jugadores
    private static void cargarJugadores() {
        jugadores.add(new Jugador("Juan"));
        jugadores.add(new Jugador("Carlos"));
        jugadores.add(new Jugador("Maria"));
        jugadores.add(new Jugador("Raul"));
        jugadores.add(new Jugador("Paula"));

        for (Jugador jugador : jugadores) { //recorre la lista de jugadores y muestra los nombres
            System.out.print(jugador.getNombreJugadorFormateado());
        }

        //pausa
        Utils.pressEnterToContinue();
    }
}
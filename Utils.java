import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Utils - Clase que contiene utilidades varias usadas por la aplicación
 *
 * @author Edinson Acosta Gancharov
 */

public class Utils {

    static Scanner input = new Scanner(System.in);

    //UTILIDADES VARIAS

    /**
     * Presione Enter Para Continuar
     * método auxiliar que genera una Pausa hasta que se presione <Enter>
     */
    static void pressEnterToContinue() {
        System.out.println("\nPresione <Enter> para continuar");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    /**
     * Devuelve un número al azar entre minNumber y maxNumber
     */
    public static int getRandomNumber(int minNumber, int maxNumber) {

        return (int)(Math.random()*(maxNumber-minNumber+1)+minNumber);
    }


    /**
     * Utilidad que recibe una pregunta y devuelve true o false segun respuesta
     */
    public static boolean AskYesNo(String message) {
        //hago la consulta segun el mensaje que me envian
        System.out.println("\n" + message + " ( 1 - Si / 2 - No ): ");
        int respuesta = input.nextInt();
        try {
            if (respuesta == 1) {
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException e) {
            return false;
        }
    }
}



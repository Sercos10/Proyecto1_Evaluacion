package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class pedir {
    public static String leeRespuesta(String frase) {
        boolean valid = false;
        String n = "";
        Scanner t = new Scanner(System.in);

        do {
            try {
                System.out.println(frase);
                n = t.nextLine();
                valid = true;
            } catch (InputMismatchException ex) {
                t.nextLine();
                System.out.println("Error");
                valid = false;
            } catch (Exception e) {
                System.out.println("No vale");
            }
        } while (!valid);

        return n;
    }

    public static int escogeAtaque(String frase) {
        int n = 0;
        boolean valid = false;
        Scanner t = new Scanner(System.in);

        do {
            try {
                System.out.println(frase);
                n = t.nextInt();
                valid = true;
            } catch (InputMismatchException ex) {
                valid = false;
                t.nextLine();
            }
        } while (!valid || n < 0 || n>2);
        return n;
    }

    public static int escogeHabilidad(String frase) {
        int n = 0;
        boolean valid = false;
        Scanner t = new Scanner(System.in);

        do {
            try {
                System.out.println(frase);
                n = t.nextInt();
                valid = true;
            } catch (InputMismatchException ex) {
                valid = false;
                t.nextLine();
            }
        } while (!valid || n < 0 || n>3);
        return n;
    }
}

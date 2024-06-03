import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lectura {
    public Lectura() {
    }

    public static char caracter() {
        String res = "";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            res = in.readLine();
        } catch (IOException var2) {
            IOException ex = var2;
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
        }

        return res.charAt(0);
    }

    public static String cadena() {
        String res = "";

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            res = in.readLine();
        } catch (IOException var2) {
            IOException ex = var2;
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
        }

        return res;
    }

    public static int numeroEnter() {
        int res = 0;

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            res = Integer.parseInt(in.readLine());
        } catch (IOException var2) {
            IOException ex = var2;
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
        }

        return res;
    }

    public static double numeroDecimal() {
        double res = 0.0;

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            res = Double.parseDouble(in.readLine());
        } catch (IOException var3) {
            IOException ex = var3;
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, (String)null, ex);
        }

        return res;
    }
}

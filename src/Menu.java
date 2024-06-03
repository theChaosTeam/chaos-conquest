import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Menu {

    private static String USERNAME;
    private static String PASSWORD;

    public static void connectUser() {

        boolean connected = false;

        do {

            System.out.println("Introduce el ID del usuario: ");
            USERNAME = Lectura.cadena();

            System.out.println("Introduce la contraseña del usuario:");
            PASSWORD = Lectura.cadena();

            try {

                Connection connection = DriverManager.getConnection(

                        "jdbc:mariadb://localhost:3306/chaos_conquest",
                        USERNAME,
                        PASSWORD
                );

                if (connection != null) {
                    System.out.println("Conexión establecida");
                    connected = true;
                }
            } catch (SQLException exception){
                System.err.println("Error al conectar con la base de datos");
                System.err.println("Usuario o contraseña incorrectos");
            }
        } while (!connected);
    }

    public static void Admin() {

    }

    public static void Developer() {

    }

    public static void DataAnalist() {

        System.out.println("Has iniciado sesión como Analista de datos");
        int option = 0;

        switch (option){

        }
    }

    public static void ComunityMod() {

    }

    public static void Player() {

    }

    public static void PublicVisitant() {

    }

    public static int checkRole() {

        int role = 0;
        String roleName = "";
        char[] name = USERNAME.toCharArray();

        for (int i = 0; i < name.length; i++) {

            if (name[i] == '_') {

                break;
            }
            roleName = roleName + name[i];

        }

        switch(roleName) {

            case "Admin":

                role = 1;
                break;

            case "Dev":

                role = 2;
                break;

            case "DA":

                role = 3;
                break;

            case "Mod":

                role = 4;
                break;

            case "Player":

                role = 5;
                break;

            case "Public":

                role = 6;
                break;
        }

        return role;
    }

}
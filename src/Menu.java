import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {

    private static String USERNAME;

    public static Connection connectUser() {

        boolean connected = false;

        Connection connection = null;

        do {

            System.out.println("Introduce el ID del usuario: ");
            USERNAME = Lectura.cadena();

            System.out.println("Introduce la contraseña del usuario:");
            String PASSWORD = Lectura.cadena();

            try {

                connection = DriverManager.getConnection(

                        "jdbc:mariadb://localhost:3306/chaos_conquest",
                        USERNAME,
                        PASSWORD
                );


                if (connection != null) {
                    System.out.println("Conexión establecida");
                    connected = true;
                }
            } catch (SQLException exception) {
                System.err.println("Error al conectar con la base de datos");
                System.err.println("Usuario o contraseña incorrectos");
            }
        } while (!connected);

        return connection;
    }

    public static void Admin(Connection connection) {

        System.out.println("You logged in as an Administrator");
    }

    public static void Developer(Connection connection) {

        System.out.println("You logged in as a Developer");
    }

    public static void DataAnalist(Connection connection) throws SQLException {

        boolean exit = false;
        Statement statement = connection.createStatement();

        do {
            System.out.println("You logged in as a Data Analyst");
            System.out.println("Select the table you want to see or put 0 to close the actual session:");
            System.out.println("0.Close session");
            System.out.println("1.Champion");
            System.out.println("2.ChampionAbility");
            System.out.println("3.ChampionSkin");
            System.out.println("4.Clash");
            System.out.println("5.ClashParticipant");
            System.out.println("6.CompetitiveRank");
            System.out.println("7.DamageType");
            System.out.println("8.Item");
            System.out.println("9.ItemLoadout");
            System.out.println("10.ItemStat");
            System.out.println("11.Mastery");
            System.out.println("12.MatchHistory");
            System.out.println("13.MatchStats");
            System.out.println("14.OwnedChampions");
            System.out.println("15.OwnedSkins");
            System.out.println("16.PatchHistory");
            System.out.println("17.Player");
            System.out.println("18.Rune");
            System.out.println("19.RuneLoadout");
            System.out.println("20.RunePath");

            int option = Lectura.numeroEnter();

            switch (option) {

                case 0:
                    exit = true;
                    break;

                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                case 6:

                case 7:

                case 8:

                case 9:

                case 10:

                case 11:

                case 12:

                case 13:

                case 14:

                case 15:

                case 16:

                case 17:

                case 18:

                case 19:

                case 20:

                default:

                    System.out.println("Invalid option");
                    break;
            }
        } while (!exit);
    }

    public static void ComunityMod(Connection connection) {

        System.out.println("You logged in as Community Moderator");
    }

    public static void Player(Connection connection) {

        System.out.println("You logged in as a Player");
    }

    public static void PublicVisitant(Connection connection) {

        System.out.println("You logged in as a Public Visitant");
    }

    public static int checkRole() {

        int role = 0;
        StringBuilder roleName = new StringBuilder();
        char[] name = USERNAME.toCharArray();

        for (char c : name) {

            if (c == '_') {

                break;
            }
            roleName.append(c);

        }

        role = switch (roleName.toString()) {
            case "Admin" -> 1;
            case "Dev" -> 2;
            case "DA" -> 3;
            case "Mod" -> 4;
            case "Player" -> 5;
            case "Public" -> 6;
            default -> role;
        };

        return role;
    }

    public static boolean checkExit() {

        System.out.println("Do you want to exit? (Y/N)");
        char exit = Lectura.caracter();

        return exit == 'Y';
    }

}
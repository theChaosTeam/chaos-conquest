import java.sql.*;

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
        statement.execute("USE chaos_conquest");

        System.out.println("You logged in as a Data Analyst");
        do {
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

                    ResultSet resultSet = statement.executeQuery("SELECT * FROM champion");
                    int columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    statement.execute("SELECT * FROM championability");

                case 3:
                    statement.execute("SELECT * FROM championskin");

                case 4:
                    statement.execute("SELECT * FROM clash");

                case 5:
                    statement.execute("SELECT * FROM clashparticipant");

                case 6:
                    statement.execute("SELECT * FROM competitiverank");

                case 7:
                    statement.execute("SELECT * FROM damagetype");

                case 8:
                    statement.execute("SELECT * FROM item");

                case 9:
                    statement.execute("SELECT * FROM itemloadout");

                case 10:
                    statement.execute("SELECT * FROM itemstat");

                case 11:
                    statement.execute("SELECT * FROM mastery");

                case 12:
                    statement.execute("SELECT * FROM matchhistory");

                case 13:
                    statement.execute("SELECT * FROM matchstats");

                case 14:
                    statement.execute("SELECT * FROM ownedchampions");

                case 15:
                    statement.execute("SELECT * FROM ownedskins");

                case 16:
                    statement.execute("SELECT * FROM patchhistory");

                case 17:
                    statement.execute("SELECT * FROM player");

                case 18:
                    statement.execute("SELECT * FROM rune");

                case 19:
                    statement.execute("SELECT * FROM runeloadout");

                case 20:
                    statement.execute("SELECT * FROM runepath");

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
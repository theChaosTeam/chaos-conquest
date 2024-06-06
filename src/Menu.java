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

    public static void Admin(Connection connection) throws SQLException{


        System.out.println("You logged in as an Administrator");

        boolean exit2 = false;

        do {

            System.out.println("Choose an option");
            System.out.println("0.Close session");
            System.out.println("1.Select info");
            System.out.println("2.Insert info");
            System.out.println("3.Delete info");
            System.out.println("4.Update info");

            switch (Lectura.numeroEnter()) {

                case 0:
                    System.out.println("You logged out");
                    exit2 = true;
                    break;

                case 1:

                    boolean exit = false;
                    Statement statement = connection.createStatement();
                    statement.execute("USE chaos_conquest");

                    selectMenu(exit, statement);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                default:
                    System.out.println("Invalid option");
            }
        } while (!exit2);
    }

    public static void Developer(Connection connection) {

        System.out.println("You logged in as a Developer");
    }

    public static void DataAnalist(Connection connection) throws SQLException {

        boolean exit = false;
        Statement statement = connection.createStatement();
        statement.execute("USE chaos_conquest");

        System.out.println("You logged in as a Data Analyst");
        selectMenu(exit, statement);
    }

    public static void ComunityMod(Connection connection) {

        System.out.println("You logged in as Community Moderator");
    }

    public static void Player(Connection connection) {

        System.out.println("You logged in as a Player");
    }

    public static void PublicVisitant(Connection connection) throws SQLException{

        boolean exit = false;
        Statement statement = connection.createStatement();
        statement.execute("USE chaos_conquest");

        System.out.println("You logged in as a Public Visitant");

        do {
            System.out.println("Select the table you want to see or put 0 to close the actual session:");
            System.out.println("0.Close session");
            System.out.println("1.Champion");
            System.out.println("2.ChampionAbility");
            System.out.println("3.CompetitiveRank");
            System.out.println("4.DamageType");
            System.out.println("5.Item");
            System.out.println("6.ItemStat");
            System.out.println("7.PatchHistory");
            System.out.println("8.Player");
            System.out.println("9.Rune");

            ResultSet resultSet;
            int columnCount;

            switch (Lectura.numeroEnter()) {

                case 0:

                    exit = true;
                    break;

                case 1:

                    resultSet = statement.executeQuery("SELECT * FROM champion");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 2:

                    resultSet = statement.executeQuery("SELECT * FROM championability");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    resultSet = statement.executeQuery("SELECT * FROM competitiverank");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    resultSet = statement.executeQuery("SELECT * FROM damagetype");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    resultSet = statement.executeQuery("SELECT * FROM item");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    resultSet = statement.executeQuery("SELECT * FROM itemstat");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 7:
                    resultSet = statement.executeQuery("SELECT * FROM patchhistory");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 8:
                    resultSet = statement.executeQuery("SELECT * FROM player");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 9:
                    resultSet = statement.executeQuery("SELECT * FROM rune");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                default:

                    System.out.println("Invalid option");
                    break;
            }
        } while (!exit);


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

    private static void selectMenu(boolean exit, Statement statement) throws SQLException {
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

            ResultSet resultSet;
            int columnCount;

            switch (Lectura.numeroEnter()) {

                case 0:

                    exit = true;
                    break;

                case 1:

                    resultSet = statement.executeQuery("SELECT * FROM champion");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 2:

                    resultSet = statement.executeQuery("SELECT * FROM championability");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    resultSet = statement.executeQuery("SELECT * FROM championskin");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    resultSet = statement.executeQuery("SELECT * FROM clash");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    resultSet = statement.executeQuery("SELECT * FROM clashparticipant");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    resultSet = statement.executeQuery("SELECT * FROM competitiverank");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 7:
                    resultSet = statement.executeQuery("SELECT * FROM damagetype");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 8:
                    resultSet = statement.executeQuery("SELECT * FROM item");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 9:
                    resultSet = statement.executeQuery("SELECT * FROM itemloadout");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 10:
                    resultSet = statement.executeQuery("SELECT * FROM itemstat");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 11:
                    resultSet = statement.executeQuery("SELECT * FROM mastery");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 12:
                    resultSet = statement.executeQuery("SELECT * FROM matchhistory");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 13:
                    resultSet = statement.executeQuery("SELECT * FROM matchstats");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 14:
                    resultSet = statement.executeQuery("SELECT * FROM ownedchampions");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 15:
                    resultSet = statement.executeQuery("SELECT * FROM ownedskins");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 16:
                    resultSet = statement.executeQuery("SELECT * FROM patchhistory");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 17:
                    resultSet = statement.executeQuery("SELECT * FROM player");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 18:
                    resultSet = statement.executeQuery("SELECT * FROM rune");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 19:
                    resultSet = statement.executeQuery("SELECT * FROM runeloadout");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 20:
                    resultSet = statement.executeQuery("SELECT * FROM runepath");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                default:

                    System.out.println("Invalid option");
                    break;
            }
        } while (!exit);
    }

}
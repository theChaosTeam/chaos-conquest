import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

            ResultSet resultSet;
            int columnCount;

            switch (option) {

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

    public static void ComunityMod(Connection connection) throws SQLException {

        System.out.println("You logged in as Community Moderator");

        boolean exit = false;
        Statement statement = connection.createStatement();
        statement.execute("USE chaos_conquest");

        do {
            System.out.println("What option do you want to use?");
            System.out.println("0. Close session");
            System.out.println("1. Select");
            System.out.println("2. Insert");
            System.out.println("3. Update");

            int option = Lectura.numeroEnter();

            switch (option){
                case 0:

                    exit = true;
                    break;

                case 1:
                    System.out.println("What table do you want select?");
                    System.out.println("0. Back");
                    System.out.println("1. Player");
                    System.out.println("2. Match History");
                    System.out.println("3. Match Stats");

                    int select = Lectura.numeroEnter();
                    ResultSet resultSet;
                    int columnCount;

                    switch(select){
                        case 0:

                            break;
                        case 1:

                            resultSet = statement.executeQuery("SELECT * FROM player");
                            columnCount = resultSet.getMetaData().getColumnCount();

                            while (resultSet.next()) {
                                for (int i = 1; i <= columnCount; i++) {
                                    System.out.print(resultSet.getString(i) + "\t");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:

                            resultSet = statement.executeQuery("SELECT * FROM matchhistory");
                            columnCount = resultSet.getMetaData().getColumnCount();

                            while (resultSet.next()) {
                                for (int i = 1; i <= columnCount; i++) {
                                    System.out.print(resultSet.getString(i) + "\t");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:

                            resultSet = statement.executeQuery("SELECT * FROM matchstats");
                            columnCount = resultSet.getMetaData().getColumnCount();

                            while (resultSet.next()) {
                                for (int i = 1; i <= columnCount; i++) {
                                    System.out.print(resultSet.getString(i) + "\t");
                                }
                                System.out.println();
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("What table do you want insert?");
                    System.out.println("0. Back");
                    System.out.println("1. Player");
                    System.out.println("2. Match History");
                    System.out.println("3. Match Stats");

                    int insert = Lectura.numeroEnter();
                    switch (insert){
                        case 0:
                            break;

                        case 1:

                            System.out.println("Insert the name of the player:");
                            String NickName = Lectura.cadena();
                            System.out.println("Insert the level of the player:");
                            int Level = Lectura.numeroEnter();
                            System.out.println("Insert the rank of the player:");
                            int Rank = Lectura.numeroEnter();
                            System.out.println("Insert the Most Player Champions of the player:");
                            int MostPlayedChampion = Lectura.numeroEnter();

                            statement.executeQuery("INSERT INTO player(NickName, Level, Rank, MostPlayedChampion) VALUES (NickName, Level, Rank, MostPlayedChampion)");

                            break;
                        case 2:
                            System.out.println("Insert the champions ID:");
                            int ChampionsID = Lectura.numeroEnter();
                            System.out.println("Insert the Winner Team:");
                            String WinnerTeam = Lectura.cadena();
                            System.out.println("Insert the Match Duration");
                            Time MatchDuration = Time.valueOf(Lectura.cadena());
                            System.out.println("Insert the Match Date");
                            DateTimeFormatter MatchDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                            statement.executeQuery("INSERT INTO matchhistory(ChampionsID, WinnerTeam, MatchDuration, MatchDate) VALUES (ChampionsID, WinnerTeam, MatchDuration, MatchDate)");
                            System.out.println("Done");

                            break;

                        case 3:

                            System.out.println("Insert the kills:");
                            int Kills = Lectura.numeroEnter();
                            System.out.println("Insert the deaths:");
                            int Deaths = Lectura.numeroEnter();
                            System.out.println("Insert the assists:");
                            int Assists = Lectura.numeroEnter();
                            System.out.println("Insert the GoldEarned:");
                            int GoldEarned = Lectura.numeroEnter();



                            break;
                    }




                    break;
                case 3:
                    System.out.println("What table do you want update?");
                    System.out.println("0. Back");
                    System.out.println("1. Player");
                    System.out.println("2. Match History");
                    System.out.println("3. Match Stats");
                    break;
            }

        } while (!exit);



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
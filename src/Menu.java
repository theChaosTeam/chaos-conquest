import java.sql.*;
import java.util.InputMismatchException;

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

    public static void ComunityMod(Connection connection) {

        System.out.println("You logged in as Community Moderator");
    }

    public static void Player(Connection connection) throws SQLException {
        boolean exit = false;
        Statement statement = connection.createStatement();
        statement.execute("USE chaos_conquest");

        System.out.println("You logged in as a Player");
        do {
            System.out.println("Select the table you want to use or put 0 to close the actual session:");
            System.out.println("0.Close session");
            System.out.println("1.Add or see an existing ItemLoadout");
            System.out.println("2.Add or see an existing RuneLoadout");
            System.out.println("3. Check players on the server");
            System.out.println("4.See all Champions");
            System.out.println("5.Check the abilities of a Champion");
            System.out.println("6.Check the skins of a Champion");
            System.out.println("7.Check Clashes");
            System.out.println("8.Check Clash Participants");
            System.out.println("9.See Competitive Ranks");
            System.out.println("10.See Damage Types");
            System.out.println("11.Check Items");
            System.out.println("12.Check ItemLoadout");
            System.out.println("13.Check ItemStats");
            System.out.println("14.Check Mastery");
            System.out.println("15.Check MatchHistory");
            System.out.println("16.Check MatchStats");
            System.out.println("17.Check OwnedChampion");
            System.out.println("19.Check PatchHistory");
            System.out.println("21.Check Runes");
            System.out.println("22.Check Rune Loadouts");
            System.out.println("23.Check Rune Paths");
            System.out.println();

            int option = Lectura.numeroEnter();

            ResultSet resultSet;
            int columnCount;

            switch (option) {

                case 0:

                    exit = true;
                    break;

                case 1:
                    try{
                        System.out.println("Insert the number of the ItemID:");
                        int newItemID = Lectura.numeroEnter();

                        statement.executeUpdate("INSERT INTO itemloadout(ItemID) VALUES (" + newItemID + ")");
                        System.out.println("Inserting item loadout...");
                        System.out.println("Done");
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("Error: could not insert the itemloadout, please insert the ItemID (number)");
                        break;
                    }

                case 2:
                    try{
                        System.out.println("Insert the number of the RuneID:");
                        int newRuneID = Lectura.numeroEnter();

                        statement.executeUpdate("INSERT INTO runeloadout(ItemID) VALUES (" + newRuneID + ")");
                        System.out.println("Inserting rune loadout...");
                        System.out.println("Done");
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: could not insert the runeloadout, please insert the ItemID (number)");
                        break;
                    }

                case 3:
                    resultSet = statement.executeQuery("SELECT * FROM player");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 4:

                    resultSet = statement.executeQuery("SELECT * FROM champion");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("Introduce the ID of the champion you want to see the abilities of:");
                    int abilityChampionID = Lectura.numeroEnter();

                    resultSet = statement.executeQuery("SELECT * from championabilities WHERE championID = " + abilityChampionID);
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Introduce the ID of the champion you want to see the skins of:");
                    int skinChampionID = Lectura.numeroEnter();

                    resultSet = statement.executeQuery("SELECT * from championabilities WHERE championID = " + skinChampionID);
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 7:
                    resultSet = statement.executeQuery("SELECT * from clash");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 8:
                    System.out.println("Introduce the ID of the clash from who you want to see the participants of:");
                    int participantsClashID = Lectura.numeroEnter();

                    resultSet = statement.executeQuery("SELECT * FROM clashparticipant WHERE ClashID = " + participantsClashID);
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 9:
                    resultSet = statement.executeQuery("SELECT * FROM competitiverank");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 10:
                    resultSet = statement.executeQuery("SELECT * FROM damagetype");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 11:
                    resultSet = statement.executeQuery("SELECT * FROM item");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 12:
                    resultSet = statement.executeQuery("SELECT * FROM itemloadout");
                    columnCount = resultSet.getMetaData().getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.println(resultSet.getString(i) + "\t");
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
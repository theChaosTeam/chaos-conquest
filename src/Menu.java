import java.sql.*;
import java.time.format.DateTimeFormatter;
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

    public static void Admin(Connection connection) throws SQLException{


        System.out.println("You logged in as an Administrator");

        boolean exitAdmin = false;

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
                    exitAdmin = true;
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
        } while (!exitAdmin);
    }

    public static void Developer(Connection connection) throws SQLException {

        System.out.println("You logged in as a Developer");

        boolean exitDev = false;

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
                    exitDev = true;
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
        } while (!exitDev);
    }

    public static void DataAnalist(Connection connection) throws SQLException {

        boolean exit = false;
        Statement statement = connection.createStatement();
        statement.execute("USE chaos_conquest");

        System.out.println("You logged in as a Data Analyst");
        selectMenu(exit, statement);
    }

    public static void ComunityMod(Connection connection) throws SQLException{

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

            switch (Lectura.numeroEnter()){

                case 0:

                    exit = true;
                    break;

                case 1:

                    System.out.println("What table do you want select?");
                    System.out.println("0. Back");
                    System.out.println("1. Player");
                    System.out.println("2. Match History");
                    System.out.println("3. Match Stats");

                    ResultSet resultSet;
                    int columnCount;

                    switch(Lectura.numeroEnter()){

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

                    switch (Lectura.numeroEnter()){

                        case 0:

                            break;

                        case 1:

                            System.out.println("Insert the name of the player: ,Insert the level of the player: ,Insert the rank of the player: ,Insert the Most Player Champions of the player:");

                            String NickName = Lectura.cadena();
                            int Level = Lectura.numeroEnter();
                            int Rank = Lectura.numeroEnter();
                            int MostPlayedChampion = Lectura.numeroEnter();

                            statement.executeQuery("INSERT INTO player(NickName, Level, Rank, MostPlayedChampion) VALUES (NickName, Level, Rank, MostPlayedChampion)");
                            System.out.println("Done");

                            break;

                        case 2:

                            System.out.println("Insert the champions ID: ,Insert the Winner Team: ,Insert the Match Duration: ,Insert the Match Date:");

                            int ChampionsID = Lectura.numeroEnter();
                            String WinnerTeam = Lectura.cadena();
                            Time MatchDuration = Time.valueOf(Lectura.cadena());
                            DateTimeFormatter MatchDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                            statement.executeQuery("INSERT INTO matchhistory(ChampionsID, WinnerTeam, MatchDuration, MatchDate) VALUES (ChampionsID, WinnerTeam, MatchDuration, MatchDate)");
                            System.out.println("Done");

                            break;

                        case 3:

                            System.out.println("Insert the kills: ,Insert the deaths: ,Insert the assists: ,Insert the Gold Earned: ,Insert the Dealt Damage: , Insert the Recived Damage: ,Insert the Team:");

                            int Kills = Lectura.numeroEnter();
                            int Deaths = Lectura.numeroEnter();
                            int Assists = Lectura.numeroEnter();
                            int GoldEarned = Lectura.numeroEnter();
                            int DealtDamage = Lectura.numeroEnter();
                            int RecivedDamage = Lectura.numeroEnter();
                            String Team = Lectura.cadena();

                            statement.executeQuery("INSERT INTO matchstats(Kills, Deaths, Assists, GoldEarned, DealtDamage, RecivedDamage, Team) VALUES (Kills, Deaths, Assists, GoldEarned, DealtDamage, RecivedDamage, Team)");
                            System.out.println("Done");

                            break;
                    }

                    break;

                case 3:

                    System.out.println("What table do you want update?");
                    System.out.println("0. Back");
                    System.out.println("1. Player");
                    System.out.println("2. Match History");
                    System.out.println("3. Match Stats");

                    int Update = Lectura.numeroEnter();

                    switch (Update){
                        case 0:
                            break;
                        case 1:

                            System.out.println("Insert the name of the player: ,Insert the level of the player: ,Insert the rank of the player: ,Insert the Most Player Champions of the player:");

                            String NickName = Lectura.cadena();
                            int Level = Lectura.numeroEnter();
                            int Rank = Lectura.numeroEnter();
                            int MostPlayedChampion = Lectura.numeroEnter();

                            statement.executeQuery("UPDATE player SET Level = " + Level + ", Rank = " + Rank + ", MostPlayedChampion = " + MostPlayedChampion + " WHERE NickName = " + NickName);
                            System.out.println("Done");
                            break;
                        case 2:

                            System.out.println("Insert the champions ID: ,Insert the Winner Team: ,Insert the Match Duration: ,Insert the Match Date:");

                            int ChampionsID = Lectura.numeroEnter();
                            String WinnerTeam = Lectura.cadena();
                            Time MatchDuration = Time.valueOf(Lectura.cadena());
                            DateTimeFormatter MatchDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                            statement.executeQuery("UPDATE matchhistory SET WinnerTeam = " + WinnerTeam + ", MatchDuration = " + MatchDuration + ", MatchDate = " + MatchDate + " WHERE ChampionsID = " + ChampionsID);
                            System.out.println("Done");
                            break;
                        case 3:

                            System.out.println("Insert the kills: ,Insert the deaths: ,Insert the assists: ,Insert the Gold Earned: ,Insert the Dealt Damage: , Insert the Recived Damage: ,Insert the Team:");

                            int Kills = Lectura.numeroEnter();
                            int Deaths = Lectura.numeroEnter();
                            int Assists = Lectura.numeroEnter();
                            int GoldEarned = Lectura.numeroEnter();
                            int DealtDamage = Lectura.numeroEnter();
                            int RecivedDamage = Lectura.numeroEnter();
                            String Team = Lectura.cadena();

                            statement.executeQuery("UPDATE matchstats SET Kills = " + Kills + ", Deaths = " + Deaths + ", Assists = " + Assists + ", GoldEarned = " + GoldEarned + ", DealtDamage = " + DealtDamage + ", RecivedDamage = " + RecivedDamage + ", Team = " + Team + " WHERE Kills = " + Kills);
                            System.out.println("Done");

                            break;
                    }


                    break;
            }

        } while (!exit);
    }

    public static void Player(Connection connection) throws SQLException {

        boolean exit = false;
        Statement statement = connection.createStatement();
        statement.execute("USE chaos_conquest");

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

            ResultSet resultSet;
            int columnCount;

            switch (Lectura.numeroEnter()) {

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

                default:

                    System.out.println("Invalid option");
                    break;
            }
        } while (!exit);
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
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

        boolean exit = false;

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
                    exit = true;
                    break;

                case 1:

                    boolean exit1 = false;
                    Statement statement = connection.createStatement();
                    statement.execute("USE chaos_conquest");

                    selectMenu(exit1, statement);
                    break;

                case 2:

                    boolean exit2 = false;

                    break;

                case 3:

                    boolean exit3 = false;

                    break;

                case 4:

                    boolean exit4 = false;

                    break;

                default:
                    System.out.println("Invalid option");
            }
        } while (!exit);
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

                    String query = "INSERT INTO";

                    switch (Lectura.numeroEnter()){

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

                            query = query + " Player('Nickname', 'Level', `Rank`, 'MostPlayedChampion') VALUES(" + NickName + ", " + Level + " ," + Rank + ", " + MostPlayedChampion + ")";

                            statement.executeQuery(query);
                            System.out.println("Done");

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

                            query = query + " MatchHistory('ChampionsID', 'WinnerTeam', 'MatchDuration', 'MatchDate') VALUES(" + ChampionsID + ", " + WinnerTeam + ", " + MatchDuration + ", " + MatchDate + ")";
                            statement.executeQuery(query);
                            System.out.println("Done");

                            break;

                        case 3:

                            System.out.println("Insert the kills:");
                            int Kills = Lectura.numeroEnter();

                            System.out.println("Insert the deaths:");
                            int Deaths = Lectura.numeroEnter();

                            System.out.println("Insert the assists:");
                            int Assists = Lectura.numeroEnter();

                            System.out.println("Insert the Gold Earned:");
                            int GoldEarned = Lectura.numeroEnter();

                            System.out.println("Insert the Dealt Damage:");
                            int DealtDamage = Lectura.numeroEnter();

                            System.out.println("Insert the Recived Damage:");
                            int RecivedDamage = Lectura.numeroEnter();

                            System.out.println("Insert the Team:");
                            String Team = Lectura.cadena();

                            query = query + " MatchStats('Kills', 'Deaths', 'Assists', 'GoldEarned', 'DealtDamage', 'RecivedDamage', 'Team') VALUES(" + Kills + ", " + Deaths + ", " + Assists + ", " + GoldEarned + ", " + DealtDamage + ", " + RecivedDamage + ", " + Team + ")";

                            statement.executeQuery(query);
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

                    String query2 = "UPDATE";

                    switch (Lectura.numeroEnter()) {

                        case 0:


                            break;

                        case 1:

                            System.out.println("Wich column do you want to update");
                            System.out.println("0. Back");
                            System.out.println("1. Nickname");
                            System.out.println("2. Level");

                            switch (Lectura.numeroEnter()) {

                                case 0:

                                    break;

                                case 1:

                                    System.out.println("Insert the new Nickname");
                                    String Nickname = Lectura.cadena();
                                    query2 = query2 + " Player SET Nickname = " + Nickname + " WHERE Nickname = " + Nickname;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");

                                    break;

                                case 2:

                                    System.out.println("Insert the new Level");
                                    int Level = Lectura.numeroEnter();
                                    System.out.println("Insert the playerID");
                                    int playerID = Lectura.numeroEnter();
                                    query2 = query2 + " Player SET Level = " + Level + " WHERE ID = " + playerID;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");

                                    break;
                            }

                            break;

                        case 2:

                            System.out.println("Wich column do you want to update");
                            System.out.println("0. Back");
                            System.out.println("1. WinnerTeam");
                            System.out.println("2. MatchDuration");
                            System.out.println("3. MatchDate");
                            switch (Lectura.numeroEnter()) {

                                case 0:

                                    break;

                                case 1:

                                    System.out.println("Insert the new WinnerTeam");
                                    String WinnerTeam = Lectura.cadena();
                                    System.out.println("Insert the MatchID");
                                    int MatchID = Lectura.numeroEnter();
                                    query2 = query2 + " MatchHistory SET WinnerTeam = " + WinnerTeam + " WHERE ID = " + MatchID;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");

                                    break;

                                case 2:

                                    System.out.println("Insert the new MatchDuration");
                                    Time MatchDuration = Time.valueOf(Lectura.cadena());
                                    System.out.println("Insert the MatchID");
                                    int MatchID2 = Lectura.numeroEnter();
                                    query2 = query2 + " MatchHistory SET MatchDuration = " + MatchDuration + " WHERE ID = " + MatchID2;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");

                                    break;

                                case 3:

                                    System.out.println("Insert the new MatchDate");
                                    Date MatchDate = Date.valueOf(Lectura.cadena());
                                    System.out.println("Insert the MatchID");
                                    int MatchID3 = Lectura.numeroEnter();
                                    query2 = query2 + " MatchHistory SET MatchDate = " + MatchDate + " WHERE ID = " + MatchID3;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");

                                    break;
                            }

                            break;

                        case 3:

                            System.out.println("Wich column do you want to update");
                            System.out.println("0. Back");
                            System.out.println("1. Kills");
                            System.out.println("2. Deaths");
                            System.out.println("3. GoldEarned");

                            switch (Lectura.numeroEnter()) {

                                case 0:

                                    break;

                                case 1:

                                    System.out.println("Insert the new Kills");
                                    int Kills = Lectura.numeroEnter();
                                    System.out.println("Insert the MatchID");
                                    int MatchID = Lectura.numeroEnter();
                                    query2 = query2 + " matchstats SET Kills = " + Kills + " WHERE MatchID = " + MatchID;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");

                                    break;

                                case 2:

                                    System.out.println("Insert the new Deaths");
                                    int Deaths = Lectura.numeroEnter();
                                    System.out.println("Insert the MatchID");
                                    int MatchID2 = Lectura.numeroEnter();
                                    query2 = query2 + " matchstats SET Deaths = " + Deaths + " WHERE MatchID = " + MatchID2;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");

                                    break;

                                case 3:

                                    System.out.println("Insert the new GoldEarned");
                                    int GoldEarned = Lectura.numeroEnter();
                                    System.out.println("Insert the MatchID");
                                    int MatchID3 = Lectura.numeroEnter();
                                    query2 = query2 + " matchstats SET GoldEarned = " + GoldEarned + " WHERE MatchID = " + MatchID3;
                                    statement.executeQuery(query2);
                                    System.out.println("Done");
                                    break;
                            }

                            break;
                    }
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
            System.out.println("3.Check players on the server");
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

                    imprimirTabla("player", statement);
                    break;

                case 4:

                    imprimirTabla("champion", statement);
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

                    imprimirTabla("clash", statement);
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

            switch (Lectura.numeroEnter()) {

                case 0:

                    exit = true;
                    break;

                case 1:

                    imprimirTabla("champion", statement);

                    break;

                case 2:

                    imprimirTabla("championability", statement);

                    break;

                case 3:

                    imprimirTabla("competitiveRank", statement);

                    break;

                case 4:

                    imprimirTabla("damageType", statement);

                    break;

                case 5:

                    imprimirTabla("item", statement);

                    break;

                case 6:

                    imprimirTabla("itemstat", statement);

                    break;

                case 7:

                    imprimirTabla("patchHistory", statement);

                    break;

                case 8:

                    imprimirTabla("player", statement);

                    break;

                case 9:

                    imprimirTabla("rune", statement);

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

            switch (Lectura.numeroEnter()) {

                case 0:

                    exit = true;
                    break;

                case 1:

                    imprimirTabla("champion", statement);

                    break;

                case 2:

                    imprimirTabla("championability", statement);

                    break;

                case 3:

                    imprimirTabla("championskin", statement);

                    break;

                case 4:

                    imprimirTabla("clash", statement);

                    break;

                case 5:

                    imprimirTabla("clashparticipant", statement);

                    break;

                case 6:

                    imprimirTabla("competitiverank", statement);

                    break;

                case 7:

                    imprimirTabla("damagetype", statement);

                    break;

                case 8:

                    imprimirTabla("item", statement);

                    break;

                case 9:

                    imprimirTabla("itemloadout", statement);

                    break;

                case 10:

                    imprimirTabla("itemstat", statement);

                    break;

                case 11:

                    imprimirTabla("mastery", statement);

                    break;

                case 12:

                    imprimirTabla("matchhistory", statement);

                    break;

                case 13:

                    imprimirTabla("matchstats", statement);

                    break;

                case 14:

                    imprimirTabla("ownedchampions", statement);

                    break;

                case 15:

                    imprimirTabla("ownedskins", statement);

                    break;

                case 16:

                    imprimirTabla("patchhistory", statement);

                    break;

                case 17:

                    imprimirTabla("player", statement);

                    break;

                case 18:

                    imprimirTabla("rune", statement);

                    break;

                case 19:

                    imprimirTabla("runeLoadout", statement);

                    break;

                case 20:

                    imprimirTabla("runePath", statement);

                    break;

                default:

                    System.out.println("Invalid option");
                    break;
            }
        } while (!exit);
    }

    public static void imprimirTabla(String tabla, Statement statement) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla);
        int columnCount = resultSet.getMetaData().getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}
import java.sql.*;

public class Main {
    public static void main (String[] args) throws SQLException {

        boolean endProgram = false;
        Menu.connectUser();

        do {

            switch (Menu.checkRole()) {

                case 1:

                    Menu.Admin();
                    break;

                case 2:

                    Menu.Developer();
                    break;

                case 3:

                    Menu.DataAnalist();
                    break;

                case 4:

                    Menu.ComunityMod();
                    break;

                case 5:

                    Menu.Player();
                    break;

                case 6:

                    Menu.PublicVisitant();
                    break;
            }

            Menu.connectUser();
        } while(!endProgram);

    }
}
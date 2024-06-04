import java.sql.Connection;

public class Main {
    public static void main (String[] args) {

        boolean endProgram = false;

        do {

            Connection connection = Menu.connectUser();

            switch (Menu.checkRole()) {

                case 1:

                    Menu.Admin(connection);
                    break;

                case 2:

                    Menu.Developer(connection);
                    break;

                case 3:

                    Menu.DataAnalist(connection);
                    break;

                case 4:

                    Menu.ComunityMod(connection);
                    break;

                case 5:

                    Menu.Player(connection);
                    break;

                case 6:

                    Menu.PublicVisitant(connection);
                    break;
            }

            if (Menu.checkExit()){

                System.out.println("Bye!");
                endProgram = true;
            }

        } while(!endProgram);
    }
}
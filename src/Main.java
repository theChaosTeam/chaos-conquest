public class Main {
    public static void main (String[] args) {

        boolean endProgram = false;

        do {

            Menu.connectUser();

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

            if (Menu.checkExit()){
                endProgram = true;
            }

        } while(!endProgram);

    }
}
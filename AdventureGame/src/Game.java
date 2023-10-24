import java.util.Scanner;

public class Game {

    private Scanner getData = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to Adventure Game !!!");
        System.out.print("Please enter a nickname : ");
        String playerName = getData.nextLine();
        Player player = new Player(playerName);
        System.out.println("**********************************************************************************");
        System.out.println("Welcome " + player.getName() + " !! " + " This wont be ordinary adventure -.- !! ");
        System.out.println("This will be sweet , competative & PAINFUL ^Ô-Ô^ ");
        System.out.println("**********************************************************************************");
        System.out.println("Please select a character class !!!");
        player.selectChar();

        Location location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("**************************************************");
            System.out.println("                     Locations");
            System.out.println("**************************************************");
            System.out.println("1-) Safe House > This is safe place from enemies !");
            System.out.println("2-) Store > You can buy weapons and armor here !");
            System.out.println("3-) The Cave > Award <Food>...This is dangerous...There is a restless zombies around !");
            System.out.println("4-) The Forest > Award <Wood>...This is too risky...Legends says there is a bloodsucker vampires in woods... ");
            System.out.println("5-) The Riverside > Award <Water>...The Riverside hosts so many wild bears...You have to be cautions... ");
            System.out.println("6-) The Mines > Award <Random Loots>...This is not a mine...This is graveyard..");
            System.out.println("0-) Quit > Quit the Game.");

            System.out.println();

            System.out.print("Please select your destination : ");
            int selectLoc = getData.nextInt();
            switch (selectLoc){
                case 0 :
                    location = null;
                    break;
                case 1 :
                    location = new SafeHouse(player); // player
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                case 3 :
                    location = new Cave(player);
                    break;
                case 4 :
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;
                case 6 :
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please enter valid location ! ");

            }

            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInventory().getMapPrize().getWater() == 1 && player.getInventory().getMapPrize().getFireWood() == 1 && player.getInventory().getMapPrize().getFood() == 1){

                    System.out.println("Congratulations !! , You collect all map prizes... !!");
                    break;

                }
            }

            if(location == null){

                System.out.println("Game Ended...Thank you for playing...");
                break;
            }
            if(!location.onLocation()){
                System.out.println(location.getName());
                System.out.println("GAME OVER !");
                break;

            }
        }


    }

}

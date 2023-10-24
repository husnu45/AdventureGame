public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("...Welcome to Store...");
        boolean showMenu = true;
        while(showMenu) {
            System.out.println("************************");
            System.out.println("1-) Weapons");
            System.out.println("2-) Armors");
            System.out.println("3-) Exit");
            System.out.print("Your Choise : ");

            int selectCase = Location.getData.nextInt();

            while (selectCase < 1 || selectCase > 3) {  // aşağıdaki switch case içine default olarak da atılabilir.
                System.out.println("Invalid Selection...Please try again...");
                selectCase = Location.getData.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Thanks for visiting store...");
                    showMenu = false;
                    break;


            }
        }
        return true;

    }

    public void printWeapon() {
        System.out.println("--- Weapons ---");

        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " <Price : " + w.getPrice() + " , Damage : " + w.getDamage() + ">");
        }

        System.out.println("0-Exit");

    }

    public void buyWeapon() {

        System.out.print("Select a Weapon : ");
        int selectWeaponID = getData.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid Selection...Please try again...");
            selectWeaponID = Location.getData.nextInt();
        }

        if (selectWeaponID != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {

                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough money :( ");

                } else {  // Satın Almanın Gerçekleşmesi
                    System.out.println(selectedWeapon.getName() + " has been bought...");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your new balance is : " + this.getPlayer().getMoney());
                    //  System.out.println("Previous Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    //  System.out.println("New Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                }


            }


        }
    }

    public void printArmor() {
        System.out.println("--- Armors ---");

        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() + " <Price : " + a.getPrice() + " , Block Rate : " + a.getBlock() + ">");
        }

        System.out.println("0-Exit");




    }

    public void buyArmor(){

        System.out.print("Select an Armor : ");
        int selectArmorID = getData.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid Selection...Please try again...");
            selectArmorID = Location.getData.nextInt();
        }

        if(selectArmorID !=0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Not Enough Money...");
                }else{
                    System.out.println(selectedArmor.getName() + " has been bought !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your Balance is " + this.getPlayer().getMoney());
                }
            }
        }



    }
}
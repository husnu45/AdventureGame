import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getTotalDamage(){
        return damage + this.inventory.getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void selectChar(){

        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};  // Polymorphism
        System.out.println("-----------------------------------------------------------");
        System.out.println("                      CLASSES");
        System.out.println("-----------------------------------------------------------");
        for(GameChar gameChar : charList){ // For Each
            System.out.println("ID : " + gameChar.getId() +
                    " Class : " + gameChar.getName() +
                    "\t Damage : " + gameChar.getDamage() +
                    "\t Health : " + gameChar.getHealth() +
                    "\t Money : " + gameChar.getMoney() );
        }
        System.out.println("-----------------------------------------------------------");
        System.out.print("Please Select Your Class By ID : ");
        int selectChar = input.nextInt();
        switch(selectChar){
            case 1 :
                initPlayer(new Samurai());
                break;
            case 2 :
                initPlayer(new Archer());
                break;
            case 3 :
                initPlayer(new Knight());
                break;
            default: initPlayer(new Samurai());
        }
       // System.out.println("-----------------------------------------------------------");
       //  System.out.println("Selected Class : " + this.getCharName() + ", Damage : " + this.getDamage() + ", Health : " + this.getHealth() + ", Money : " + this.getMoney() );
       //  System.out.println("-----------------------------------------------------------");

    }



    public void initPlayer(GameChar gameChar){   // ..
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("************************************************************************************************************************************");
        System.out.println(
                "Weapon : " + this.getInventory().getWeapon().getName() +
                " | Armor : "  + this.getInventory().getArmor().getName() +
                " | Block Rate : "  + this.inventory.getArmor().getBlock() +
                " | Damage : " + this.getTotalDamage() +
                " | Health : " + this.getHealth() +
                " | Money : " + this.getMoney() +
                " | Prizes > " + "Food : " + this.getInventory().getMapPrize().getFood() + " | " + " Firewood : " + getInventory().getMapPrize().getFireWood() + " | " + " Water : " + getInventory().getMapPrize().getWater());
        System.out.println("************************************************************************************************************************************");
    }
}

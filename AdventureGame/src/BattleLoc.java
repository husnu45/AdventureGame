import java.util.Random;

public abstract class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;






    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    @Override
    public boolean onLocation() {



        int obsNumber = this.randomObstacleNumber();
        System.out.println("Now you are here : " + this.getName());
        System.out.println("Be Careful ! You can encounter with " + obsNumber + " " + this.obstacle.getName() + " ! ");
        System.out.print("<F>ight or <R>un Away : ");
        String selectCase = getData.nextLine().toUpperCase();


        if(selectCase.equals("F") && combat(obsNumber)){
            // Savaşma işlemi
            System.out.println("Battle has commence...");

                System.out.println(this.getName() + " is cleared..." );
                return true;



        }

        if(this.getPlayer().getHealth() <= 0){
            System.out.println("You DIED ....");
            return false;
        }




        return true;
    }

    public boolean combat(int obsNumber) {
        Random random = new Random();
        int whoAttacksFirst = random.nextInt(2); // 0 veya 1 üretecek, %50 olasılıkla

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);

            if (whoAttacksFirst == 0) {
                // Rakip ilk saldırır
                System.out.println("Enemy Attacked!");
                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                if (obstacleDamage < 0) {
                    obstacleDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                afterHit();
            }

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<H>it or <R>un Away : ");
                String selectCombat = getData.nextLine();
                if (selectCombat.equals("H")) {
                    System.out.println("You hit!");
                    this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println("Enemy Attacked!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Enemy has been slain!");
                System.out.println(this.getObstacle().getAward() + " money claimed.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your balance is : " + this.getPlayer().getMoney());

                if(this.getName().equals("The Cave")){
                    System.out.println("The Cave is cleared.You won Map Prize : Food ");
                    this.getPlayer().getInventory().getMapPrize().setFood(1);


                }

                if(this.getName().equals("The Forest")){
                    System.out.println("The Forest is cleared.You won Map Prize : Firewood ");
                    this.getPlayer().getInventory().getMapPrize().setFireWood(1);


                }

                if(this.getName().equals("The River")){
                    System.out.println("The Riverside is cleared.You won Map Prize : Water ");
                    this.getPlayer().getInventory().getMapPrize().setWater(1);


                }



            } else {
                return false;
            }
        }

        return true;
    }

    public void afterHit(){
        System.out.println("Your Health : " + this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName() + "'s Health : " + this.obstacle.getHealth());
        System.out.println("---------------");
    }

    public void playerStats(){
        System.out.println("Player Stats");
        System.out.println("-------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block Rate : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : " + this.getPlayer().getMoney());
        System.out.println();



    }

    public void obstacleStats(int i){
        System.out.println(i + ".Enemy : " + this.getObstacle().getName());
        System.out.println("-----------------------------------------");
        System.out.println("Health : " + this.getObstacle().getHealth());
        System.out.println("Damage : " + this.getObstacle().getDamage());
        System.out.println("Award : " + this.getObstacle().getAward());
        System.out.println();
    }



    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;   // Max obstacle 0,1,2 + 1

    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }


}

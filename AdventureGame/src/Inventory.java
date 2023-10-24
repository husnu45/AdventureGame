public class Inventory {

    private Weapon weapon;
    private Armor armor;

    private MapPrize mapPrize;





    public Inventory() {
        this.weapon = new Weapon("Fist",-1,0,0);
        this.armor = new Armor(-1,"None",0,0);
        this.mapPrize = new MapPrize(0,0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public MapPrize getMapPrize() {
        return mapPrize;
    }

    public void setMapPrize(MapPrize mapPrize) {
        this.mapPrize = mapPrize;
    }
}

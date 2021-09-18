abstract public class Monster extends Character{

    public Monster(String name, int healthPoint, int strength, int smartness, int expirience) {
        super(name, healthPoint, strength, smartness, expirience, 0);
    }

    @Override
    public String toString() {
        return this.getName() +"(сила " + this.getStrength() + ", ловкость " + this.getSmartness() + ")";
    }
}

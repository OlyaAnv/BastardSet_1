//Класс-макет для создания персонажей игры

abstract public class Character {
    private String name;
    private int healthPoint;
    private int strength;
    private int smartness;
    private int expirience;
    private int money;

    public abstract void attack(Character character,int force);

    public void setExpirience(int expirience) {
        this.expirience = expirience;
    }

    public String getName() {
        return name;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public Character(String name, int healthPoint, int strength, int smartness, int expirience, int money) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.strength = strength;
        this.smartness = smartness;
        this.expirience = expirience;
        this.money = money;
    }

    public int getStrength() {
        return strength;
    }

    public int getSmartness() {
        return smartness;
    }

    public int getMoney() {
        return money;
    }

    public int getExpirience() {
        return expirience;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

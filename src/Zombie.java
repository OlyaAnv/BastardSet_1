public class Zombie extends Monster{

    public Zombie(String name, int healthPoint, int strength, int smartness, int expirience) {
        super(name, healthPoint, strength, smartness, 0);
    }


    public void attack(Character character, int damage) {
        System.out.println("Зомби атакует игрока");
        if(character.getHealthPoint() > damage)
            character.setHealthPoint(character.getHealthPoint() - damage);
        else character.setHealthPoint(0);
    }
}

public class Hog extends Monster {
    public Hog(String name, int healthPoint, int strength, int smartness, int expirience) {
        super(name, healthPoint, strength, smartness, 0);
    }


    @Override
    public void attack(Character character, int damage) {
        System.out.println("Кабан атакует " + character.getName());
        if (character.getHealthPoint() > damage) {
            character.setHealthPoint(character.getHealthPoint() - damage);
            System.out.println(this.getName() + " наносит удар в " + damage + " единиц! ");
        } else { character.setHealthPoint(0);
            System.out.println("РРРР!");}
    }
}

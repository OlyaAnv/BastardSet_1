public class Hog extends Monster {
    public Hog(String name, int healthPoint, int strength, int smartness, int expirience) {
        super(name, healthPoint, strength, smartness, 0);
    }


    @Override
    public void attack(Character character, int damage) {
        //System.out.println("Кабан нападает ");
        if (character.getHealthPoint() > damage) {
            character.setHealthPoint(character.getHealthPoint() - damage);
            if (damage>0) System.out.println(this.getName() + " нападает и наносит удар в " + damage + " единиц! (Здоровье " +  this.getName() + " " + this.getHealthPoint() + ")");
            else System.out.println(this.getName() + " промахивается (Здоровье " + this.getName() + "а " + this.getHealthPoint() + ")");
            System.out.println("");
        } else { character.setHealthPoint(0);
            System.out.println("РРРР!");}
    }
}

public class Zombie extends Monster {

    public Zombie(String name, int healthPoint, int strength, int smartness, int expirience) {
        super(name, healthPoint, strength, smartness, 0);
    }


    public void attack(Character character, int damage) {
        //System.out.println("Зомби атакует ");
        if (character.getHealthPoint() > damage) {
            character.setHealthPoint(character.getHealthPoint() - damage);
            if (damage>0) System.out.println(this.getName() + " атакует и наносит удар в " + damage + " единиц! (Здоровье " +  this.getName() + " " + this.getHealthPoint() + ")");
            else System.out.println(this.getName() + " промахивается (Здоровье " + this.getName() + " " + this.getHealthPoint() + ")");
            System.out.println("");
        } else {character.setHealthPoint(0);
            System.out.println("УУУУУУ!");}
    }
}

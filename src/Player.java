import java.util.ArrayList;

//Игрок
public class Player extends Character {
    int MAX_HEALTH = 200;
    ArrayList<Object> bag = new ArrayList<>();//Сумка для зелий
    private int isPrise = 0;

    public void setPrise(int prise) {
        isPrise = prise;
    }

    public int isPrise() {
        return isPrise;
    }

    @Override
    public void attack(Character character, int damage) {
        //System.out.println(this.getName() + " атакует монстра");
        if (character.getHealthPoint() > damage) {
            character.setHealthPoint(character.getHealthPoint() - damage);
            if (damage>0) System.out.println(this.getName() + " наносит удар в " + damage + " единиц! (Здоровье " + this.getHealthPoint() + ")");
            else System.out.println(this.getName() + " промахивается (Здоровье " + this.getHealthPoint() + ")");
        } else {
            character.setHealthPoint(0);
            System.out.println("УРА!!!");
        }

    }

    public Player(String name, int healthPoint, int strength, int smartness, int expirience, int money) {
        super(name, healthPoint, strength, smartness, expirience, money);
    }


    //Вывод на экран параметров игрока
    public void playerInfo() {
        System.out.println("Справа вверху на экране ----> " + this.getName() + " (Здоровье - " + this.getHealthPoint() + ", Деньги - " + this.getMoney() + " монет, Опыт - " + this.getExpirience() + ")");
    }

    //Покупка товаров по заданной цене price, возвращает true если хватило денег для покупки товара obj
    public boolean buyItem(int price, Object obj) {
        int money = this.getMoney();
        if (money >= price) {
            money -= price;
            this.setMoney(money);
            bag.add(obj);
            //this.playerInfo();
            //System.out.println("У вас осталось " + this.getMoney() + " монет.");
            return true;
        } else {
            this.playerInfo();
            System.out.println("У вас недостаточно денег");
            return false;
        }
    }

    public void drinkDrug() {
        if (bag != null) {
            int health = (int) bag.get(bag.size() - 1);
            if ((this.getHealthPoint() + health) < MAX_HEALTH)
                this.setHealthPoint((this.getHealthPoint() + health));
            else this.setHealthPoint(MAX_HEALTH);
        }
    }
}

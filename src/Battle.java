import java.util.Random;

public class Battle implements Runnable {
    Player player;
    Monster monster;
    Random random;
    Thread thread;

    public Thread getThread() {
        return thread;
    }

    public Battle(Player player) {
        this.player = player;
        random = new Random();
        thread = new Thread(this, "Поток битвы");
        if (player.getExpirience() >= 200) {
            monster = new Zombie("зомби", 100, 1, 3, 0);
        } else if (player.getExpirience() >= 100) {
            if (random.nextInt(100) > 50) monster = new Hog("кабан", 100, 13, 15, 0);
            else monster = new Zombie("зомби", 100, 9, 20, 0);
        } else if (player.getExpirience() < 100) {
            if (random.nextInt(100) > 50) monster = new Hog("кабан", 100, 11, 15, 0);
            else monster = new Zombie("зомби", 100, 7, 20, 0);
        }
        battleStart();
    }

    public void battleStart() {
        player.playerInfo();
        System.out.println("Вошли в лес.\nВам встретился монстр.");
        System.out.println(monster);
        System.out.println("______________________");
        thread.start();
    }

    private int randomDamage(Character character) {
        if (character.getSmartness() * 3 > random.nextInt(100))
            return character.getStrength();
        else return 0;
    }

    public void win() {
        player.playerInfo();
        System.out.println("Вышли из леса");//Ориентируем игрока
        System.out.println("Куда вы хотите пойти?\n 1. К торговцу\n 2. В тёмный лес\n 3. На выход");
    }

    @Override
    public void run() {

        while (true) {
            if (player.getHealthPoint() > 0) {
                player.attack(monster, randomDamage(player));
                try {
                    thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (monster.getHealthPoint() == 0) {
                player.setMoney(player.getMoney() + 50);
                player.setExpirience(player.getExpirience() + 35);
                System.out.println("Вы победили");
                try {
                    thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((player.getExpirience() > 100) && (player.isPrise() == 0)) {
                    System.out.println("Вы набрали 100 очков! Приз ждет в лавке торговца");
                    player.setPrise(1);
                }
                win();
                break;
            }
            if (monster.getHealthPoint() > 0) {
                monster.attack(player, randomDamage(monster));
                try {
                    thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (player.getHealthPoint() == 0) {
                System.out.println("Вы убиты");
                try {
                    thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }
}


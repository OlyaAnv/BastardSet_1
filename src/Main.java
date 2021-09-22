import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Приветствуем игрока, объясняем правила и создаем игрового персонажа
        System.out.println();
        System.out.println("Добро пожаловать в игру BastardSet. Сражайтесь с монстрами и зарабатывайте опыт. Когда наберете 100 очков - получите приз\n"+
                        "Введите имя персонажа");
        String playerName = new Scanner(System.in).nextLine();
        Player player = new Player(playerName, 100, 10, 15, 0, 10);

        //Входим в игру
        mainScene(player);
    }

    //Главная сцена игры
        public static void mainScene(Player player) throws InterruptedException {
            player.playerInfo(); //Выводим на экран показатели игрока
            boolean isPlay = true; //Флаг, влияющий на завершение игры
            Scanner scan = new Scanner(System.in);
            System.out.println("Куда вы хотите пойти?\n 1. К торговцу\n 2. В тёмный лес\n 3. На выход");
            while (isPlay) {
                int answer = scan.nextInt();
                switch (answer) {
                    case 1: {
                        new Bench(player);//Игрок переходит в сцену с лавкой
                        break;
                    }
                    case 2: {
                        Battle battle = new Battle(player);//Игрок переходит в сцену со сражением
                        battle.getThread().join();
                        if (player.getHealthPoint() == 0) isPlay = false;
                        break;
                    }
                    case 3: {
                        isPlay = false;//Игра завершается
                        break;
                    }
                }
            }
        }

}

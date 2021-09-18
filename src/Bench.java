import java.util.Scanner;

public class Bench {
    Player player;
    Merchant merchant;

    public Bench(Player player) {
        this.player = player;
        this.merchant = new Merchant("Торговец зельями");
        Scanner scan = new Scanner(System.in);
        player.playerInfo();
        System.out.println("Вошли в лавку");//Ориентируем игрока
        if(player.getExpirience()>100 && (player.isPrise()==1)){
            player.setPrise(2);
            System.out.println("ПРИЗ! ПРИЗ! ПРИЗ!");
        }
        merchant.assortiment();//На экран выводится информация о товарах кокретного торговца
        boolean isBench = true;//Флаг нахождения в лавке

        while (isBench) {
            int answer = scan.nextInt();
            switch (answer) {
                case 1: {
                    int[] item = merchant.priceList(1);//Возвращаем игроку цену и товар
                    if (player.buyItem(item[0],item[1])) {//Проверяем, что игрок смог купить товар по этой цене
                        player.drinkDrug();
                        player.playerInfo();
                        System.out.println("Вы купили маленькое зелье");
                    }
                    break;
                }
                case 2: {
                    int[] item = merchant.priceList(2);//Возвращаем игроку цену и товар
                    if (player.buyItem(item[0],item[1])) {//Проверяем, что игрок смог купить товар по этой цене
                        player.drinkDrug();
                        player.playerInfo();
                        System.out.println("Вы купили большое зелье");
                    }
                    break;
                }
                case 3: {
                    isBench = false;//Завершаем бесконечный цикл диалога с игроком
                    break;
                }
            }
        }
        player.playerInfo();
        System.out.println("Вышли из лавки");//Ориентируем игрока
        System.out.println("Куда вы хотите пойти?\n 1. К торговцу\n 2. В тёмный лес\n 3. На выход");
    }
}

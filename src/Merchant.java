import java.util.Scanner;

public class Merchant extends Character{
    Drugs drugs;

    @Override
    public void attack(Character character, int force) {

    }


    class Drugs{
        public int[] DRUG_SMALL_PRICE = new int[]{10, 20};//массив [цена,улучшение здоровья]
        public int[] DRUG_BIG_PRICE = new int[]{20, 40};//массив [цена,улучшение здоровья]
    }

    public Merchant(String name) {
        super(name, 0, 0, 0, 0, 0);
        this.drugs = new Drugs();
    }



//Вывод на экран ассортимента товара
    public void assortiment(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Добро пожаловать в лавку торговца. Здесь вы можете купить лечебные зелья.\n"+
                " Зелье маленькое - " + this.drugs.DRUG_SMALL_PRICE[0]+ " монет\n"+
                " Зелье большое - " + this.drugs.DRUG_BIG_PRICE[0] + " монет\n"+
                "__________________________\nЧто будете брать?\n"+
                "1. Маленькое зелье\n2. Большое зелье\n3. Ничего не покупать. Уйти из лавки");
    }

//Возвращает цену выбранного товара
    public int[] priceList(int answer) {
        if(answer == 1) return drugs.DRUG_SMALL_PRICE;
        if(answer == 2) return drugs.DRUG_BIG_PRICE;
        else return null;
    }
}

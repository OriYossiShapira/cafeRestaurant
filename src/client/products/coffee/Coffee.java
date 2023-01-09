package client.products.coffee;

import java.util.Scanner;

public class Coffee {
    private ECoffeeProducts base;

    private ECoffeeProducts milk;

    private int sugarAmount;

    private int cost;

    private Coffee(CoffeeBuilder builder){
        this.milk = builder.milk;
        this.base = builder.base;
        this.sugarAmount = builder.sugarAmount;
        this.cost = this.base.getCost() + this.milk.getCost() + (ECoffeeProducts.SUGAR.getCost() * this.sugarAmount);
    }

    public static class CoffeeBuilder{

        private ECoffeeProducts base;

        private ECoffeeProducts milk;

        private int sugarAmount;

        public Scanner input = new Scanner(System.in);

        public CoffeeBuilder withMilk(){
            System.out.println("""
                    Please select your desired milk type.
                    
                    1) Milk
                    2) Almond Milk
                    3) Soy milk
                    """);
            int choice = input.nextInt();
            switch (choice){
                case 1 -> {
                    this.milk = ECoffeeProducts.MILK;
                }
                case 2 -> {
                    this.milk = ECoffeeProducts.ALMOND_MILK;
                }
                case 3 -> {
                    this.milk = ECoffeeProducts.SOY_MILK;
                }
            }
            return this;
        }

        public CoffeeBuilder chooseBase(){
            System.out.println("""
                    Please select your desired coffee base.
                    
                    1) Espresso
                    2) Espresso lungo
                    """);
            int choice = input.nextInt();
            switch (choice){
                case 1 -> {
                    this.base = ECoffeeProducts.ESPRESSO;
                }
                case 2 -> {
                    this.base = ECoffeeProducts.ESPRESSO_LUNGO;
                }
            }
            return this;
        }

        public CoffeeBuilder addSugar(int sugarAmount){
            this.sugarAmount = sugarAmount;
            return this;
        }

        public Coffee build(){
            return new Coffee(this);
        }
    }

    public String toString(){
        return "base = " + base.getProductName() + " milk = " + milk.getProductName() + " sugar amount = " + sugarAmount + "\nCosts" + cost;
    }


}

package client.factories;

public class TelAvivBranch implements IBranch{


    @Override
    public void acceptOrder() {
        System.out.println("Tel Aviv branch accepted your order");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Tel Aviv branch making your coffee");
    }

    @Override
    public void makeMeal() {
        System.out.println("Tel Aviv branch making your meal");
    }

    @Override
    public void showMenu() {
        System.out.println("Tel Aviv branch showing menu");
    }

}

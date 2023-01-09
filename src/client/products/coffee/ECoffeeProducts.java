package client.products.coffee;

public enum ECoffeeProducts {
    ESPRESSO("espresso", 5),
    ESPRESSO_LUNGO("espresso lungo", 6),
    MILK("milk", 2),
    SUGAR("sugar", 1),
    ALMOND_MILK("almond milk", 2),
    SOY_MILK("soy milk", 2);

    private final int cost;

    private final String productName;

    ECoffeeProducts(String productName, int cost) {
        this.cost = cost;
        this.productName = productName;
    }

    public int getCost() {
        return cost;
    }

    public String getProductName() {
        return productName;
    }
}

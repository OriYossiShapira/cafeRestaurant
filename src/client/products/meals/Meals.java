package client.products.meals;

public class Meals {
    private final String name;
    private final String description;
    private final int price;

    Meals(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
    public class MealBuilder {
        private String name;
        private String description;
        private int price;

        public MealBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MealBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MealBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Meals build() {
            return new Meals(name, description, price);
        }
    }

}
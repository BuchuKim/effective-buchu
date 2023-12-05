package org.example.market;

import lombok.NonNull;
import org.example.exception.NoAvailableIngredientException;

public class Ingredient {
    private String name;
    private int price;
    private int amount;

    private Ingredient(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public static Ingredient of(@NonNull String name, @NonNull int price, @NonNull int amount) {
        return new Ingredient(name, price, amount);
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    /**
     * 인자로 주어진 amount만큼 현재 재료의 양을 감소시킨다.
     * @param amount 필요한 재료 개수
     */
    public void subtractAmount(int amount) {
        if (this.amount < amount) {
            throw new NoAvailableIngredientException(this.name, amount);
        }
        this.amount -= amount;
    }
}

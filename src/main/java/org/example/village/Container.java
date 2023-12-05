package org.example.village;

import lombok.Getter;
import org.example.exception.NotEnoughBalanceException;
import org.example.farm.crops.Crop;
import org.example.market.Ingredient;
import org.example.market.Packaging;

import java.util.ArrayList;
import java.util.List;

/**
 * 마을이 가지고 있는 재산? 창고?
 */
@Getter
public class Container {
    private final List<Ingredient> ingredients;
    private static final Container container = new Container();
    private int money;
    private Packaging<Crop> inventory;

    private Container() {
        this.ingredients = new ArrayList<>();
        this.money = 1000;
    }

    public static Container getInstance() {
        return Container.container;
    }

    public void setInventory(Packaging<Crop> packaging) {
        this.inventory = packaging;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void subtractMoney(int amount) {
        if (this.money < amount) {
            throw new NotEnoughBalanceException(amount, this.money);
        }
        money -= amount;
    }
}

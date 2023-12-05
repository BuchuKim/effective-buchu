package org.example.market;

import org.example.exception.NoAvailableIngredientException;
import org.example.farm.crops.Crop;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private final List<Ingredient> ingredients = new ArrayList<>();

    /**
     * amount 개수만큼의 ingredientName을 가진 재료의 가격을 반환한다.
     * @param ingredientName 재료 이름
     * @param amount 재료 양
     * @return 가격
     */
    public int calculatePrice(String ingredientName, int amount) {
        Ingredient foundIngredient = ingredients.stream()
                .filter(ingredient -> ingredient.getName().equals(ingredientName))
                .findAny().orElseThrow(() -> new NoAvailableIngredientException(ingredientName, amount));

        return foundIngredient.getPrice() * amount;
    }

    /**
     * amount 만큼의 재료를 반환한다
     * @param ingredientName
     * @param amount
     * @return
     */
    public Ingredient trade(String ingredientName, int amount) {
        Ingredient foundIngredient = ingredients.stream()
                .filter(ingredient -> ingredient.getName().equals(ingredientName))
                .findAny().orElseThrow(() -> new NoAvailableIngredientException(ingredientName, amount));
        foundIngredient.subtractAmount(amount);
        return Ingredient.of(ingredientName, foundIngredient.getPrice(), amount);
    }

    public int sell(Packaging<Crop> packaging) {
        int totalProfit = packaging.getTotalProfit();
        packaging.removeAll();
        return totalProfit;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}

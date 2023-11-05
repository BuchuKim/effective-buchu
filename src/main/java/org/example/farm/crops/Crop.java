package org.example.farm.crops;

public abstract class Crop {
    protected int amount;
    // 개당 가격
    protected int price;
    // 개당 수익
    protected int profit;
    protected String name;

    public int requiredMoney() {
        return amount * price;
    }

    public int totalProfit() {
        return amount * profit;
    };

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}

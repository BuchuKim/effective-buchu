package org.example.farm.crops;

public class Banana extends Crop {
    private static final int BANANA_PRICE = 20;
    private static final int BANANA_PROFIT = 50;

    // ITEM 4 : 인스턴스화를 막기 위한 private 생성자
    private Banana(int amount) {
        this.price = BANANA_PRICE;
        this.profit = BANANA_PROFIT;
        this.name = "바나나";
        this.amount = amount;
    }

    // ITEM 1 : 정적 팩토리 메소드
    public static Banana amountOf(int amount) {
        return new Banana(amount);
    }
}

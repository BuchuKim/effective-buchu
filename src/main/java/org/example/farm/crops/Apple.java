package org.example.farm.crops;

public class Apple extends Crop {
    private static final int APPLE_PRICE = 10;
    private static final int APPLE_PROFIT = 20;

    // ITEM 4 : 인스턴스화를 막기 위한 private 생성자
    private Apple(int amount) {
        this.price = APPLE_PRICE;
        this.profit = APPLE_PROFIT;
        this.name = "사과";
        this.amount = amount;
    }

    // ITEM 1 : 정적 팩토리 메소드
    public static Apple amountOf(int amount) {
        return new Apple(amount);
    }
}

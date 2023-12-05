package org.example.market;

import org.example.farm.crops.Crop;

import java.util.ArrayList;
import java.util.List;

public class Packaging<T extends Crop> {
    private List<T> products;

    public Packaging(List<T> products) {
        this.products = products;
    }

    /**
     * 현재 패키지의 전체 수익을 반환한다
     * @return total profit
     */
    public int getTotalProfit() {
        return products.stream().mapToInt(Crop::totalProfit).sum();
    }

    /**
     * 현재 패키지의 전체 작물 개수를 반환한다
     * @return total amount
     */
    public int getTotalAmount() {
        return products.stream().mapToInt(Crop::getAmount).sum();
    }

    public void removeAll() {
        products = new ArrayList<>();
    }
}

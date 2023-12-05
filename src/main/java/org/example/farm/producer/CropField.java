package org.example.farm.producer;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.NotEnoughBalanceException;
import org.example.farm.crops.Crop;
import org.example.market.Packaging;
import org.example.village.Container;

import java.util.ArrayList;

@Slf4j
public class CropField {
    private final ArrayList<Crop> crops = new ArrayList<>();
    private static final CropField cropField = new CropField();

    // ITEM 4 : 인스턴스 생성을 원치 않을 때 private 생성자
    private CropField() {}

    public static CropField getInstance() {
        return cropField;
    }

    /**
     * amount 만큼의 작물을 심는다
     * @param crop 심을 작물
     */
    public void plant(Crop crop, Container container) {
        if (crop.requiredMoney() >= container.getMoney()) {
            throw new NotEnoughBalanceException(crop.requiredMoney(), container.getMoney());
        }
        container.subtractMoney(crop.requiredMoney());
        crops.add(crop);
    };

    /**
     * 현재 field에 존재하는 작물을 전부 수확한 결과물을 반환한다.
     * @return profit
     */
    public Packaging<Crop> harvest() {
        crops.forEach(crop -> log.info("{} {}개 수확", crop.getName(), crop.getAmount()));
        return new Packaging<>(crops);
    };
}

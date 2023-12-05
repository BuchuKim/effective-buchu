package org.example.village;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.example.farm.crops.Crop;
import org.example.farm.producer.CropField;
import org.example.market.Market;
import org.example.market.Packaging;

@AllArgsConstructor
@Builder
@Slf4j
public class Village {
    // ITEM 5 : 의존 객체 주입
    // ITEM 2 : Builder (lombok)
    private final CropField cropField;
    private final Container container;
    private final Market market;

    /**
     * 인자로 들어온 Crop 객체를 밭에 심는다.
     * @param crop 심을 작물
     */
    public void plantCrop(Crop crop) {
        cropField.plant(crop, container);
    }

    /**
     * 현재 밭에 존재하는 모든 Crop을 수확한다.
     */
    public void harvestCrop() {
        Packaging<Crop> products = cropField.harvest();
        container.setInventory(products);
    }

    /**
     * 현재 창고에 있는 모든 Crop을 시장에 판다
     */
    public void sellCrops() {
        int earned = market.sell(container.getInventory());
        log.info("{}원 얻음", earned);
        container.addMoney(earned);
    }

    /**
     * 현재 마을의 상태를 출력한다.
     */
    public void printState() {
        log.info("현재 잔고 : {}원", container.getMoney());
    }
}

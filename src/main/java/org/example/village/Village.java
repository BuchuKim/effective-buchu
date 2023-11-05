package org.example.village;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.example.farm.crops.Crop;
import org.example.farm.producer.CropField;

@AllArgsConstructor
@Builder
@Slf4j
public class Village {
    // ITEM 5 : 의존 객체 주입
    // ITEM 2 : Builder (lombok)
    private final CropField cropField;
    private int money;

    /**
     * 인자로 들어온 Crop 객체를 밭에 심는다.
     * @param crop 심을 작물
     */
    public void plantCrop(Crop crop) {
        cropField.plant(crop, money);
    }

    /**
     * 현재 밭에 존재하는 모든 Crop을 수확한다.
     */
    public void harvestCrop() {
        money += cropField.harvest();
    }

    /**
     * 현재 마을의 상태를 출력한다.
     */
    public void printState() {
        log.info("현재 잔고 : {}원", money);
    }
}

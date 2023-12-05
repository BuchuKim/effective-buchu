package org.example;

import org.example.farm.crops.Apple;
import org.example.farm.crops.Banana;
import org.example.farm.producer.CropField;
import org.example.market.Market;
import org.example.village.Container;
import org.example.village.Village;

public class Main {
    public static void main(String[] args) {
        Village village = Village.builder()
                .container(Container.getInstance())
                .cropField(CropField.getInstance())
                .market(new Market())
                .build();

        village.plantCrop(Apple.amountOf(10));
        village.plantCrop(Banana.amountOf(20));

        village.harvestCrop();
        village.sellCrops();
        village.printState();
    }
}
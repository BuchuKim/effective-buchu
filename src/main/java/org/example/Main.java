package org.example;

import org.example.farm.crops.Apple;
import org.example.farm.crops.Banana;
import org.example.farm.producer.CropField;
import org.example.village.Village;

public class Main {
    public static void main(String[] args) {
        Village village = Village.builder()
                .money(10000)
                .cropField(CropField.getInstance())
                .build();

        village.plantCrop(Apple.amountOf(10));
        village.plantCrop(Banana.amountOf(20));

        village.harvestCrop();
        village.printState();
    }
}
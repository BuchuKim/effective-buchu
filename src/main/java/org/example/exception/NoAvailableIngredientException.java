package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NoAvailableIngredientException extends RuntimeException {
    private String name;
    private int amount;
}

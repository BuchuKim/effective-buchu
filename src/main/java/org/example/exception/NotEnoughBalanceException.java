package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 작물을 심을 만큼의 잔고가 남아있지 않을 때 발생하는 예외
 */
@AllArgsConstructor
@Getter
public class NotEnoughBalanceException extends RuntimeException {
    private int required;
    private int current;
}

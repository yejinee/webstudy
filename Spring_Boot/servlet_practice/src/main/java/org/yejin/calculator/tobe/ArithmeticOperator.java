package org.yejin.calculator.tobe;

import org.yejin.calculator.domain.PositiveNumber;

public interface ArithmeticOperator {
    boolean supports(String operator);
    int calculate(final PositiveNumber operand1, final PositiveNumber operand2);
}

package com.handalas.calculator.services;

public interface CalculatorService {

    /**
     * Method to calculate result with params
     * @param first
     * @param second
     * @param operation
     * @return
     */
    public double calculate(double first, double second, String operation);
}

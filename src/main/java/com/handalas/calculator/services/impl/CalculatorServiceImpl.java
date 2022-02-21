package com.handalas.calculator.services.impl;

import com.handalas.calculator.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    /**
     * Method to calculate result with params
     * @param first
     * @param second
     * @param operation
     * @return
     */
    @Override
    public double calculate(double first, double second, String operation) {

        logger.info("init method calculate with params: {} {} {}", first, second, operation);

        switch (operation){
            case "sum":
                logger.info("result calculated:" +(first + second));
                return first + second;

            case "subtract":
                logger.info("result calculated:" +(first - second));
                return first - second;

            default:
                logger.error("This operation is not available: "+operation);
                throw new RuntimeException("Operation not available: "+operation);
        }
    }
}

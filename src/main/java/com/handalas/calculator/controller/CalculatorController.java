package com.handalas.calculator.controller;

import com.handalas.calculator.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class CalculatorController {

    static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public ResponseEntity<Double> calculator(@RequestParam(value = "first") double first, @RequestParam(value = "second") double second,
                                             @RequestParam(value = "operation") String operation){

        logger.info("init method calculator");
        double result = this.calculatorService.calculate(first, second, operation);

        logger.info("finish method calculator with result: "+result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

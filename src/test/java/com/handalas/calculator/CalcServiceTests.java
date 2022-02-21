package com.handalas.calculator;

import com.handalas.calculator.services.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = CalculatorApplication.class
    )
public class CalcServiceTests {
    @LocalServerPort
    int port;

    @Autowired
    CalculatorService calculatorService;

    /**
     * GET localhost:/restful/calculator with parameters
     * @param first
     * @param second
     * @param operation
     * @return
     * @throws URISyntaxException
     */
    private ResponseEntity<Double> calculate(double first, double second, String operation)
        throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + port +"/rest/calculator?first=" + first +"&second=" + second + "&operation=" + operation;
        URI uri = new URI(baseUrl);
        ResponseEntity<Double> result = restTemplate.getForEntity(uri, Double.class);
        return result;
    }

    @Test
    public void testSumOk() throws URISyntaxException {
        ResponseEntity<Double> result = calculate(4, 1, "sum");
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals(5.0d, result.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testSubtractOk_EN() throws URISyntaxException {

        ResponseEntity<Double> result = calculate(5, 6, "subtract");
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals(-1.0d, result.getBody().doubleValue(), 0.001d);
    }



    @Test
    public void testKO() throws URISyntaxException {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            this.calculate(1, 2, "mul");});
        
        String expectedMessage = "Bad Request";
        String actualMessage = exception.getMessage();

        assertFalse(actualMessage.contains(expectedMessage));
    }
}

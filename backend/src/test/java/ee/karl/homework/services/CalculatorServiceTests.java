package ee.karl.homework.services;

import ee.karl.homework.dto.CalculatorDto;
import ee.karl.homework.model.OperationModel;
import ee.karl.homework.types.CalculatorOperationEnumConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceTests {

    @Autowired
    private CalculatorService calculatorService;

    private CalculatorOperationEnumConverter calculatorOperationEnumConverter = new CalculatorOperationEnumConverter();

    @Test
    public void calculatorSumCorrectAnswerPositiveIntegers() {
        CalculatorDto dto = new CalculatorDto(10D, 1D, calculatorOperationEnumConverter.convert("sum"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(11), answer);
    }

    @Test
    public void calculatorSumCorrectAnswerNegativeIntegers() {
        CalculatorDto dto = new CalculatorDto(-10D, 1D, calculatorOperationEnumConverter.convert("sum"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(-9), answer);
    }

    @Test
    public void calculatorSumCorrectAnswerFloats() {
        CalculatorDto dto = new CalculatorDto(10.5D, 1D, calculatorOperationEnumConverter.convert("sum"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(11.5), answer);
    }

    @Test
    public void calculatorSubCorrectAnswerPositiveIntegers() {
        CalculatorDto dto = new CalculatorDto(10D, 1D, calculatorOperationEnumConverter.convert("sub"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(9), answer);
    }

    @Test
    public void calculatorSubCorrectAnswerFirstNegativeInteger() {
        CalculatorDto dto = new CalculatorDto(-10D, 1D, calculatorOperationEnumConverter.convert("sub"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(-11), answer);
    }

    @Test
    public void calculatorSubCorrectAnswerSecondNegativeInteger() {
        CalculatorDto dto = new CalculatorDto(10D, -1D, calculatorOperationEnumConverter.convert("sub"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(11), answer);
    }

    @Test
    public void calculatorSubCorrectAnswerFloats() {
        CalculatorDto dto = new CalculatorDto(10.5D, 1D, calculatorOperationEnumConverter.convert("sub"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(9.5), answer);
    }

    @Test
    public void calculatorProdCorrectAnswerPositiveIntegers() {
        CalculatorDto dto = new CalculatorDto(10D, 2D, calculatorOperationEnumConverter.convert("prod"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(20), answer);
    }

    @Test
    public void calculatorProdCorrectAnswerNegativeIntegers() {
        CalculatorDto dto = new CalculatorDto(-10D, 2D, calculatorOperationEnumConverter.convert("prod"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(-20), answer);
    }

    @Test
    public void calculatorProdCorrectAnswerFloats() {
        CalculatorDto dto = new CalculatorDto(10.5D, 2D, calculatorOperationEnumConverter.convert("prod"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(21), answer);
    }

    @Test
    public void calculatorDivCorrectAnswerPositiveIntegers() {
        CalculatorDto dto = new CalculatorDto(10D, 2D, calculatorOperationEnumConverter.convert("div"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(5), answer);
    }

    @Test
    public void calculatorDivCorrectAnswerNegativeIntegers() {
        CalculatorDto dto = new CalculatorDto(-10D, 2D, calculatorOperationEnumConverter.convert("div"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(-5), answer);
    }

    @Test
    public void calculatorDivCorrectAnswerFloats() {
        CalculatorDto dto = new CalculatorDto(10.5D, 2D, calculatorOperationEnumConverter.convert("div"));

        Double answer = calculatorService.calculate(dto);

        assertEquals(Double.valueOf(5.25), answer);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void calculatorRemembersPastCalculations() {
        CalculatorDto dto = new CalculatorDto(10.5D, 2D, calculatorOperationEnumConverter.convert("div"));
        calculatorService.calculate(dto);

        List<OperationModel> data = calculatorService.fetchPastCalculations();

        assertNotEquals(0, data.size());
    }
}

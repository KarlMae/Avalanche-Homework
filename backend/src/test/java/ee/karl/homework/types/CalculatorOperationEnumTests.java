package ee.karl.homework.types;

import ee.karl.homework.dto.CalculatorDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorOperationEnumTests {

    private CalculatorOperationEnumConverter calculatorOperationEnumConverter = new CalculatorOperationEnumConverter();

    @Test(expected = IllegalArgumentException.class)
    public void enumCreationWithIncorrectOperationThrows() {
        new CalculatorDto(10.5D, 2D, calculatorOperationEnumConverter.convert("wrong"));
    }

    @Test
    public void enumMappingWorks() {
        assertEquals(CalculatorOperationEnum.ADDITION,
                new CalculatorDto(10.5D, 2D,
                        calculatorOperationEnumConverter.convert("sum")).getOperation()
        );

        assertEquals(CalculatorOperationEnum.SUBTRACTION,
                new CalculatorDto(10.5D, 2D,
                        calculatorOperationEnumConverter.convert("sub")).getOperation()
        );

        assertEquals(CalculatorOperationEnum.MULTIPLICATION,
                new CalculatorDto(10.5D, 2D,
                        calculatorOperationEnumConverter.convert("prod")).getOperation()
        );

        assertEquals(CalculatorOperationEnum.DIVISION,
                new CalculatorDto(10.5D, 2D,
                        calculatorOperationEnumConverter.convert("div")).getOperation()
        );
    }
}

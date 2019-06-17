package ee.karl.homework.dtos;

import ee.karl.homework.types.CalculatorOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorDto {

    private Double number1;
    private Double number2;
    private CalculatorOperation op;

}

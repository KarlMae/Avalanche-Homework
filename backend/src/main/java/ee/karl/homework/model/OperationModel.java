package ee.karl.homework.model;

import ee.karl.homework.dto.CalculatorDto;
import ee.karl.homework.types.CalculatorOperationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationModel {

    public OperationModel(CalculatorDto calculatorDto) {
        this.number1 = calculatorDto.getNumber1();
        this.number2 = calculatorDto.getNumber2();
        this.operation = CalculatorOperationEnum.getStringForm(calculatorDto.getOperation());
    }

    private Long id;
    private Double number1;
    private Double number2;
    private Double result;
    private String operation;
}

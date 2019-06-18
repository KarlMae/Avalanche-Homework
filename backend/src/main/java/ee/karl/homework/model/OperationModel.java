package ee.karl.homework.model;

import ee.karl.homework.dto.CalculatorDto;
import ee.karl.homework.types.CalculatorOperation;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OperationModel {

    public OperationModel(CalculatorDto calculatorDto) {
        this.number1 = calculatorDto.getNumber1();
        this.number2 = calculatorDto.getNumber2();
        this.operation = calculatorDto.getOperation();
    }

    @NotNull
    private Long id;

    @NotNull
    private Double number1;

    @NotNull
    private Double number2;

    @NotNull
    private Double result;

    @NotNull
    private CalculatorOperation operation;
}

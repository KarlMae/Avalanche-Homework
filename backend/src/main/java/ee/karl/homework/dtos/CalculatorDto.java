package ee.karl.homework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ee.karl.homework.types.CalculatorOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorDto {

    @JsonProperty("num1")
    private Double number1;

    @JsonProperty("num2")
    private Double number2;

    @JsonProperty("op")
    private CalculatorOperation operation;

}
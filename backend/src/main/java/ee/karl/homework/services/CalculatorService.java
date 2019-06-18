package ee.karl.homework.services;

import ee.karl.homework.dtos.CalculatorDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Double calculate(CalculatorDto dto) {
        switch(dto.getOperation()) {
            case sum:
                return addition(dto.getNumber1(), dto.getNumber2());
            case sub:
                return subtraction(dto.getNumber1(), dto.getNumber2());
            case prod:
                return multiplication(dto.getNumber1(), dto.getNumber2());
            case div:
                return division(dto.getNumber1(), dto.getNumber2());
            default:
                throw new IllegalArgumentException("Calculator op does not exist");
        }
    }

    private Double addition(Double number1, Double number2) {
        return number1 + number2;
    }

    private Double subtraction(Double number1, Double number2) {
        return number1 - number2;
    }

    private Double multiplication(Double number1, Double number2) {
        return number1 * number2;
    }

    private Double division(Double number1, Double number2) {
        return number1 / number2;
    }
}

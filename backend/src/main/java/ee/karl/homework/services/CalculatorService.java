package ee.karl.homework.services;

import ee.karl.homework.dao.CalculatorDao;
import ee.karl.homework.dto.CalculatorDto;
import ee.karl.homework.model.OperationModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalculatorService {

    private final CalculatorDao dao;

    public List<OperationModel> fetchPastCalculations() {
        return dao.fetchPastCalculations();
    }

    public Double calculate(CalculatorDto dto) {
        OperationModel operation = new OperationModel(dto);

        switch (dto.getOperation()) {
            case ADDITION:
                operation.setResult(addition(dto.getNumber1(), dto.getNumber2()));
                break;
            case SUBTRACTION:
                operation.setResult(subtraction(dto.getNumber1(), dto.getNumber2()));
                break;
            case MULTIPLICATION:
                operation.setResult(multiplication(dto.getNumber1(), dto.getNumber2()));
                break;
            case DIVISION:
                operation.setResult(division(dto.getNumber1(), dto.getNumber2()));
                break;
            default:
                throw new IllegalArgumentException("Calculator op does not exist");
        }

        dao.insertOperation(operation);

        return operation.getResult();
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

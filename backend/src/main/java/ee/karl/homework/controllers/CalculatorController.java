package ee.karl.homework.controllers;

import ee.karl.homework.dto.CalculatorDto;
import ee.karl.homework.model.OperationModel;
import ee.karl.homework.services.CalculatorService;
import ee.karl.homework.types.CalculatorOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("calculate") protected OperationModel calculatorPost(
            @RequestParam("num1") Double number1,
            @RequestParam("num2") Double number2,
            @RequestParam("op") CalculatorOperation operation
    ) {
        return calculatorService.calculate(new CalculatorDto(number1, number2, operation));
    }

    @PostMapping("calculate")
    protected OperationModel calculatorGet(@RequestBody @Valid CalculatorDto dto) {
        return calculatorService.calculate(dto);
    }

    @GetMapping("fetchPastCalculations")
    protected List<OperationModel> fetchPastCalculations() {
        return calculatorService.fetchPastCalculations();
    }
}

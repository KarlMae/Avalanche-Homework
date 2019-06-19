package ee.karl.homework.controllers;

import ee.karl.homework.dto.CalculatorDto;
import ee.karl.homework.model.OperationModel;
import ee.karl.homework.services.CalculatorService;
import ee.karl.homework.types.CalculatorOperationEnum;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("calculate")
    public Double calculatorGet(
            @RequestParam("num1") Double number1,
            @RequestParam("num2") Double number2,
            @RequestParam("op") CalculatorOperationEnum operation
    ) {
        return calculatorService.calculate(new CalculatorDto(number1, number2, operation));
    }

    @PostMapping("calculate")
    public Double calculatorPost(@RequestBody @Valid CalculatorDto dto) {
        return calculatorService.calculate(dto);
    }

    @GetMapping("fetchPastCalculations")
    @ResponseBody
    public List<OperationModel> fetchPastCalculations() {
        return calculatorService.fetchPastCalculations();
    }
}

package ee.karl.homework.types;

import org.springframework.core.convert.converter.Converter;

public class CalculatorOperationEnumConverter implements Converter<String, CalculatorOperationEnum> {

    @Override
    public CalculatorOperationEnum convert(String source) {
        return CalculatorOperationEnum.valueOfCode(source);
    }
}
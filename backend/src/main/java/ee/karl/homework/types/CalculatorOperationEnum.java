package ee.karl.homework.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CalculatorOperationEnum {

    ADDITION("sum"),
    SUBTRACTION("sub"),
    MULTIPLICATION("prod"),
    DIVISION("div");

    private final String code;

    CalculatorOperationEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static String getStringForm(CalculatorOperationEnum operaion) { return operaion.name(); }

    public static CalculatorOperationEnum valueOfCode(String code) {
        for (CalculatorOperationEnum e : values()) {
            if (e.getCode().equals(code)) return e;
        }
        throw new IllegalArgumentException(String.format("Operation with code %s does not exist", code));
    }

    @Override
    @JsonValue
    public String toString() {
        return code;
    }
}

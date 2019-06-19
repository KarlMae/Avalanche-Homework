package ee.karl.homework;

import ee.karl.homework.services.CalculatorServiceTests;
import ee.karl.homework.types.CalculatorOperationEnumTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorServiceTests.class,
        CalculatorOperationEnumTests.class
})
public class TestSuite { }

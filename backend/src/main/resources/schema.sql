CREATE SCHEMA IF NOT EXISTS calculator;

CREATE TABLE IF NOT EXISTS calculator.operations
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    number1   DOUBLE NOT NULL,
    number2   DOUBLE NOT NULL,
    operation VARCHAR(14) DEFAULT NULL,
    result    DOUBLE NOT NULL
);
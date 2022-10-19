package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(1, 2);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, fraction.decimal());
    }

    @Test
    void testIsPropper() {
        assertEquals(true, fraction.isPropper());
    }

    @Test
    void testIsImpropper() {
        assertEquals(false, fraction.isImpropper());
    }

    @Test
    void testIsEquivalent() {
        assertEquals(true, fraction.isEquivalent(new Fraction(2,4)));
    }

    @Test
    void testMultiply() {
        Fraction fractionToMultiply = fraction.multiply(new Fraction(1, 2));
        assertEquals(1, fractionToMultiply.getNumerator());
        assertEquals(4, fractionToMultiply.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction fractionToDivide = fraction.divide(new Fraction(1, 2));
        assertEquals(2, fractionToDivide.getNumerator());
        assertEquals(2, fractionToDivide.getDenominator());
    }

    @Test
    void testAdd() {
        Fraction fractionAdd = fraction.add(new Fraction(3,4));
        assertEquals(4, fractionAdd.getNumerator());
        assertEquals(2, fractionAdd.getDenominator());
    }
}
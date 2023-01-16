package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(fraction.isPropper());
    }

    @Test
    void testIsImpropper() {
        assertFalse(fraction.isImpropper());
    }

    @Test
    void testIsEquivalent() {
        assertTrue(fraction.isEquivalent(new Fraction(2,4)));
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
    void testAddition() {
        Fraction fractionAddition = fraction.addition(new Fraction(3,4));
        assertEquals(5, fractionAddition.getNumerator());
        assertEquals(4, fractionAddition.getDenominator());
    }
}
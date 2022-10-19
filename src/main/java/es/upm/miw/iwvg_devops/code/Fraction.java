package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isPropper() {
        return this.numerator < this.denominator;
    }

    public boolean isImpropper() {
        return this.numerator > this.denominator;
    }

    public boolean isEquivalent(Fraction otherFraction) {
        return (this.numerator * otherFraction.denominator) == (otherFraction.numerator * this.denominator);
    }
    public Fraction add(Fraction fraction) {
        return new Fraction(this.numerator + fraction.numerator, commonDenominator(fraction));
    }

    public Fraction multiply(Fraction otherFraction) {
        return new Fraction(this.numerator * otherFraction.numerator, this.denominator * otherFraction.denominator);
    }

    public Fraction divide(Fraction otherFraction) {
        return new Fraction(this.numerator * otherFraction.denominator, this.denominator * otherFraction.numerator);
    }

    private Integer commonDenominator(Fraction otherFraction) {
        int minDenominator = Stream.of(this.denominator, otherFraction.denominator)
                .min(Integer::compare)
                .orElseThrow();

        LogManager.getLogger(this.getClass()).info("minDenominator: " + String.valueOf(minDenominator));

        return IntStream.range(2, minDenominator+1)
                .peek(denominator -> LogManager.getLogger(this.getClass()).info("denominator: " + String.valueOf(denominator)))
                .filter(i -> (this.denominator % i == 0 && otherFraction.denominator % i == 0))
                .peek(denominator -> LogManager.getLogger(this.getClass()).info("denominator: " + String.valueOf(denominator)))
                .max().orElse(1);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
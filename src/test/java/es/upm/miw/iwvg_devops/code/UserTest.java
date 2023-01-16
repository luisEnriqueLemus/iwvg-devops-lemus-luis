package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1,2));
        fractions.add(new Fraction(1,3));
        user = new User("1804198104433", "Luis Enrique", "Lemus Hernandez", fractions);
    }

    @Test
    void testUser() {
        user = new User();
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testUserParams() {
        assertEquals("1804198104433", user.getId());
        assertEquals("Luis Enrique", user.getName());
        assertEquals("Lemus Hernandez", user.getFamilyName());
        assertEquals(2, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("Luis Enrique Lemus Hernandez", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("L.", user.initials());
    }

    @Test
    void testGetId() {
        assertEquals("1804198104433", user.getId());
    }

    @Test
    void testGetName() {
        user.setName("Luis Enrique");
        assertEquals("Luis Enrique", user.getName());
    }

    @Test
    void testGetFamilyName() {
        user.setFamilyName("Lemus Hernandez");
        assertEquals("Lemus Hernandez", user.getFamilyName());
    }

    @Test
    void testAddFraction() {
        this.user.addFraction(new Fraction(1,4));
        assertEquals(0.25, user.getFractions().get(2).decimal(), 10e-5);
    }
}
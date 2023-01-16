package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {
    @Test
    void testFindDecimalFractionByUserName() {
        assertEquals(List.of(2.0, -0.2, 0.5, 1.3333333333333333), new Searches().findDecimalFractionByUserName("Ana").collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertEquals(List.of("1", "2", "3", "5"), new Searches().findUserIdBySomeProperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindFractionAdditionByUserId(){
        assertEquals(2, new Searches().findFractionAdditionByUserId("4").decimal());
    }

    @Test
    void testFindFractionSubtractionByUserName(){
        assertEquals(-1, new Searches().findFractionSubtractionByUserName("Paula").decimal());
    }
}
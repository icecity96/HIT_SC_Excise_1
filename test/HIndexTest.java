import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HIndexTest {

    @Test
    void testValidInput() {
        assertEquals(1, HIndex.calcHIndex("0,0,1"));
        assertEquals(4, HIndex.calcHIndex("1,4,8,10,20"));
    }

    @Test
    void testEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            HIndex.calcHIndex("");
        });
    }

    @Test
    void testEmptyInput2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            HIndex.calcHIndex("");
        });

        // Check the exception message
        assertEquals("Empty input", exception.getMessage());
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            HIndex.calcHIndex("0,-2,0");
        });
    }

    @Test
    void testIllegalCharacterInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            HIndex.calcHIndex("1,6e8,3#*");
        });

        // Check the exception message
        assertEquals("6e8 is illegal", exception.getMessage());
    }
}
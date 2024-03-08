import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HIndexTest {
    /**
     * Testing Strategy:
     * 按输入的长度进行划分：0,1,2,n(>2)
     * 按值划分：正整数或0、负值、小数、包含其他字符
     * 按排序后数值大小：第1个<1，第2个<2，第n个<n
     * 按相对值大小：数字都一样、一个大其他都小、一个小其他都大
     *
     * 按“笛卡尔积全覆盖”策略设计测试用例
     * 或按“每个取值至少覆盖一次”策略
     */
    @Test
    public void testSameCitationNumbers() {
        assertEquals(0, HIndex.calcHIndex("0,0,0,0,0,0,0"));
        assertEquals(4, HIndex.calcHIndex("5,5,5,5"));
        assertEquals(5, HIndex.calcHIndex("5,5,5,5,5"));
        assertEquals(5, HIndex.calcHIndex("5,5,5,5,5,5"));
    }

    @Test
    public void testOneBigCitationNumbers() {
        assertEquals(5, HIndex.calcHIndex("5,5,5,5,5,500"));
    }

    @Test
    public void testOneSmallCitationNumbers() {
        assertEquals(5, HIndex.calcHIndex("5,500,500,500,500,500"));
    }

    // covers 输入长度=1，正整数/0
    public void testOneInput() {
        assertEquals(0, HIndex.calcHIndex("0"));
        assertEquals(1, HIndex.calcHIndex("10"));
    }

    // covers 输入长度=2，正整数/0
    @Test
    public void testTwoInput() {
        assertEquals(0, HIndex.calcHIndex("0,0"));
        assertEquals(1, HIndex.calcHIndex("1,4"));
        assertEquals(2, HIndex.calcHIndex("2,4"));
    }

    // covers 输入长度>2，正整数/0
    @Test
    public void testMultipleInput() {
        assertEquals(0, HIndex.calcHIndex("0,0,0"));
        assertEquals(1, HIndex.calcHIndex("1,4,1,1"));
        assertEquals(2, HIndex.calcHIndex("2,4,4,2,0,0,0,0"));
        assertEquals(3, HIndex.calcHIndex("3,4,4"));
    }

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
    void testtestNumberWithDigitalInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            HIndex.calcHIndex("1,2.3,0");
        });

        // Check the exception message
        assertEquals("2.3 is illegal", exception.getMessage());
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
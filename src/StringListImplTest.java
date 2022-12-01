import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private final StringListImpl arrayToTest = new StringListImpl(5);
    static final String ONE = "First";
    static final String TWO = "Second";
    static final String THREE = "Third";

    private String[] actualString;

    @BeforeEach
    public void setUp() {
        actualString = new String[]{ONE, TWO, THREE, "Fourth", "Fifth"};
    }

    @Test
    public void shouldReturnAddStringToArray() {
        String result = arrayToTest.add(ONE);
        assertEquals(ONE, result);
    }

    @Test
    public void shouldThrowAddNullStringExceptionWhenParameterIsNull() {
        assertThrows(WorkingArrayStringListException.class, () -> arrayToTest.add(null));
    }

    @Test
    public void shouldReturnSetStringToArray() {
        String result = arrayToTest.set(2, TWO);
        assertEquals(TWO, result);
    }

    @Test
    public void shouldThrowSetNullStringExceptionWhenParameterIsNull() {
        assertThrows(WorkingArrayStringListException.class, () -> arrayToTest.set(2, null));
    }

    @Test
    public void shouldReturnRemoveStringToArray() {
        arrayToTest.add(THREE);
        String result = arrayToTest.remove(THREE);
        assertEquals(THREE, result);
    }

    @Test
    public void shouldThrowRemoveNullStringExceptionWhenParameterIsNull() {
        assertThrows(WorkingArrayStringListException.class, () -> arrayToTest.remove(null));
    }

    @Test
    public void shouldReturnContainsStringToArray() {
        arrayToTest.add(THREE);
        boolean result = arrayToTest.contains(THREE);
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnIndexStringToArray() {
        arrayToTest.add(THREE);
        int result = arrayToTest.indexOf(THREE);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnLastIndexStringToArray() {
        int result = arrayToTest.lastIndexOf(THREE);
        assertEquals(-1, result);
    }

    @Test
    public void shouldReturnGetStringToArray() {
        arrayToTest.add(ONE);
        String result = arrayToTest.get(0);
        assertEquals(ONE, result);
    }

    @Test
    public void shouldReturnSizeArray() {
        arrayToTest.add(0, ONE);
        int result = arrayToTest.size();
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnIsEmptyArray() {
        boolean result = arrayToTest.isEmpty();
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnIsNotEmptyArray() {
        arrayToTest.add(ONE);
        boolean result = arrayToTest.isEmpty();
        assertEquals(false, result);
    }

    @Test
    public void shouldReturnEqualsStringToArray() {
        arrayToTest.add(ONE);
        arrayToTest.add(TWO);
        arrayToTest.add(THREE);
        arrayToTest.add("Fourth");
        arrayToTest.add("Fifth");
        String[] result = arrayToTest.toArray();
        assertEquals(arrayToTest.toArray(), result);
    }


}
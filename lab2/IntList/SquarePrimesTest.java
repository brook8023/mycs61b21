package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple2() {
        IntList lst = IntList.of(14);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrimesSimple3() {
        IntList lst = IntList.of(3);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple4() {
        IntList lst = IntList.of(14, 3);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple5() {
        IntList lst = IntList.of(14, 15);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrimesSimple6() {
        IntList lst = IntList.of(3, 15);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9 -> 15", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple7() {
        IntList lst = IntList.of(3, 5);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9 -> 25", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple8() {
        IntList lst = IntList.of(14, 15, 16);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrimesSimple9() {
        IntList lst = IntList.of(14, 15, 17);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 289", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple10() {
        IntList lst = IntList.of(14, 17, 15);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 289 -> 15", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSimple11() {
        IntList lst = IntList.of(14, 3, 17);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 9 -> 289", lst.toString());
        assertTrue(changed);
    }

}

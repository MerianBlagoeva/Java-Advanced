package p03_IteratorTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private ListIterator iterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        iterator = new ListIterator("0", "1", "2");
    }

    @Test
    public void testCtorAndIteration() {
        assertEquals("0", iterator.print());
        iterator.move();
        assertEquals("1", iterator.print());
        iterator.move();
        assertEquals("2", iterator.print());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtorWhenNullArgumentThrows() throws OperationNotSupportedException {
        new ListIterator(null);

    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testHasNextWhenEmpty() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNextWhenReachedEnd() {
        iterator.move();
        iterator.move();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNextWhenReachedMiddle() {
        iterator.move();

        assertTrue(iterator.hasNext());
    }


    @Test
    public void testMove() {
        assertTrue(iterator.move());

        assertEquals("1", iterator.print());
    }

    @Test
    public void testMoveWhenSingleElement() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator("0");

        assertFalse(iterator.move());

        assertEquals("0", iterator.print());
    }

    @Test
    public void testMultipleMoveReachesEnd() {
        assertTrue(iterator.move());
        assertTrue(iterator.move());
        assertFalse(iterator.move());

        assertEquals("2", iterator.print());
    }

    @Test
    public void testMoveWhenNoElements() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

        assertFalse(iterator.move());
    }

    @Test
    public void testPrint() {
        assertEquals("0", iterator.print());
    }

    @Test
    public void testPrintTwice() {
        assertEquals("0", iterator.print());
        assertEquals("0", iterator.print());
    }

    @Test
    public void testPrintNoElements() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

//        expectedException.expect(IllegalStateException.class);
//        expectedException.expectMessage("Invalid Operation!");

        expectException(() -> iterator.print(), IllegalStateException.class, "Invalid Operation!");
    }

    private static <T extends Throwable> void expectException(Runnable r, Class<T> clazz, String message) {
        T actualException = null;

        try {
            r.run();
        } catch (Throwable e) {
            actualException = (T) e;
        }

        assertNotNull(actualException);
        assertEquals(clazz, actualException.getClass());
        assertEquals(message, actualException.getMessage());
    }
}

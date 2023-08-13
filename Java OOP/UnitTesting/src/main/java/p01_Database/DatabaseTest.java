package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.*;


public class DatabaseTest {
    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorMoreThanElementsThrows() throws OperationNotSupportedException {
        Integer[] largerArray = new Integer[16 + 1];
        new Database(largerArray);

    }

//    @Test(expected = OperationNotSupportedException.class)
//    public void testDatabaseCtorLessThanElementsThrows() throws OperationNotSupportedException {
//        Integer[] smallerArray = new Integer[0];
//        new Database(smallerArray);
//
//    }

    @Test
    public void testDatabaseCtorLessThanElementsThrows() throws OperationNotSupportedException {
        Integer[] smallerArray = new Integer[0];
        boolean threwException = false;

        try {
            new Database(smallerArray);
        } catch (Throwable e) {
            assertEquals(OperationNotSupportedException.class, e.getClass());
            threwException = true;
        }

        assertTrue(threwException);

    }


    @Test
    public void testDatabaseCtorInitializes16Capacity() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database database = new Database(0, 1, 2, 3, 4);

        Field elementsField = Database.class.getDeclaredField("elements");
        elementsField.setAccessible(true);
        Integer[] databaseElements  = (Integer[]) elementsField.get(database);

        assertEquals(16, databaseElements.length);

    }

    @Test
    public void testDatabaseCtor() throws OperationNotSupportedException {
        Integer[] expectedElements = {0, 1, 2, 3, 4};
        Database database = new Database(expectedElements);
        Integer[] actualElements = database.getElements();
        assertEquals(expectedElements.length, actualElements.length);

        boolean equals = Arrays.equals(expectedElements, actualElements);

        assertTrue(equals);
    }

//    @Test
//    public void testAdd() throws OperationNotSupportedException {
//        Integer[] initialElements = {0, 1, 2, 3, 4};
//        Database database = new Database(initialElements);
//
//        database.add(5);
//
//        Integer[] actualElements = database.getElements();
//        assertEquals(initialElements.length + 1, actualElements.length);
//
//        boolean equals = Arrays.equals(initialElements, actualElements);
//        assertTrue(equals);
//    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        Integer[] initialElements = {0, 1, 2, 3, 4};
        Database database = new Database(initialElements);

        database.remove();

        Integer[] elements = database.getElements();
        assertEquals(initialElements.length - 1, elements.length);
    }

    @Test
    public void testRemoveTwice() throws OperationNotSupportedException {
        Integer[] initialElements = {0, 1, 2, 3, 4};
        Database database = new Database(initialElements);

        database.remove();
        database.remove();

        Integer[] elements = database.getElements();
        assertEquals(initialElements.length - 2, elements.length);
    }

    @Test
    public void testRemoveFromSingleElementDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10};
        Database database = new Database(initialElements);

        database.remove();

        Integer[] elements = database.getElements();
        assertEquals(0, elements.length);
    }

    @Test
    public void testGetElements() {
        //TODO:
    }

}

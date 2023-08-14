import Exercises.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ChainblockImplTest {

    private Chainblock database;

    @Before
    public void setUp() {
        this.database = new ChainblockImpl();
    }

    @Test
    public void testAddCorrectTransaction() {
        assertEquals(0, this.database.getCount());

        Transaction transaction1 = new TransactionImpl(
                1, TransactionStatus.SUCCESSFUL, "Meri", "Stoyan", 150.90
        );

        this.database.add(transaction1);
        assertEquals(1, this.database.getCount());

        assertTrue(this.database.contains(transaction1));
    }

    @Test
    public void testAddExistingTransaction() {
        assertEquals(0, this.database.getCount());

        Transaction transaction1 = new TransactionImpl(1,TransactionStatus.SUCCESSFUL, "Meri", "Stoyan", 150.90);

        this.database.add(transaction1);
        assertEquals(1, this.database.getCount());
        this.database.add(transaction1);

        assertEquals(1, this.database.getCount());
    }
}

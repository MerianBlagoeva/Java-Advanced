package bank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BankTests {
    private Bank bank;
    private Client client;

    @Before
    public void setUp() {
        this.bank = new Bank("DSK", 1);
        this.client = new Client("Meri");
    }

    @Test(expected = NullPointerException.class)
    public void testCtorThrowsWhenBankNameIsNull() {
        new Bank(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testCtorThrowsWhenBankNameIsEmpty() {
        new Bank("    ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorThrowsWhenCapacityIsNegative() {
        new Bank("CentralBank", -1);
    }

    @Test
    public void testCtorCreatesBank() {
        Bank centralBank = new Bank("CentralBank", 3);

        assertEquals(3, centralBank.getCapacity());
        assertEquals(0, centralBank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClientThrowsWhenNoCapacity() {
        bank.addClient(client);
        bank.addClient(new Client("Gosho"));
    }

    @Test
    public void testAddClientUpdatesBankClients() {
        bank.addClient(client);
        assertEquals(1, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientThrowsWhenNoClientWithSuchNameExists() {
        bank.addClient(client);

        bank.removeClient("not_existing");
    }

    @Test
    public void testRemoveClientUpdatesBankClients() {
        bank.addClient(client);
        assertEquals(1, bank.getCount());
        bank.removeClient("Meri");
        assertEquals(0, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalThrowsWhenClientNameDoesNotExist() {
        bank.addClient(client);

        bank.loanWithdrawal("not_existing");
    }

    @Test
    public void testLoanWithdrawalUpdatesApprovedForLoan() {
        bank.addClient(client);
        Client meri = bank.loanWithdrawal("Meri");
        assertFalse(meri.isApprovedForLoan());
    }

    @Test
    public void testStatisticsReturnsTheCorrectMessage() {
        bank.addClient(client);

        assertEquals("The client Meri is at the DSK bank!",
                bank.statistics());
    }
}

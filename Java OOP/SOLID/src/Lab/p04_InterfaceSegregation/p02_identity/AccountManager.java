package Lab.p04_InterfaceSegregation.p02_identity;

import Lab.p04_InterfaceSegregation.p02_identity.interfaces.Account;
import Lab.p04_InterfaceSegregation.p02_identity.interfaces.User;

public class AccountManager implements Account {


    @Override
    public void register(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void login(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //change password
    }

    @Override
    public Iterable<User> getAllUsersOnline() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }
}

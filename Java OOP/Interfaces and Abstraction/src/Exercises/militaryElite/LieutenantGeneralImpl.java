package Exercises.militaryElite;

import java.util.Set;

public class LieutenantGeneralImpl {
    private Set<PrivateImpl> set;

    public void addPrivate(PrivateImpl priv) {
        set.add(priv);
    }
}

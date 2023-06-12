package Lab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        String address = "resources\\Files-and-Streams";

        File file = new File(address);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}

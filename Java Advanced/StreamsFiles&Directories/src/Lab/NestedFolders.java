package Lab;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {

        String address = "resources\\Files-and-Streams";

        File root = new File(address);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        int count = 0;

        while (!queue.isEmpty()) {

            File currentFile = queue.poll();

            File[] nestedFiles = currentFile.listFiles();

            if (nestedFiles != null) {
                for (File f : nestedFiles) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }
                count++;
                System.out.println(currentFile.getName());
            }
        }
        System.out.println(count + " folders");
    }
}

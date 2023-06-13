package Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("resources/Celica.jpg");
        FileOutputStream fos = new FileOutputStream("resources/CelicaCopy.jpg");

        byte[] buffer = new byte[1024];
        while (fis.read(buffer) >= 0) {
            fos.write(buffer);
        }
        fis.close();
        fos.close();

    }
}

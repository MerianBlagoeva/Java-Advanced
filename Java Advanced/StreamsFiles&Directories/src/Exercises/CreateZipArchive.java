package Exercises;

import java.io.*;
import java.util.zip.*;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {

        /*
        Write a program in Java that reads three .txt files and creates a zip archive named "files.zip".
        Use FileOutputStream, ZipOutputStream and FileInputStream.\
         */

        String[] filenames = {"resources\\first.txt", "resources\\second.txt", "resources\\third.txt"};
        String zipFileName = "resources\\files.zip";


        // Create a buffer for reading the files
        byte[] buffer = new byte[1024];

        // Create the ZIP file
        FileOutputStream fos = new FileOutputStream(zipFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);

        // Compress the files
        for (String filename : filenames) {
            FileInputStream fis = new FileInputStream(filename);
            zos.putNextEntry(new ZipEntry(filename));

            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
            fis.close();
        }

        // Complete the ZIP file
        zos.close();
        fos.close();

        System.out.println("Zip file created!");
    }
}

package Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/list.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/list.ser"));

        output.writeObject(list); //serialize -> write to file


        List<Integer> listFromFile = (List<Integer>) input.readObject();


        for (Integer integer : listFromFile) {
            System.out.println(integer);
        }
    }
}

package ru.vsu.cs.cg.objectReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ObjReader {

    public static void read(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
            }
        }
    }

}

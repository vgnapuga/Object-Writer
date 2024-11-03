package ru.vsu.cs.cg.objectReader;

import ru.vsu.cs.cg.ObjData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjReader {

    public static ObjData read(String filePath) throws IOException {
        ObjData objData = new ObjData();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("v "))
                    objData.vertices.add(parseVertex(line));
                else if (line.startsWith("vt "))
                    objData.vertices.add(parseTexture(line));
                else if (line.startsWith("vn "))
                    objData.normals.add(parseNormal(line));
                else if (line.startsWith("f "))
                    objData.faces.add(parseFace(line));
            }
        }

        return objData;
    }

    private static float[] parseVertex(String line) {
        String[] parts = line.split("\\s+");
        return new float[]{
                Float.parseFloat(parts[1]),
                Float.parseFloat(parts[2]),
                Float.parseFloat(parts[3])
        };
    }

    private static float[] parseTexture(String line) {
        String[] parts = line.split("\\s+");
        return new float[]{
                Float.parseFloat(parts[1]),
                Float.parseFloat(parts[2]),
        };
    }

    private static float[] parseNormal(String line) {
        String[] parts = line.split("\\s+");
        return new float[]{
                Float.parseFloat(parts[1]),
                Float.parseFloat(parts[2]),
                Float.parseFloat(parts[3])
        };
    }

    private static int[] parseFace(String line) {
        String[] parts = line.split("\\s+");
        int[] face = new int[parts.length - 1];
        for (int i = 1; i < parts.length; i++) {
            String[] indices = parts[i].split("//");
            face[i - 1] = Integer.parseInt(indices[0]) - 1;
        }

        return face;
    }

    public static void main(String[] args) throws IOException {
        String path = "/home/onenull/.local/projects/IDEAProjects/CG/CG-task03/test.obj";
        ObjData objData = read(path);

        System.out.println("Vertices:");
        for (float[] vertex : objData.vertices) {
            System.out.println(String.format("v %f %f %f", vertex[0], vertex[1], vertex[2]));
        }

        System.out.println("Normals:");
        for (float[] normal : objData.normals) {
            System.out.println(String.format("vn %f %f %f", normal[0], normal[1], normal[2]));
        }

        System.out.println("Faces:");
        for (int[] face : objData.faces) {
            System.out.print("f");
            for (int index : face) {
                System.out.print(" " + (index + 1));
            }
            System.out.println();
        }
    }
}
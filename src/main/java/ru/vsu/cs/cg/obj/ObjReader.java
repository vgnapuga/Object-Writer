package ru.vsu.cs.cg.obj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjReader {

    private static List<float[]> vertices;
    private static List<float[]> textures;
    private static List<float[]> normals;
    private static List<int[]> faces;

    public static ObjData read(String filePath) throws IOException {
        if (!isObj(filePath) || !isFileExists(filePath))
            throw new FileNotFoundException(filePath);

        vertices = new ArrayList<>();
        textures = new ArrayList<>();
        normals = new ArrayList<>();
        faces = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                readVertices(line);
                readTextures(line);
                readNormals(line);
                readFaces(line);
            }
        }

        ObjData object = new ObjData(vertices, textures, normals, faces);

        return object;
    }

    private static final boolean isObj(String filePath) {
        return filePath.endsWith(".obj");
    }

    private static final boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    private static void readVertices(String line) throws IOException {
        if (line.startsWith("v ")) {
            String[] parts = line.split("\\s+");
            if (parts.length == 4) {
                float x = Float.parseFloat(parts[1].replace(",", "."));
                float y = Float.parseFloat(parts[2].replace(",", "."));
                float z = Float.parseFloat(parts[3].replace(",", "."));

                vertices.add(new float[]{x, y, z});
            } else {
                throw new NumberFormatException();
            }
        } else {
            return;
        }
    }

    private static void readTextures(String line) throws IOException {
        if (line.startsWith("vt ")) {
            String[] parts = line.split("\\s+");
            if (parts.length == 3) {
                float x = Float.parseFloat(parts[1].replace(",", "."));
                float y = Float.parseFloat(parts[2].replace(",", "."));

                textures.add(new float[]{x, y});
            } else {
                throw new NumberFormatException();
            }
        } else {
            return;
        }
    }

    private static void readNormals(String line) throws IOException {
        if (line.startsWith("vn ")) {
            String[] parts = line.split("\\s+");
            if (parts.length == 4) {
                float x = Float.parseFloat(parts[1].replace(",", "."));
                float y = Float.parseFloat(parts[2].replace(",", "."));
                float z = Float.parseFloat(parts[3].replace(",", "."));

                normals.add(new float[]{x, y, z});
            } else {
                throw new NumberFormatException();
            }
        } else {
            return;
        }
    }

    private static void readFaces(String line) throws IOException {
        if (line.startsWith("f ")) {
            String[] parts = line.split("\\s+");
            if (parts.length >= 4) {
                int[] result = new int[parts.length - 1];
                for (int i = 1; i < parts.length; i++) {
                    String[] indices = parts[i].split("/");
                    result[i - 1] = Integer.parseInt(indices[0]);
                }


                faces.add(result);
            } else {
                throw new NumberFormatException();
            }
        } else {
            return;
        }
    }

}
package ru.vsu.cs.cg.obj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjReader {

    private static List<float[]> vertices;
    private static List<float[]> textures;
    private static List<float[]> normals;
    private static List<int[]> faceVertices;
    private static List<int[]> faceTextures;
    private static List<int[]> faceNormals;

    public static ObjData readFromFile(String filePath) throws IOException {
        if (!isObj(filePath) || !isFileExists(filePath))
            throw new FileNotFoundException(filePath);

        vertices = new ArrayList<>();
        textures = new ArrayList<>();
        normals = new ArrayList<>();
        faceVertices = new ArrayList<>();
        faceTextures = new ArrayList<>();
        faceNormals = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                readVertices(line);
                readTextures(line);
                readNormals(line);
                readFaces(line);
            }
        }

        return new ObjData(vertices, textures, normals,
                faceVertices, faceTextures, faceNormals);
    }

    private static boolean isObj(String filePath) {
        return filePath.endsWith(".obj");
    }

    private static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    private static void readVertices(String line) {
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
        }
    }

    private static void readTextures(String line) {
        if (line.startsWith("vt ")) {
            String[] parts = line.split("\\s+");
            if (parts.length == 3) {
                float x = Float.parseFloat(parts[1].replace(",", "."));
                float y = Float.parseFloat(parts[2].replace(",", "."));

                textures.add(new float[]{x, y});
            } else {
                throw new NumberFormatException();
            }
        }
    }

    private static void readNormals(String line) {
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
        }
    }


    private static void readFaces(String line) {
        if (line.startsWith("f ")) {
            String[] parts = line.split("\\s+");
            if (parts.length >= 4) {
                int[] vertexIndices = new int[parts.length - 1];
                int[] textureIndices = new int[parts.length - 1];
                int[] normalIndices = new int[parts.length - 1];

                for (int i = 1; i < parts.length; i++) {
                    String[] indices = parts[i].split("/");
                    vertexIndices[i - 1] = Integer.parseInt(indices[0]) - 1;
                    textureIndices[i - 1] = indices.length > 1 && !indices[1].isEmpty() ?
                            Integer.parseInt(indices[1]) - 1 : -1;
                    normalIndices[i - 1] = indices.length > 2 && !indices[2].isEmpty() ?
                            Integer.parseInt(indices[2]) - 1 : -1;
                }

                faceVertices.add(vertexIndices);
                faceTextures.add(textureIndices);
                faceNormals.add(normalIndices);
            } else {
                throw new NumberFormatException();
            }
        }
    }

}
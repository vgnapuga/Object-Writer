package ru.vsu.cs.cg.objectWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.vsu.cs.cg.ObjData;

public class ObjWriter {

    public static void write(String filePath, ObjData object) throws IOException {
        String newFilePath = checkAndCreateFile(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath))) {
            writeVertices(object.vertices, writer);
            if (object.textures != null)
                writeTextures(object.textures, writer);
            if (object.normals != null)
                writeNormals(object.normals, writer);
            writeFaces(object.faces, writer);
        }
    }

    private static String checkAndCreateFile(String filePath) throws IOException {
        String newFilePath = filePath;

        if (!isObj(filePath)) {}
            newFilePath += ".obj";

        File file = new File(newFilePath);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }

        return newFilePath;
    }

    private static boolean isObj(String filePath) {
        return filePath.endsWith(".obj");
    }

    private static void writeVertices(List<float[]> vertices, BufferedWriter writer) throws IOException {
        for (float[] vertex : vertices)
            writer.write(String.format("v %f %f %f\n", vertex[0], vertex[1], vertex[2]));
    }

    private static void writeTextures(List<float[]> textureVertices, BufferedWriter writer) throws IOException {
        for (float[] vertex : textureVertices)
            writer.write(String.format("vt %f %f\n", vertex[0], vertex[1]));
    }

    private static void writeNormals(List<float[]> normalVertices, BufferedWriter writer) throws IOException {
        for (float[] vertex : normalVertices)
            writer.write(String.format("vn %f %f %f\n", vertex[0], vertex[1], vertex[2]));
    }

    private static void writeFaces(List<int[]> faces, BufferedWriter writer) throws IOException {
        for (int[] face : faces) {
            writer.write("f");
            for (int index : face)
                writer.write(" " + index);
            writer.write("\n");
        }
    }

}
package ru.vsu.cs.cg.obj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjWriter {

    public static void write(String filePath, ObjData object) throws IOException {
        String newFilePath = checkAndCreateFile(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath))) {
            writeVertices(object.getVertices(), writer);
            if (object.getTextures() != null)
                writeTextures(object.getTextures(), writer);
            if (object.getNormals() != null)
                writeNormals(object.getNormals(), writer);
            writeFaces(object.getFaces(), writer);
        }
    }

    private static String checkAndCreateFile(String filePath) throws IOException {
        if (!isObj(filePath))
            filePath += ".obj";

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }

        return filePath;
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
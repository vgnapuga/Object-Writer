package ru.vsu.cs.cg.obj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ObjWriter {

    public static void writeToFile(String filePath, ObjData object) throws IOException {
        String newFilePath = checkAndCreateFile(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath))) {
            writeVertices(object.getVertices(), writer);

            if (object.hasTextures())
                writeTextures(object.getTextures(), writer);
            if (object.hasNormals())
                writeNormals(object.getNormals(), writer);

            writeFaces(object, writer);
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

    private static void writeFaces(ObjData object, BufferedWriter writer) throws IOException {
        List<int[]> faceVertexIndices = object.getFaceVertices();
        List<int[]> faceTextureIndices = object.getFaceTextures();
        List<int[]> faceNormalIndices = object.getFaceNormals();

        for (int i = 0; i < faceVertexIndices.size(); i++) {
            int[] vertexIndices = faceVertexIndices.get(i);
            int[] textureIndices = faceTextureIndices.get(i);
            int[] normalIndices = faceNormalIndices.get(i);

            writer.write("f");
            for (int j = 0; j < vertexIndices.length; j++) {
                int vertexIndex = vertexIndices[j] + 1;
                int textureIndex = textureIndices[j] + 1;
                int normalIndex = normalIndices[j] + 1;

                if (textureIndex > 0 && normalIndex > 0)
                    writer.write(String.format(" %d/%d/%d", vertexIndex, textureIndex, normalIndex));
                else if (textureIndex > 0)
                    writer.write(String.format(" %d/%d", vertexIndex, textureIndex));
                else if (normalIndex > 0)
                    writer.write(String.format(" %d//%d", vertexIndex, normalIndex));
                else
                    writer.write(String.format(" %d", vertexIndex));
            }
            writer.newLine();
        }
    }
}
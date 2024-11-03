import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjWriter {

    public static void write(String filePath, List<float[]> vertices,
                             List<float[]> textures, List<float[]> normals,
                             List<int[]> faces) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writeVertices(vertices, writer);
            writeTextureVertices(textures, writer);
            writeNormalVertices(normals, writer);
            writeFaces(faces, writer);
        }
    }
    public static void write(String filePath, List<float[]> vertices, List<int[]> faces) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writeVertices(vertices, writer);
            writeFaces(faces, writer);
        }
    }
    public static void writeWithoutNormal(String filePath, List<float[]> vertices,
                                          List<float[]> textures, List<int[]> faces) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writeVertices(vertices, writer);
            writeTextureVertices(textures, writer);
            writeFaces(faces, writer);
        }
    }
    public static void writeWithoutTexture(String filePath, List<float[]> vertices,
                                           List<float[]> normals, List<int[]> faces) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writeVertices(vertices, writer);
            writeNormalVertices(normals, writer);
            writeFaces(faces, writer);
        }
    }

    private static void writeVertices(List<float[]> vertices, BufferedWriter writer) throws IOException {
        for (float[] vertex : vertices)
            writer.write(String.format("v %f %f %f\n", vertex[0], vertex[1], vertex[2]));
    }

    private static void writeTextureVertices(List<float[]> textureVertices, BufferedWriter writer) throws IOException {
        for (float[] vertex : textureVertices)
            writer.write(String.format("vt %f %f\n", vertex[0], vertex[1]));
    }

    private static void writeNormalVertices(List<float[]> normalVertices, BufferedWriter writer) throws IOException {
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
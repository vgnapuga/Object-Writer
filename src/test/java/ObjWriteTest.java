import org.junit.jupiter.api.BeforeEach;
import ru.vsu.cs.cg.obj.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjWriteTest {

    private static final String filePath = "src/test/resources/cube.obj";

    private List<float[]> vertices;
    private List<float[]> textures;
    private List<float[]> normals;
    private List<int[]> faceVertices;
    private List<int[]> faceTextures;
    private List<int[]> faceNormals;

    @BeforeEach
    public void setUp() {
        vertices = new ArrayList<>();
        textures = new ArrayList<>();
        normals = new ArrayList<>();
        faceVertices = new ArrayList<>();
        faceTextures = new ArrayList<>();
        faceNormals = new ArrayList<>();
    }

    @Test
    public void testWriteToFile() throws IOException {
        vertices.add(new float[]{0, 0, 0});
        vertices.add(new float[]{1, 0, 0});
        vertices.add(new float[]{0, 1, 0});
        vertices.add(new float[]{1, 1, 0});

        textures.add(new float[]{0, 0});
        textures.add(new float[]{1, 1});

        normals.add(new float[]{0, 0, 0});
        normals.add(new float[]{1, 0, 1});
        normals.add(new float[]{0, 1, 1});

        faceVertices.add(new int[]{0, 1, 2, 3});
        faceTextures.add(new int[]{0, -1, 1, -1});
        faceNormals.add(new int[]{0, 1, -1, -1});

        ObjData expected = new ObjData(vertices, textures, normals,
                faceVertices, faceTextures, faceNormals);
        ObjWriter.writeToFile(filePath, expected);

        ObjData result = ObjReader.readFromFile(filePath);

        for (int i = 0; i < vertices.size(); i++)
            assertArrayEquals(expected.getVertices().get(i), result.getVertices().get(i));
        for (int i = 0; i < textures.size(); i++)
            assertArrayEquals(expected.getTextures().get(i), result.getTextures().get(i));
        for (int i = 0; i < normals.size(); i++)
            assertArrayEquals(expected.getNormals().get(i), result.getNormals().get(i));
        for (int i = 0; i < faceVertices.size(); i++)
            assertArrayEquals(expected.getFaceVertices().get(i), result.getFaceVertices().get(i));
        for (int i = 0; i < faceTextures.size(); i++)
            assertArrayEquals(expected.getFaceTextures().get(i), result.getFaceTextures().get(i));
        for (int i = 0; i < faceNormals.size(); i++)
            assertArrayEquals(expected.getFaceNormals().get(i), result.getFaceNormals().get(i));
    }

}
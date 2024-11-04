import ru.vsu.cs.cg.obj.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        String path = "/home/onenull/.local/projects/IDEAProjects/CG/CG-task03/test.obj";

        List<float[]> vertices = new ArrayList<>();
        vertices.add(new float[]{1, 2, 3});
        vertices.add(new float[]{4, 5, 6});
        vertices.add(new float[]{7, 8, 9});

        List<float[]> textures = new ArrayList<>();
        textures.add(new float[]{1, 2});
        textures.add(new float[]{3, 4});

        List<float[]> normals = new ArrayList<>();
        normals.add(new float[]{1, 2, 3});
        normals.add(new float[]{4, 5, 6});

        List<int[]> faceVertices = new ArrayList<>();
        faceVertices.add(new int[]{0, 1, 2});

        List<int[]> faceTextures = new ArrayList<>();
        faceTextures.add(new int[]{0, -1, 2});

        List<int[]> faceNormals = new ArrayList<>();
        faceNormals.add(new int[]{0, 1, 2});

        ObjData object = new ObjData(vertices, textures, normals, faceVertices, faceTextures, faceNormals);

        ObjWriter.write(path, object);
    }

}

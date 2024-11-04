import ru.vsu.cs.cg.obj.*;

import java.io.IOException;

import static ru.vsu.cs.cg.obj.ObjReader.read;
import static ru.vsu.cs.cg.obj.ObjWriter.write;

public class Test {

    public static void main(String[] args) throws IOException {
        ObjData object;

        object = read("/home/onenull/.local/projects/IDEAProjects/CG/CG-task03/test.obj");

        System.out.println(object.getVertices());
    }

}

package ru.vsu.cs.cg.obj;

import java.util.ArrayList;
import java.util.List;

public class ObjData {

    private String filePath;

    private List<float[]> vertices;
    private List<float[]> textures;
    private List<float[]> normals;
    private List<int[]> faceVertices;
    private List<int[]> faceTextures;
    private List<int[]> faceNormals;

    public ObjData() {
        vertices = new ArrayList<>();
        textures = new ArrayList<>();
        normals = new ArrayList<>();
        faceVertices = new ArrayList<>();
        faceTextures = new ArrayList<>();
        faceNormals = new ArrayList<>();
    }

    public ObjData(List<float[]> vertices, List<float[]> textures,
                   List<float[]> normals, List<int[]> faceVertices,
                   List<int[]> faceTextures, List<int[]> faceNormals) {
        this.vertices = vertices;
        this.textures = textures;
        this.normals = normals;
        this.faceVertices = faceVertices;
        this.faceTextures = faceTextures;
        this.faceNormals = faceNormals;
    }

    public final void setVertices(List<float[]> vertices) {
        this.vertices = vertices;
    }
    public final List<float[]> getVertices() {
        return this.vertices;
    }

    public final void setTextures(List<float[]> textures) {
        this.textures = textures;
    }
    public final List<float[]> getTextures() {
        return this.textures;
    }

    public final void setNormals(List<float[]> normals) {
        this.normals = normals;
    }
    public final List<float[]> getNormals() {
        return this.normals;
    }

    public final void setFaceVertices(List<int[]> faceVertices) {
        this.faceVertices = faceVertices;
    }
    public final List<int[]> getFaceVertices() {
        return this.faceVertices;
    }

    public final void setFaceTextures(List<int[]> faceTextures) {
        this.faceTextures = faceTextures;
    }
    public final List<int[]> getFaceTextures() {
        return this.faceTextures;
    }

    public final void setFaceNormals(List<int[]> faceNormals) {
        this.faceNormals = faceNormals;
    }
    public final List<int[]> getFaceNormals() {
        return this.faceNormals;
    }

    public final void setPath(String filePath) {
        this.filePath = filePath;
    }
    public final String getPath() {
        return filePath;
    }

}
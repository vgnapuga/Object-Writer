package ru.vsu.cs.cg.obj;

import java.util.ArrayList;
import java.util.List;

public class ObjData {

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

    public void setVertices(List<float[]> vertices) {
        this.vertices = vertices;
    }
    public List<float[]> getVertices() {
        return this.vertices;
    }

    public void setTextures(List<float[]> textures) {
        this.textures = textures;
    }
    public List<float[]> getTextures() {
        return this.textures;
    }

    public void setNormals(List<float[]> normals) {
        this.normals = normals;
    }
    public List<float[]> getNormals() {
        return this.normals;
    }

    public void setFaceVertices(List<int[]> faceVertices) {
        this.faceVertices = faceVertices;
    }
    public List<int[]> getFaceVertices() {
        return this.faceVertices;
    }

    public void setFaceTextures(List<int[]> faceTextures) {
        this.faceTextures = faceTextures;
    }
    public List<int[]> getFaceTextures() {
        return this.faceTextures;
    }

    public void setFaceNormals(List<int[]> faceNormals) {
        this.faceNormals = faceNormals;
    }
    public List<int[]> getFaceNormals() {
        return this.faceNormals;
    }

    public boolean hasTextures() {
        return this.textures.size() > 0;
    }

    public boolean hasNormals() {
        return this.normals.size() > 0;
    }

}
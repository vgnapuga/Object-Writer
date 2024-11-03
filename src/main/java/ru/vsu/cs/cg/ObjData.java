package ru.vsu.cs.cg;

import java.util.ArrayList;
import java.util.List;

public class ObjData {

    public List<float[]> vertices;
    public List<float[]> textures;
    public List<float[]> normals;
    public List<int[]> faces;

    public ObjData() {
        vertices = new ArrayList<>();
        textures = new ArrayList<>();
        normals = new ArrayList<>();
        faces = new ArrayList<>();
    }

    public ObjData(List<float[]> vertices, List<float[]> textures,
                   List<float[]> normals, List<int[]> faces) {
        this.vertices = vertices;
        this.textures = textures;
        this.normals = normals;
        this.faces = faces;
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

    public void setFaces(List<int[]> faces) {
        this.faces = faces;
    }
    public List<int[]> getFaces() {
        return this.faces;
    }
}
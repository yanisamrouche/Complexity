package Zone_dense;

import java.util.ArrayList;

public class Subvertices {

    private final ArrayList<Integer> vertices;

    public  Subvertices(){
        vertices = new ArrayList<>();
    }
    public  Subvertices(ArrayList<Integer> vertices){
        this.vertices = vertices;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Subvertices && vertices.size() ==  ((Subvertices) obj).vertices.size()))
            return false;
        for (int vertice: vertices) {
            if( !((Subvertices) obj).vertices.contains(vertice))
                return false;
        }
        return true;
    }

    public ArrayList<Integer> printSubGraph() {
        return vertices;
    }

    public Subvertices clone() {
        return new Subvertices((ArrayList<Integer>) this.vertices.clone());
    }

    public void add(int newElement) {
        if (!vertices.contains(newElement))
            vertices.add(newElement);
    }

    public void removeAt(int index) {
        vertices.remove(index);
    }

    public int size() {
        return vertices.size();
    }

    public ArrayList<Integer> getVertices() {
        return vertices;
    }




}

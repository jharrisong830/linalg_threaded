import java.util.*;

public class Vector {
    private List<Double> vec;
    public int dimension;

    public Vector() {
        this.vec=new ArrayList<>();
        this.dimension=0;
    }

    public Vector(double[] arr) {
        this.vec=new ArrayList<>();
        int i=0;
        for(double x:arr) {
            this.vec.add(x);
            i++;
        }
        this.dimension=i;
    }

    public Vector(List<Double> lst) {
        vec=new ArrayList<>();
        int i=0;
        for(double x:lst) {
            this.vec.add(x);
            i++;
        }
        this.dimension=i;
    }

    public Double get(int index) {
        return this.vec.get(index-1);
    }

    public void set(int index, double value) {
        this.vec.set(index-1, value);
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("<");
        sb.append(this.get(1));
        for(int i=2; i<=this.dimension; i++) {
            sb.append(", ");
            sb.append(this.get(i));
        }
        sb.append(">");
        return sb.toString();
    }

    public void pushBack(double value) {
        this.vec.add(value);
        this.dimension++;
    }

    public double popBack() {
        this.dimension--;
        return this.vec.remove(this.dimension);
    }
}

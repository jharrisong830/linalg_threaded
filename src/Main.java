public class Main {
    public static void main(String[] args) {
        Matrix m1=new Matrix(2, 2);
        m1.set(1, 1, 1);
        m1.set(1, 2, 2);
        m1.set(2, 1, 2);
        m1.set(2, 2, 3);
        Matrix m2=new Matrix(2, 2);
        m2.set(1, 1, 1);
        m2.set(1, 2, 2);
        m2.set(2, 1, 2);
        m2.set(2, 2, 3);
        System.out.println(m1.mult(m2));
    }
}
import java.util.*;

public class Matrix {
    public int rows;
    public int cols;
    private List<List<Double>> A;

    public Matrix(int m, int n) {
        this.rows=m;
        this.cols=n;
        this.A=new ArrayList<>();
        for(int i=0; i<this.rows; i++) {
            this.A.add(new ArrayList<>());
            for(int j=0; j<this.cols; j++) {
                this.A.get(i).add(0.0);
            }
        }
    }

    public void set(int m, int n, double value) {
        this.A.get(m-1).set(n-1, value);
    }

    public double get(int m, int n) {
        return this.A.get(m-1).get(n-1);
    }

    private Vector getRowVec(int m) {
        return new Vector(this.A.get(m-1));
    }

    private Vector getColVec(int n) {
        Vector vec=new Vector();
        for(int i=1; i<=this.rows; i++) {
            vec.pushBack(this.get(i, n));
        }
        return vec;
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=1; i<=this.rows; i++) {
            for(int j=1; j<=this.cols; j++) {
                sb.append(this.get(i, j));
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Matrix mult(Matrix B) {
        if(this.cols!=B.rows) {
            throw new IllegalArgumentException("invalid dimensions");
        }
        List<DotProdCalc> results=new ArrayList<>();
        List<Thread> threads=new ArrayList<>();
        for(int i=1; i<=this.rows; i++) {
            for(int j=1; j<=B.cols; j++) {
                results.add(0, new DotProdCalc(this.getRowVec(i), B.getColVec(j), this.cols, i, j));
                threads.add(0, new Thread(results.get(0)));
                threads.get(0).start();
            }
        }
        for(Thread t: threads) {
            try {
                t.join();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        Matrix C=new Matrix(this.rows, B.cols);
        for(DotProdCalc product:results) {
            System.out.println(product.result);
            C.set(product.row, product.col, product.result);
        }
        return C;
    }
}

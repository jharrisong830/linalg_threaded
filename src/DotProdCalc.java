public class DotProdCalc implements Runnable {
    Vector v1, v2;
    int dimension, row, col;
    double result;

    public DotProdCalc(Vector vec1, Vector vec2, int dim, int x, int y) {
        this.v1=vec1;
        this.v2=vec2;
        this.dimension=dim;
        this.row=x;
        this.col=y;
        this.result=0;
    }

    public double dotProd() {
        double acc=0;
        for(int i=1; i<=this.dimension; i++) {
            acc+=(this.v1.get(i))*(this.v2.get(i));
        }
        return acc;
    }

    public void run() {
        result=this.dotProd();
    }
}

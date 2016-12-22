public class Liner extends Series {

    public Liner(){
        super();
    }

    public Liner(double First,double Diff) {
        super(First,Diff);
    }

    @Override
    double getElement(int j) {
        double element = this.firstElement;
        element += this.difference*j;
        return element;
    }
}

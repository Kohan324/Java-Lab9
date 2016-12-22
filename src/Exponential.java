public class Exponential extends Series {

       public Exponential(){ super(); }

       public Exponential(double First,double Diff) {
           super(First,Diff);
       }

      @Override
      double getElement(int j) {
          double element = this.firstElement;
          if (j != 0) {
              element *= this.difference * j;
          }
          return element;
      }
}

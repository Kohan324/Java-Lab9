import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

abstract class Series {

    protected double firstElement;
    protected double difference;

    public Series()
    {
        firstElement = 0;
        difference = 0;
    }

    public Series(double First,double Diff)
    {
        firstElement = First;
        difference = Diff;
    }

    abstract double getElement(int j);

    public double sumOfSeries(int n){
        double sum = 0;
        for( int i = 0; i < n;i++)
        {
            sum += this.getElement(i);
        }
        return sum;
    }

    public String toString(int n) {
        String str = new String();
        for(int i = 0;i < n-1;i++)
            str += this.getElement(i) + ", ";
        str += this.getElement(n-1);
        return str;
    }

    public void save(String fileName,Integer num) throws IOException {
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(this.toString(num));
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}

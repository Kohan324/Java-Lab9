import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.io.IOException;
import java.nio.file.Path;

public class Interface extends JFrame {
    Liner lin;
    Exponential expo;
    Double calcul;
    JFrame frame;
    JRadioButton rad1, rad2;
    ButtonGroup butGroup;
    JButton but;
    JLabel fst,dif,numb,sum,fname;
    JTextField fstEl, difEl, numbe,summa,fileName;
    JPanel panel = new JPanel();
    JLabel text = new JLabel();

    Interface() throws NumberFormatException{
        frame = new JFrame("Series");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(250,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        but = new JButton("Посчитать");

        rad1 = new JRadioButton("Liner",true);
        rad2 = new JRadioButton("Exponencial");

        butGroup = new ButtonGroup();
        butGroup.add(rad1);
        butGroup.add(rad2);

        fst = new JLabel("Введите первый элемент");
        dif = new JLabel("Введите разницу");
        numb = new JLabel("Введите кол-во элементов для вывода");
        sum = new JLabel("Сумма элементов:");
        fname = new JLabel("Имя файла");


        fstEl = new JTextField(12);
        difEl = new JTextField(12);
        numbe = new JTextField(12);
        summa = new JTextField(4);
        fileName = new JTextField(12);

        panel.setLayout(new GridLayout());

        frame.add(rad1);
        frame.add(rad2);
        frame.add(fst);
        frame.add(fstEl);
        frame.add(dif);
        frame.add(difEl);
        frame.add(numb);
        frame.add(numbe);
        frame.add(but);
        frame.add(sum);
        frame.add(summa);
        frame.add(fname);
        frame.add(fileName);
        frame.add(text);

//        frame.getContentPane().add(panel);

        but.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {

                   if(rad1.isSelected()){
                       try{
                       String b = new String(fstEl.getText());
                       String c = new String(difEl.getText());
                       String d = new String(numbe.getText());
                       String j = new String(fileName.getText());
                       lin = new Liner(Double.parseDouble(b),Double.parseDouble(c));
                       calcul = new Double(lin.sumOfSeries(Integer.parseInt(d)));
                       summa.setText(calcul.toString());
                       text.setText(lin.toString(Integer.parseInt(d)));
                       try {
                           lin.save(j,Integer.parseInt(d) );
                       }catch (IOException q) {}
                       } catch (NumberFormatException err) {
                           fstEl.setText("");
                           difEl.setText("");
                           numbe.setText("");
                           summa.setText("");
                       }

                   }
                   if(rad2.isSelected()) {
                       try{
                       String b = new String(fstEl.getText());
                       String c = new String(difEl.getText());
                       String d = new String(numbe.getText());
                       String j = new String(fileName.getText());
                       expo = new Exponential(Double.parseDouble(b),Double.parseDouble(c));
                       calcul = new Double(expo.sumOfSeries(Integer.parseInt(d)));
                       summa.setText(calcul.toString());
                       text.setText(expo.toString(Integer.parseInt(d)));
                           try {
                               expo.save(j,Integer.parseInt(d) );
                           }catch (IOException q) {}
                       } catch (NumberFormatException err) {
                           fstEl.setText("");
                           difEl.setText("");
                           numbe.setText("");
                           summa.setText("");
                       }
                   }
                }
        });

        frame.setVisible(true);
    }

}

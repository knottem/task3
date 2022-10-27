import javax.swing.*;
import java.awt.*;

public class Program {

    JFrame frame = new JFrame("15-spel");
    JPanel panel = new JPanel();
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    int tileSize = 100;

    void program(){
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10= new JButton("10");
        b11 = new JButton("11");
        b12 = new JButton("12");
        b13 = new JButton("13");
        b14 = new JButton("14");
        b15 = new JButton("15");

        panel.setLayout(new GridLayout(4,4));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        panel.add(b14);
        panel.add(b15);

        frame.add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tileSize*4, tileSize*4);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);



    }
}

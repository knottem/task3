import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Program {

    JFrame frame = new JFrame("15-spel");
    JPanel panel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<>();
    int tileSize = 100;

    Font defaultFont = new Font("Arial Black", Font.PLAIN, 20);

    void program(){
        for (int i = 0; i < 15; i++) {
            buttons.add(new JButton());
            buttons.get(i).setText(String.valueOf(i));
        }

        panel.setLayout(new GridLayout(4,4));
        panel.add(buttons.get(0));
        panel.add(buttons.get(1));
        panel.add(buttons.get(2));
        panel.add(buttons.get(3));
        panel.add(buttons.get(4));
        panel.add(buttons.get(5));
        panel.add(buttons.get(6));
        panel.add(buttons.get(7));
        panel.add(buttons.get(8));
        panel.add(buttons.get(9));
        panel.add(buttons.get(10));
        panel.add(buttons.get(11));
        panel.add(buttons.get(12));
        panel.add(buttons.get(13));
        panel.add(buttons.get(14));


        frame.add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tileSize*4, tileSize*4);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);



    }
}

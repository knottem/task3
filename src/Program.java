import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Program {

    JFrame frame = new JFrame("15-spel");
    JPanel panel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<>();
    int tileSize = 100;
    JButton tommaRutan = new JButton();

    int width = 0;
    int height = 0;

    Font defaultFont = new Font("Arial Black", Font.PLAIN, 20);

    void program(){

        for (int i = 0; i < 15; i++) {
            buttons.add(new JButton());
            buttons.get(i).setText(String.valueOf(i+1));
            buttons.get(i).setSize(width,height);
            buttons.get(i).setFont(defaultFont);
            panel.add(buttons.get(i));
        }
        tommaRutan.setVisible(false);
        panel.add(tommaRutan);

        for (JButton button : buttons) {
            button.addActionListener(e -> {
                panel.remove(button);
                panel.add(button);
                frame.validate();
                frame.repaint();
            });
        }


        panel.setLayout(new GridLayout(4,4));

        frame.add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tileSize*4, tileSize*4);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);



    }
}

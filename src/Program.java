import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Program {

    JFrame frame = new JFrame("15-spel");
    JPanel panel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<>();
    int tileSize = 100;
    JButton tommaRutan = new JButton("test");

    int width = 0;
    int height = 0;

    Font defaultFont = new Font("Arial Black", Font.PLAIN, 20);


    void program(){

        for (int i = 0; i < 15; i++) {
            buttons.add(new JButton());
            buttons.get(i).setBounds(width,height,tileSize,tileSize);
            buttons.get(i).setText(String.valueOf(i+1));
            buttons.get(i).setFont(defaultFont);
            panel.add(buttons.get(i),i);
            width = width + tileSize;
            if(i == 3 || i == 7 || i == 11){
                height = height + tileSize;
                width = 0;
            }
        }
        tommaRutan.setVisible(false);
        tommaRutan.setBounds(tileSize*3,tileSize*3,tileSize,tileSize);
        panel.add(tommaRutan);

        buttons.get(14).addActionListener(e -> {
            int originalX = buttons.get(14).getX();
            int originalY = buttons.get(14).getY();
            int tommaRutanX = tommaRutan.getX();
            int tommaRutanY = tommaRutan.getY();
            if(originalX - tommaRutanX == tileSize || originalX + tommaRutanX == tileSize || tommaRutanX - originalX == tileSize){
                buttons.get(14).setBounds(tommaRutanX,originalY,tileSize,tileSize);
                tommaRutan.setBounds(originalX,tommaRutanY,tileSize,tileSize);
            }
        });




      /*for (JButton button : buttons) {
            button.addActionListener(e -> {
                    panel.remove(button);
                    panel.add(button);
                    frame.validate();
                    frame.repaint();
            });
        }

       */




        panel.setLayout(null);

        frame.add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tileSize*4 + 15, tileSize*4 + 35);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);



    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Program extends Tools{

    JFrame frame = new JFrame("15-spel");
    JPanel panel = new JPanel();

    JPanel topPanel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<>();

    JButton tommaRutan = new JButton();
    JButton newGame = new JButton("Nytt Spel");

    void program(){

       /* for (int i = 0; i < 15; i++) {
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

        */

        for (int j = 0; j < 16; j++) {
            buttons.add(new JButton());
        }

        createRandomStartTiles(buttons, panel);
        panel.add(tommaRutan);


        for (int i = 0; i < buttons.size(); i++) {
            int finalI = i;
            buttons.get(i).addActionListener(e -> checkIfMove(buttons, finalI, frame));
        }


        topPanel.add(newGame);
        newGame.addActionListener(e -> createRandomStartTiles(buttons,panel));

        panel.setLayout(null);
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);

        frame.add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tileSize*4 + 15, tileSize*4 + 65);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);



    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Program extends Tools{

    JFrame frame = new JFrame("15-spel");
    JPanel panel = new JPanel();
    JPanel topPanel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<>();
    public int tileSize = 100;

    JButton tommaRutan = new JButton();
    JButton newGame = new JButton("Nytt Spel");

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

        buttons.get(11).addActionListener(e -> checkIfMove(buttons,11, tommaRutan, tileSize));
        buttons.get(10).addActionListener(e -> checkIfMove(buttons,10, tommaRutan, tileSize));

        topPanel.add(newGame);

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

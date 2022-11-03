import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Program extends Tools{

    JFrame frame = new JFrame("15-spel");
    JPanel panel = new JPanel();

    JPanel topPanel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<>();

    JButton newGame = new JButton("Nytt Spel");
    JButton devHelp = new JButton("Dev Help");

    TilesCreator tilesCreator = new TilesCreator();

    void program(){

        for (int i = 0; i < 16; i++) {
            int finalI = i;
            buttons.add(new JButton());
            buttons.get(i).addActionListener(e -> checkIfMove(buttons, finalI, frame));
            buttons.get(i).setFocusPainted(false);
            buttons.get(i).setFont(defaultFont);
        }
        buttons.get(15).setVisible(false);

        topPanel.add(newGame);
        newGame.addActionListener(e -> tilesCreator.createRandomStartTiles(buttons,panel));
        topPanel.add(devHelp);
        devHelp.addActionListener(e -> tilesCreator.createDevStartTiles(buttons,panel));

        panel.setLayout(null);
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);

        frame.add(panel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tileSize*4 + 15, tileSize*4 + 75);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        tilesCreator.createRandomStartTiles(buttons,panel);

    }
}

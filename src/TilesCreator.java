import javax.swing.*;
import java.util.ArrayList;

public class TilesCreator extends Tools{

    public void createRandomStartTiles (ArrayList<JButton> buttons, JPanel panel) {

        height = 0;
        width = 0;
        ArrayList<Integer> numbers = randomNumbers();
        for (int i = 0; i < 16; i++) {
            buttons.get(numbers.get(i)).setBounds(width, height, tileSize, tileSize);
            buttons.get(numbers.get(i)).setText(String.valueOf(numbers.get(i)+1));
            buttons.get(i).setFocusPainted(false);
            buttons.get(i).setFont(defaultFont);
            panel.add(buttons.get(numbers.get(i)));
            width = width + tileSize;
            if (i == 3 || i == 7 || i == 11) {
                height = height + tileSize;
                width = 0;
            }
        }
        buttons.get(15).setVisible(false);
    }
}

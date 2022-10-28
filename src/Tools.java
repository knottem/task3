import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Tools {
    public ArrayList<Integer> randomNumbers() {
        ArrayList<Integer> randomizer = new ArrayList<>();
        randomizer.add(1);
        randomizer.add(2);
        randomizer.add(3);
        randomizer.add(4);
        randomizer.add(5);
        randomizer.add(6);
        randomizer.add(7);
        randomizer.add(8);
        randomizer.add(9);
        randomizer.add(10);
        randomizer.add(11);
        randomizer.add(12);
        randomizer.add(13);
        randomizer.add(14);
        randomizer.add(15);

        Collections.shuffle(randomizer);
        for (int i : randomizer)
            System.out.println(i);
        return randomizer;
    }
public void createRandomStartTiles (ArrayList<JButton> buttons, JPanel panel) {
    int height = 0;
    int width = 0;
    int tileSize = 100;
    ArrayList<Integer> numbers = randomNumbers();
    for (int i = 0; i < 15; i++) {
        buttons.add(new JButton());
        buttons.get(i).setBounds(width, height, tileSize, tileSize);
        buttons.get(i).setText(String.valueOf(numbers.get(i)));
        //buttons.get(i).setFont(defaultFont);
        panel.add(buttons.get(i), i);
        width = width + tileSize;
        if (i == 3 || i == 7 || i == 11) {
            height = height + tileSize;
            width = 0;
        }

    }
}
}

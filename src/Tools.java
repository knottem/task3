import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Tools {

    Font defaultFont = new Font("Arial Black", Font.PLAIN, 20);
    int width;
    int height;
    int tileSize = 100;

    public ArrayList<Integer> randomNumbers() {
        ArrayList<Integer> randomizer = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            randomizer.add(i);
        }

        Collections.shuffle(randomizer);
        return randomizer;
    }

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

    public void checkIfMove(ArrayList<JButton> buttons,int i, JFrame frame){

        int originalX = buttons.get(i).getX();
        int originalY = buttons.get(i).getY();
        int tommaRutanX = buttons.get(15).getX();
        int tommaRutanY = buttons.get(15).getY();
        if((originalX - tommaRutanX == tileSize || originalX + tommaRutanX == tileSize || tommaRutanX - originalX == tileSize) && tommaRutanY == originalY){
            buttons.get(i).setBounds(tommaRutanX,originalY,tileSize,tileSize);
            buttons.get(15).setBounds(originalX,tommaRutanY,tileSize,tileSize);
        }
        else if((originalY - tommaRutanY == tileSize || originalY + tommaRutanY == tileSize || tommaRutanY - originalY == tileSize) && tommaRutanX == originalX){
            buttons.get(i).setBounds(originalX,tommaRutanY,tileSize,tileSize);
            buttons.get(15).setBounds(tommaRutanX,originalY,tileSize,tileSize);
        }
        showWinnerMessage(frame, checkIFWinner(buttons));
    }

    public boolean checkIFWinner(ArrayList<JButton> buttons){

        boolean win = false;
        int result = 0;
        width = 0;
        height = 0;
        int winX = 0;
        int winY = 0;

        for (int i = 0; i < buttons.size(); i++) {
            width = buttons.get(i).getX();
            height = buttons.get(i).getY();
            if(width == winX){
                result++;
            }
            if(height == winY){
                result++;
            }
            winX = winX + tileSize;
            if(i == 3 || i == 7 || i == 11){
                winY = winY + tileSize;
                winX = 0;
            }
        }
        if(result == 30){
            win = true;
        }
        return win;
    }

    public void showWinnerMessage(JFrame frame,boolean winner){
        if(winner){
            JOptionPane.showMessageDialog(frame,"Du vann");
        }
    }
}

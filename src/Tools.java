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

    public boolean isSolvable(ArrayList<Integer> randomizer)
    {
        int parity = 0;
        int gridWidth = (int) Math.sqrt(randomizer.size());
        int row = 0; // the current row we are on
        int blankRow = 0; // the row with the blank tile

        for (int i = 0; i < randomizer.size(); i++)
        {
            if (i % gridWidth == 0) { // advance to next row
                row++;
            }
            if (randomizer.get(i) == 0) { // the blank tile
                blankRow = row; // save the row on which encountered
                continue;
            }
            for (int j = i + 1; j < randomizer.size(); j++)
            {
                if (randomizer.get(i) > randomizer.get(j) && randomizer.get(j) != 0)
                {
                    parity++;
                }
            }
        }

        if (gridWidth % 2 == 0) { // even grid
            if (blankRow % 2 == 0) { // blank on odd row; counting from bottom
                return parity % 2 == 0;
            } else { // blank on even row; counting from bottom
                return parity % 2 != 0;
            }
        } else { // odd grid
            return parity % 2 == 0;
        }
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

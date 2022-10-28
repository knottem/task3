import javax.swing.*;
import java.util.ArrayList;

public class Tools {

    public void checkIfMove(ArrayList<JButton> buttons,int i, JButton tommaRutan, int tileSize){

        int originalX = buttons.get(i).getX();
        int originalY = buttons.get(i).getY();
        int tommaRutanX = tommaRutan.getX();
        int tommaRutanY = tommaRutan.getY();
        if((originalX - tommaRutanX == tileSize || originalX + tommaRutanX == tileSize || tommaRutanX - originalX == tileSize) && tommaRutanY == originalY){
            buttons.get(i).setBounds(tommaRutanX,originalY,tileSize,tileSize);
            tommaRutan.setBounds(originalX,tommaRutanY,tileSize,tileSize);
        }
        else if((originalY - tommaRutanY == tileSize || originalY + tommaRutanY == tileSize || tommaRutanY - originalY == tileSize) && tommaRutanX == originalX){
            buttons.get(i).setBounds(originalX,tommaRutanY,tileSize,tileSize);
            tommaRutan.setBounds(tommaRutanX,originalY,tileSize,tileSize);
        }
    }
}

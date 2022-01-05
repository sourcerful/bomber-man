import javax.swing.*;
import java.awt.*;

public abstract class Entity extends Thread
{
    final static String PATH = "C:\\Users\\Shonb\\Desktop\\School\\YudDaled\\JavaProject\\assets";
    int x, y;
    int width, height;
    Image img;
    Rectangle rect;
    Tile currentTile;
    GamePanel panel;

    Entity(int x, int y, int width, int height, String path, GamePanel panel)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.panel = panel;
        currentTile = null;
        loadImage(path);
    }

    @Override
    public abstract void run();
    public abstract void draw(Graphics g);
    public void loadImage(String imagePath)
    {
        img = (new ImageIcon(imagePath)).getImage();
    }
}

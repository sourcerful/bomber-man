import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GamePanel extends JPanel
{
    Player main_player;
    Vector<Player> players;
    Tile[][] grid;
    Vector<Bomb> activeBombs;

    public GamePanel(int width, int height)
    {
        grid = new Tile[11][22];
        main_player = new Player(this, 60, 70, width / grid[0].length ,width / grid[0].length + 10, "Vamquerror");
        activeBombs = new Vector<>();

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = new Tile(j * (main_player.width), i * (main_player.width), this,
                        new Color((int)(Math.random()*256),
                        (int)(Math.random()*256),
                        (int)(Math.random()*256)));
            }
        }

        this.addKeyListener(new KeyAction(this));
        setBackground(Color.CYAN);
        startThreads();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Tile[] tiles: grid)
        {
            for(Tile tile: tiles)
                tile.draw(g);
        }
        main_player.draw(g);
        for(Bomb bomb: activeBombs)
            bomb.draw(g);
    }
    public void startThreads()
    {
        main_player.start();
    }
}

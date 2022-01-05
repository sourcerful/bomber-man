import java.awt.*;

public class Bomb extends Entity
{
    public Bomb(int x, int y, int width, int height, GamePanel panel)
    {
        super(x, y, width, height, PATH+"\\bombs\\rbomb\\detonation.gif", panel);
        start();
    }
    public Bomb(Tile tile, int width, int height, GamePanel panel)
    {
        super((tile.x + tile.width) / 2, (tile.y + tile.height) / 2, width, height, PATH+"\\bombs\\rbomb\\detonation.gif", panel);
        System.out.println("check");
        currentTile = tile;
        start();
    }
    public void run()
    {
        int count = 0;
        int sleep = 10;

        while(true)
        {
            try
            {
                Thread.sleep(sleep);
            }catch(InterruptedException e){ }

            count += sleep;
            if(count / 1000 == 1)
                break;

            panel.repaint();
        }
        //TODO: trigger exploding animation
        currentTile = null;
        panel.activeBombs.remove(this);
    }
    public void draw(Graphics g)
    {
        g.drawImage(img, x, y, width, height, null);
    }

}

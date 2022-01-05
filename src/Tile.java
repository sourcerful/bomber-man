import java.awt.*;

public class Tile
{
    int x, y;
    int width, height;
    GamePanel panel;
    Entity entityOnTile;
    Color color;
    Rectangle rec;
    Image img;

    public Tile(int x, int y, Image img, GamePanel panel)
    {
        this.x = x;
        this.y = y;
        this.panel = panel;
        this.width = panel.main_player.height;
        this.height = panel.main_player.height;
        entityOnTile = null;
        img = null; // set it later
        rec = new Rectangle(x, y, width, height);
    }
    public Tile(int x, int y, GamePanel panel, Color color)
    {
        this.x = x;
        this.y = y;
        this.panel = panel;
        this.width = panel.main_player.width;
        this.color = color;
        this.height = panel.main_player.width;
        entityOnTile = null;
        img = null; // set it later
        rec = new Rectangle(x, y, width, height);
    }
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public String toString() {
        return "\nTile{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", entityOnTile=" + entityOnTile +
                '}';
    }
}


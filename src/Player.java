import java.awt.*;
import java.util.HashMap;

public class Player extends Entity
{
    final String _name;
    HashMap<String, Boolean> direction;
    String last_direction;

    public Player(GamePanel panel, int x, int y, int width, int height, String name)
    {
        super(x, y, width, height, PATH+"\\bomberWhite\\down\\standingDown.png", panel); //delay of 20-25
        this._name = name;
        rect = new Rectangle(x, y, width, height);
        last_direction = "down";
        direction = new HashMap<String, Boolean>();
        direction.put("right", false);
        direction.put("left", false);
        direction.put("up", false);
        direction.put("down", false);
    }
    @Override
    public void run()
    {
        //int dirx = 0;
        //int diry = 0;

        while (true)
        {
            if(isMoving())
                move();
            else
                loadImages();
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            //updateTile();

            rect.x = x;
            rect.y = y;
            rect.width = width;
            rect.height = height;

            checkBoundaries();

            /*
            todo: replace with rect.x / tile.width = j, rect.y / tile.height = i
            todo: check all the tiles intersecting with the player and fix the updates.
            */

            panel.repaint();
        }
    }
    public boolean isMoving()
    {
        for(var pair: direction.entrySet()) // Map.Entry<String, Boolean> pair = var
            if(pair.getValue()) return true;
        return false;
    }
    public void loadImages()
    {
        if(last_direction == "right")
            loadImage(PATH+"\\bomberWhite\\right\\standingRight.png");
        else if (last_direction == "left")
            loadImage(PATH+"\\bomberWhite\\left\\standingLeft.png");
        else if (last_direction == "up")
            loadImage(PATH+"\\bomberWhite\\up\\standingUp.png");
        else if (last_direction == "down")
            loadImage(PATH+"\\bomberWhite\\down\\standingDown.png");
    }
    public void move()
    {
        if(direction.get("right"))
            moveRight();
        else if (direction.get("left"))
            moveLeft();
        else if (direction.get("up"))
            moveUp();
        else if (direction.get("down"))
            moveDown();
    }
    public void updateTile()
    {
        int width = panel.grid[0][0].width;
        int height = panel.grid[0][0].height;

        int i = rect.y / height;
        int j = rect.x / width;

        System.out.println(i + " " + j);

        Tile t = panel.grid[i][j];

        if(t.rec.intersects(rect) && t.entityOnTile == null)
        {
            System.out.println("inside");
            currentTile = t; //todo: fix this
            t.entityOnTile = this;
        }
    }
    public void moveRight()
    {
        x += 5;
        loadImage(PATH+"\\bomberWhite\\right\\walkingRight.gif");
        last_direction = "right";
    }
    public void moveLeft()
    {
        x -= 5;
        loadImage(PATH+"\\bomberWhite\\left\\walkingLeft.gif");
        last_direction = "left";
    }
    public void moveUp()
    {
        y -= 5;
        loadImage(PATH+"\\bomberWhite\\up\\walkingUp.gif");
        last_direction = "up";
    }
    public void moveDown()
    {
        y += 5;
        loadImage(PATH+"\\bomberWhite\\down\\walkingDown.gif");
        last_direction = "down";
    }
    public void checkBoundaries()
    {
        int width = panel.getWidth();
        int height = panel.getHeight();

        if(x <= 0) //todo: fix the image to the correct size, and set it here.
            x = 0;
        if(x + this.width >= width)
            x = width - this.width;
        if(y <= 0)
            y = 0;
        if(y + this.width >= height)
            y = height - this.height;
    }
    public void draw(Graphics g)
    {
       // img = (new ImageIcon(PATH+"\\bomberWhite\\right\\standingRight.png")).getImage();
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
        g.drawImage(img, x, y, width, height, null);
    }
}

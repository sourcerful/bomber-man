import javax.swing.*;
import java.awt.*;

public class Game extends JFrame
{
    GamePanel gp; // add allahu easter egg

    public Game()
    {
        super("Bomber Man Pre SB(c)");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        gp = new GamePanel((int)screenSize.getWidth(), (int)screenSize.getHeight());
        this.setUndecorated(true);
        gp.setFocusable(true);
        this.add(gp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        this.setResizable(true);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        Game game = new Game();
    }
}



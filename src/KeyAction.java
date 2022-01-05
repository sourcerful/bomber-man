import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAction extends KeyAdapter
{
    GamePanel panel;

    KeyAction(GamePanel panel)
    {
        this.panel = panel;
    }
    @Override
    public synchronized void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        switch(key) {
            case KeyEvent.VK_RIGHT:
                panel.main_player.direction.put("right", true);
                break;
            case KeyEvent.VK_LEFT:
                panel.main_player.direction.put("left", true);
                break;
            case KeyEvent.VK_UP:
                panel.main_player.direction.put("up", true);
                break;
            case KeyEvent.VK_DOWN:
                panel.main_player.direction.put("down", true);
                break;
            case KeyEvent.VK_SPACE:
                if(panel.main_player.currentTile != null)
                {
                    panel.activeBombs.add(new Bomb(panel.main_player.currentTile,
                            32, 32,
                            panel));
                }
                else
                    System.out.println("fail");
                break;
        }
    }
    public synchronized void keyReleased(KeyEvent e)
    {
        int key = e.getExtendedKeyCode();

        switch(key)
        {
            case KeyEvent.VK_RIGHT:
                panel.main_player.direction.put("right", false);
                break;
            case KeyEvent.VK_LEFT:
                panel.main_player.direction.put("left", false);
                break;
            case KeyEvent.VK_UP:
                panel.main_player.direction.put("up", false);
                break;
            case KeyEvent.VK_DOWN:
                panel.main_player.direction.put("down", false);
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(1); //later to pause menu
        }
    }
}

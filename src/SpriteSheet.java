import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteSheet
{
    private final ArrayList<BufferedImage> sprites;

    public SpriteSheet(ArrayList<BufferedImage> sprites)
    {
        this.sprites = new ArrayList<>(sprites);
    }
    public int count()
    {
        return sprites.size();
    }
    public BufferedImage getSprite(double progress)
    {
        int frame = (int) (count() * progress);
        return sprites.get(frame);
    }
    public static BufferedImage[][] sliceSpriteMap(BufferedImage spriteMap, int spriteWidth, int spriteHeight)
    {
        int rows = spriteMap.getHeight() / spriteHeight;
        int cols = spriteMap.getWidth() / spriteWidth;
        BufferedImage[][] sprites = new BufferedImage[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sprites[row][col] = spriteMap.getSubimage(col * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);
            }
        }

        return sprites;
    }

}

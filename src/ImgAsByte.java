import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgAsByte {

    private BufferedImage originalImage;
    public int height=0;
    public int width=0;

    public ImgAsByte(File file) {

        originalImage=null;

        try {
            originalImage=ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        height=originalImage.getHeight();
        width=originalImage.getWidth();

    }

    public int[][] getOriginalImgMap(){
        int [][] map=new int[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                map[i][j]=originalImage.getRGB(i,j);
            }
        }
        return map;
    }




}

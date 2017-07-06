import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ByteAsImg {


    private GenerateMapWithMsg map;
    private ImgAsByte imgAsByte;
    private BufferedImage bufferedImage;
    int[][] mape;


    public ByteAsImg(GenerateMapWithMsg map, ImgAsByte imgAsByte) {
        this.map=map;
        this.imgAsByte=imgAsByte;
        bufferedImage=new BufferedImage(imgAsByte.width,imgAsByte.height,BufferedImage.TYPE_INT_RGB);
        mape=map.getNewmap();
    }



    public void writeImg(File file){

        for(int i=0;i<imgAsByte.height;i++){
            for (int j=0;j<imgAsByte.width;j++){
                bufferedImage.setRGB(i,j,mape[i][j]);
            }
        }
        try {
            ImageIO.write(bufferedImage,"bmp",file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

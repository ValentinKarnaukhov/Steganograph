import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Валентин on 05.07.2017.
 */
public class ReadMsgInImg {

    private File file;
    private BufferedImage bufferedImage;
    private StringBuilder stringBuilder=new StringBuilder("");
    private StringBuilder lengthasbit=new StringBuilder("");
    private int length=0;
    private int count=0;
    private StringBuilder message=new StringBuilder("");

    public ReadMsgInImg(File file) {

        this.file=file;

        try {
            bufferedImage= ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getMessage(){
        count=0;
        for(int i=0;i<bufferedImage.getHeight();i++){
            for (int j=0;j<bufferedImage.getWidth();j++){
                count++;
                if(count==15)break;
                lengthasbit.append(Integer.toBinaryString(bufferedImage.getRGB(i,j)).substring(31,32));
            }
            if(count==15)break;
        }

        count=0;
        length=Integer.parseUnsignedInt(lengthasbit.toString(),2);

        for(int i=0;i<bufferedImage.getHeight();i++){
            for (int j=0;j<bufferedImage.getWidth();j++){
                if(count==length*7+14)break;
                stringBuilder.append(Integer.toBinaryString(bufferedImage.getRGB(i,j)).substring(31,32));
                count++;
            }
            if(count==length)break;
        }

        for(int i=14;i<stringBuilder.length();i=i+7){
            message.append((char)Integer.parseUnsignedInt(stringBuilder.substring(i,i+7),2));
        }

        return message.toString();

    }



}


import java.io.File;

public class SteganoRel {
    public static void main(String[] args) {

        File infile = new File("src/test.bmp");
        File outfile = new File("src/codedimg.bmp");

        ImgAsByte originalImage=new ImgAsByte(infile);

        String message="Phasellus at odio et tellus feugiat facilisis id sed orci. Pellentesque eleifend nulla at neque placerat porttitor. Vivamus lacus quam, fringilla ut ante ac, ultricies mollis quam. Curabitur bibendum velit nec metus tempus viverra. Praesent dui odio, pharetra vitae leo non, pharetra imperdiet nibh. Phasellus id pulvinar lacus. Etiam a turpis sollicitudin velit laoreet porttitor. Cras dignissim auctor velit, varius vehicula leo porta non. Integer eu nulla tempus, maximus massa at, ultrices eros. Vivamus ut erat velit. Etiam mattis tortor ipsum, sed vehicula nibh efficitur ac. Aliquam erat volutpat.";

        MessageAsBit bitMsg=new MessageAsBit(message);

        GenerateMapWithMsg mapWithMsg=new GenerateMapWithMsg(originalImage,bitMsg.getMessageAsBit());

        ByteAsImg newimg=new ByteAsImg(mapWithMsg,originalImage);

        newimg.writeImg(outfile);

        ReadMsgInImg newmessage=new ReadMsgInImg(outfile);

        System.out.println(newmessage.getMessage());








    }
}

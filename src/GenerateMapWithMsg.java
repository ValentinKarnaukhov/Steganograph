
public class GenerateMapWithMsg {

    private int[][] newmap;
    private StringBuilder msg;
    private ImgAsByte img;
    private int count=0;

    public GenerateMapWithMsg(ImgAsByte imgAsByte, String messageAsBit) {
        newmap=imgAsByte.getOriginalImgMap();
        msg=new StringBuilder(messageAsBit);
        img=imgAsByte;

    }

    public int[][] getNewmap(){
        int [][] origmap=img.getOriginalImgMap();
        for(int i=0;i<img.height;i++){
            for (int j=0;j<img.width;j++){
                if(count==msg.length())break;
                StringBuilder bytes=new StringBuilder(Integer.toBinaryString(origmap[i][j]));
                bytes=bytes.replace(31,32,msg.substring(count,count+1));
                count++;
                newmap[i][j]=Integer.parseUnsignedInt(bytes.toString(),2);
            }
            if(count==msg.length())break;
        }
        return newmap;
    }
}

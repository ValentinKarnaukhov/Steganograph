
public class MessageAsBit {

    StringBuilder message;

    private StringBuilder stringBuilder;

    private int lengMsg=0;

    public MessageAsBit(String message) {

        this.message=new StringBuilder(message);
        lengMsg=message.length();

    }

    public String getMessageAsBit(){
        StringBuilder lengthAsByte=new StringBuilder("00000000000000");
        String st=Integer.toBinaryString(lengMsg);
        lengthAsByte.replace(14-st.length(),14,st);
        stringBuilder=new StringBuilder();
        stringBuilder.append(lengthAsByte);
        StringBuilder pattern=new StringBuilder("0000000");
        for(int i=0;i<message.length();i++){
            String s=Integer.toBinaryString((int)message.charAt(i));
            stringBuilder.append(pattern.replace(7-s.length(),7,s));
            pattern= new StringBuilder("0000000");
        }
        return stringBuilder.toString();
    }
}

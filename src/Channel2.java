import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Channel2 {
    public String ivesti()
    {
        String data = "";
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        try {
        	data = reader.readLine();
        	if (data.length() > 64){
        		data = data.substring(0, 64);
        	}
        }
        catch(Exception e){}
        return data;
    } 
}

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;

public class Channel3 {

    
    public DataInputStream OpenFile(String name)
    {
        DataInputStream in = null;
        try
        {
            FileInputStream fstream = new FileInputStream(name);    
            in = new DataInputStream(fstream);
        }
        catch (Exception e){}
        return in;
    }
    
    public void CloseFile(DataInputStream dataInputStream)
    {
        try{ 
        	dataInputStream.close(); 
        }catch (Exception e){}
    }
    
    public String readLine(BufferedReader buffReader)
    {
        String line;
        try { 
        	line = buffReader.readLine(); 
        }catch (Exception e){ line = null; }
        
        return line;
    }
}

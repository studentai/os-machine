import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Channel3 {

    private BufferedReader file;
    private String line;
	public void openFile(String fName){
		 try{
			FileReader fileReader = new FileReader(fName);
			file = new BufferedReader(fileReader);
		 }catch(FileNotFoundException e){System.out.println("Klaida atidarant faila");}
	}	
    
    public void closeFile(){
        try{ 
        	this.file.close(); 
        }catch (Exception e){}
    }
    
    public String readLine(){
        try { 
        	line = file.readLine(); 
        }catch (Exception e){ line = null; }
        
        return line;
    }
}

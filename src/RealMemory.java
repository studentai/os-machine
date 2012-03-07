
public class RealMemory {
	private byte[][] memory = new byte[1024][4];  //1024 �od�iai po 4 baitus.
	
	public RealMemory(){
		for (int i=0;i<memory.length;i++){
			for (int j=0;j<memory[i].length;j++){
				memory[i][j] = 0;
			}
		}
	}
	
	public byte[] getWord(int arg){
		if ((arg>=0) && (arg<=memory.length)){
			return memory[arg];
		}
		else return null;
	}
	
	public byte[][] getMemory(){
		return memory;
	}
}

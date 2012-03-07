public class VirtualMemory {
	private byte[][] memory = new byte[256][4];  //1024 þodþiai po 4 baitus.
	
	public VirtualMemory(){
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
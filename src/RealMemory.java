public class RealMemory {
	private byte[][] memory = new byte[1024][4];  //1024 þodþiai po 4 baitus.
	private int blockSize = 16; //Kiek bloke bus þodþiø
	
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
	public boolean setWord(int addr, byte[] word){
		if ((addr>=0) && (addr<=memory.length)){
			if (word.length >= memory[addr].length){
				for (int j=0;j<memory[addr].length;j++){
					memory[addr][j] = word[j];
				}
				return true;
			} else return false;
		}
		return false;
	}
	
	public byte[][] getBlock(int arg){
		byte[][] ret = null;
		if ((arg>=0)&&(arg<=memory.length/blockSize)){
			ret = new byte[blockSize][memory[0].length];
			int j = 0;
			for (int i=arg*blockSize;i<(arg+1)*blockSize;i++){
				ret[j] = memory[i];
				j++;
			}
		}
		return ret;
	}
	public void setBlock(int arg, byte[][] block){
		if ((arg>=0)&&(arg<=memory.length/blockSize)){
			int j = 0;
			System.out.println(arg);
			for (int i=arg*blockSize;i<(arg+1)*(blockSize);i++){
				this.setWord(i, block[j]);
				j++;
			}
		}
	}
	
	public byte[][] getMemory(){
		return memory;
	}
	public void print(){
		for (int i=0;i<memory.length;i++){
			System.out.print(i+": ");
			for(int j=0;j<memory[i].length;j++){
				System.out.print(memory[i][j]+" ");
			}
			System.out.println();
		}
	}
}

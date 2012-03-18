
public class Paging {
	public int convertRMAddress(RealMemory memory, byte[] PTR, byte[] addr){
		if ((PTR[1]-1)<=addr[0]){
			return -1;
		}
		byte[] block = memory.getWord(PTR[2]*16+PTR[3]+addr[0]);
		if (block != null){
			return block[0]*16 + addr[1];
		}
		return -1;
	}
}
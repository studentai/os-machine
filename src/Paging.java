
public class Paging {
	public int convertRMAddress(RealMemory memory, byte[] PTR, byte[] addr){
		byte[] block = memory.getWord(PTR[2]*16+PTR[3]+addr[0]);
		if (block != null){
			return block[0]*16 + addr[1];
		}
		return 0;
	}
}
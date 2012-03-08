
public class Paging {
	public int convertRMAddress(RealMemory memory, byte[] PTR, byte[] addr){
		byte[] block = memory.getWord(PTR[2]*16+PTR[3]+addr[1]);
		if (block != null){
			return block[1]*16 + addr[2];
		}
		return 0;
	}
}
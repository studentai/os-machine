//str.getBytes(0, str.length(), b, 0);

public class Converter {
	
	private char[] hexValuesCaps = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	private char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	public char ByteToChar(byte arg){
		return (char) arg;
	}
	
	public String BytesToString(byte[] arg){
		String ret = "";
		for (int i=0;i<arg.length;i++){
			ret = ret + (char)arg[i];
		}
		return ret;
	}
	
	public byte HexCharToByte(char arg){
		byte ret = 0;
		for(int i=0;i<hexValues.length;i++){
			if ((arg == hexValues[i]) || (arg == hexValuesCaps[i])){
				ret = (byte) i;
			}
		}
		return ret;
	}
	
	public boolean isHex(char arg){
		boolean ret = false;
		for(int i=0;i<hexValues.length;i++){
			if ((arg == hexValues[i]) || (arg == hexValuesCaps[i])){
				ret = true;
			}
		}
		return ret;
	}
}

//str.getBytes(0, str.length(), b, 0);
public class Converter {
	
	private static char[] hexValuesCaps = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	private static char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	public static char ByteToChar(byte arg){
		return (char) arg;
	}
	
	public static String BytesToString(byte[] arg){
		String ret = "";
		for (int i=0;i<arg.length;i++){
			ret = ret + (char)arg[i];
		}
		return ret;
	}
	
	public static byte HexCharToByte(char arg){
		byte ret = 0;
		for(int i=0;i<hexValues.length;i++){
			if ((arg == hexValues[i]) || (arg == hexValuesCaps[i])){
				ret = (byte) i;
			}
		}
		return ret;
	}
	
	public static boolean isHex(char arg){
		boolean ret = false;
		for(int i=0;i<hexValues.length;i++){
			if ((arg == hexValues[i]) || (arg == hexValuesCaps[i])){
				ret = true;
			}
		}
		return ret;
	}
	//eliga
	public static int byteToInt(byte arg){
		if((arg >=0)&&(arg<=127)){
			return arg;
		}
		return -arg+127;
	}
	
	public static int byteArrayToInt(byte[] arg){
		String tmp = "";
		String value = "";
		for(int i = 0; i< arg.length; i++){
			tmp = Integer.toBinaryString(arg[i]);
			for (int j=tmp.length();j<8;j++){
				tmp = "0"+tmp;
			}
			value = value + tmp;
		}
		return Integer.parseInt(value, 2);
	}
	
}

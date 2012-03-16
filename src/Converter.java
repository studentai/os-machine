import java.math.BigInteger;

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
		return (256-(-arg));
	}
	
	public static long byteArrayToInt(byte[] arg){
		String tmp = "";
		String value = "";
		for(int i = 0; i < arg.length; i++){
			tmp = Integer.toBinaryString(byteToInt(arg[i]));
			System.out.println(tmp);
			for (int j=tmp.length();j<8;j++){
				tmp = "0"+tmp;
			}
			value = value + tmp;
		}
		return Long.parseLong(value, 2);
	}
	public static String longToBinaryString(long arg){
		String tmp = "";
		return tmp; /////////NEPADARYTA
	}
	public static byte[] stringToWord(String value){
		if (value.length() >= 4*8){
			byte[] ret = new byte[4];
			String tmp;
			for (int i=0;i<4;i++){
				tmp = value.substring(i*8, (i+1)*8);
				ret[i] = (byte) new BigInteger(tmp, 2).intValue();
			}
			return ret;
		} else {
			return null;
		}
	}
}

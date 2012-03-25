import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


public class RealMachine {


	private static int maxMachineSize = 16;
	private static int maxMachineCount = 3;
	
	private static boolean[] isMemoryUsed;
	
	private GUI gui;

    private byte[] IC;     	 										// komandu skaitiklio registras
    private byte SF; 												// status flag (!3 baitas Loginis C registras!)
    private byte[] SM; 												// semaforo registras
    private byte[] P;  												// bendro naudojimo registras
    private byte[] R;												// bendro naudojimo registras
    private byte PI;												// programiniu pertraukimu registras
    private byte SI;												// sisteminiu pertraukimu registras
    private byte TI;												// taimerio registras
    private byte chnl;
    private byte MODE;												// procesoriaus darbo busenos registras
    private RealMemory realMemory;
    private VirtualMachine activeVirtualMachine;
    private LinkedList<VirtualMachine> virtualMachines;
    private byte[] PTR;												// puslapiavimo registras
    private Paging paging;
    private Channel1 channel1;										
    private Channel2 channel2;										
    private Channel3 channel3;									
    
    private String error;

    public RealMachine(GUI gui)
    {
    	this.gui = gui;
        this.setIC(new byte[2]);
        this.setChnl((byte) 0);
        this.setSF((byte) 0);
        this.setSM(new byte[2]);
        this.setP(new byte[4]);
        this.setR(new byte[4]);
        this.setPTR(new byte[4]);
        this.setPI((byte) 0);
        this.setSI((byte) 0);
        this.setTI((byte) 0);
        this.setMODE((byte) 0);         
        this.setRealMemory(new RealMemory());
        this.setVirtualMachines(new LinkedList<VirtualMachine>());
        this.setActiveVirtualMachine(null);
        this.setPaging(new Paging());
        this.setError("");
        this.setChannel1(new Channel1());
        this.setChannel2(new Channel2());
        this.setChannel3(new Channel3());
        
        isMemoryUsed = new boolean[64];
    }
    public void executeNextCommand(){
    	gui.disablePlay();
    	byte[] word = realMemory.getWord(paging.convertRMAddress(realMemory, PTR, IC));
    	if (IC[1] >= 15){
    		IC[0]++;
    		IC[1] = 0;
    	} else {
    		IC[1]++;
    	}
    	if (IC[0] >= (PTR[1]-1)){
    		word = new byte[]{72, 65, 76, 84};
    	}
    	boolean isLeggit = false;
    	//System.out.println(word[0]+" "+word[1]+" "+word[2]+" "+word[3]+"   "+paging.convertRMAddress(realMemory, PTR, IC));
    	//FOUR BYTES
    	if ((word[0]==78)&&(word[1]==79)&&(word[2]==84)&&(word[3]==82)){
    		//NOTR
    		isLeggit = true;
    		System.out.println("NOTR");
    		NOTR();
    	}
    	if ((word[0]==77)&&(word[1]==86)&&(word[2]==80)&&(word[3]==82)){
    		//MVPR
    		isLeggit = true;
    		System.out.println("MVPR");
    		MVPR();
    	}
    	if ((word[0]==77)&&(word[1]==86)&&(word[2]==82)&&(word[3]==80)){
    		//MVRP
    		isLeggit = true;
    		System.out.println("MVRP");
    		MVRP();
    	}
    	if ((word[0]==72)&&(word[1]==65)&&(word[2]==76)&&(word[3]==84)){
    		//HALT
    		isLeggit = true;
    		System.out.println("HALT");
    		HALT();
    		gui.disablePlay();
    	}
    	//TWO BYTES
    	//Aritmetinës
    	if ((word[0]==65)&&(word[1]==68)){
    		//AD
    		System.out.println("AD");
    		isLeggit = true;
    		AD(word);
    	}
    	if ((word[0]==83)&&(word[1]==66)){
    		//SB
    		System.out.println("SB");
    		isLeggit = true;
    		SB(word);
    	}
    	if ((word[0]==67)&&(word[1]==80)){
    		//CP
    		System.out.println("CP");
    		isLeggit = true;
    		CP(word);
    	}
    	if ((word[0]==68)&&(word[1]==86)){
    		//DV
    		System.out.println("DV");
    		isLeggit = true;
    		DV(word);
    	}

    	//Valdymo perdavimo
    	if ((word[0]==74)&&(word[1]==80)){
    		//JP
    		System.out.println("JP");
    		isLeggit = true;
    		JP(word);
    	}
    	if ((word[0]==74)&&(word[1]==69)){
    		//JE
    		System.out.println("JE");
    		isLeggit = true;
    		JE(word);
    	}
    	if ((word[0]==74)&&(word[1]==71)){
    		//JG
    		System.out.println("JG");
    		isLeggit = true;
    		JG(word);
    	}
    	if ((word[0]==74)&&(word[1]==61)){
    		//JB
    		System.out.println("JB");
    		isLeggit = true;
    		JB(word);
    	}
    	//Logines ir ciklas
    	
    	if ((word[0]==65)&&(word[1]==78)){
    		//AN
    		System.out.println("AN");
    		isLeggit = true;
    		AN(word);
    	}
    	if ((word[0]==79)&&(word[1]==82)){
    		//OR
    		System.out.println("OR");
    		isLeggit = true;
    		OR(word);
    	}
    	if ((word[0]==76)&&(word[1]==80)){
    		//LP
    		System.out.println("LP");
    		isLeggit = true;
    		LP(word);
    	}
    	//Mov'ai
    	if ((word[0]==77)&&(word[1]==82)){
    		//MR
    		System.out.println("MR");
    		isLeggit = true;
    		MR(word);
    	}
    	if ((word[0]==82)&&(word[1]==77)){
    		//RM
    		System.out.println("RM");
    		isLeggit = true;
    		RM(word);
    	}
    	//Atmintis ir kanalai
    	if ((word[0]==71)&&(word[1]==68)){
    		//GD
    		System.out.println("GD");
    		gui.readString(word);
    		isLeggit = true;
    	}
    	if ((word[0]==80)&&(word[1]==68)){
    		//PD
    		System.out.println("PD");
    		PD(word);
    		isLeggit = true;
    	}
    	if ((word[0]==76)&&(word[1]==82)){
    		//LR
    		System.out.println("LR");
    		isLeggit = true;
    		LR(word);
    	}
    	if ((word[0]==83)&&(word[1]==82)){
    		//SR
    		System.out.println("SR");
    		isLeggit = true;
    		SR(word);
    	}
    	if ((word[0]==76)&&(word[1]==75)){
    		//LK
    		System.out.println("LK");
    		isLeggit = true;
    		LK(word);
    	}
    	if ((word[0]==78)&&(word[1]==75)){
    		//NK
    		System.out.println("NK");
    		isLeggit = true;
    		NK(word);
    	}
    	TI = (byte) (Converter.byteToInt(TI) - 1);
    	if ((PI != 0) || (SI != 0) || (Converter.byteToInt(TI) == 0)){
    			MODE = 1;	
    	        Timer timer = new Timer();
    	        timer.schedule(new RemindTask(), 2000);
    	} else {
    		gui.enablePlay();
    	}
    }
    class RemindTask extends TimerTask {
        public void run() {
        	endCommand();//Terminate the timer thread
        }
    }
    public void endCommand(){
    	MODE = 0;
		PI = 0;
		SI = 0;
		if (Converter.byteToInt(TI) == 0){
			TI = (byte) 255;
		}
		gui.updateGUI();
		gui.enablePlay();
    }
    public void GD(byte[]cmd, byte[][] block){
    	byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), 0};
    	int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
    	if (realAddr > -1){
    		realMemory.setBlock(realAddr/16, block);
    	}else{
    		PI = 2;
    	}
    }
    public void PD(byte[]cmd){
    	byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), 0};
    	int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
    	if (realAddr > -1){
    		gui.printString(realMemory.getBlock(realAddr/16));
    	}else{
    		PI = 2;
    	}	
    }
    public void JP(byte[] cmd){
    	byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])};
    	int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
    	if (realAddr > -1){
    		IC = addr;
    	}else{
    		PI = 2;
    	}
    }
    public void JE(byte[] cmd){
    	byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])};
    	int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
    	if (realAddr > -1){
			String bits = Integer.toBinaryString(Converter.byteToInt(SF));
			for (int j=bits.length();j<8;j++){
				bits = "0"+bits;
			}
    		if (bits.charAt(2) == '0'){
    			IC = addr;
    		}
    	}else{
    		PI = 2;
    	}
    }
    public void JB(byte[] cmd){
    	byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])};
    	int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
    	if (realAddr > -1){
			String bits = Integer.toBinaryString(Converter.byteToInt(SF));
			for (int j=bits.length();j<8;j++){
				bits = "0"+bits;
			}
    		if ((bits.charAt(2) == '1') && (bits.charAt(6) == '0')){
    			IC = addr;
    		}
    	}else{
    		PI = 2;
    	}
    }
    public void JG(byte[] cmd){
    	byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])};
    	int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
    	if (realAddr > -1){
			String bits = Integer.toBinaryString(Converter.byteToInt(SF));
			for (int j=bits.length();j<8;j++){
				bits = "0"+bits;
			}
    		if ((bits.charAt(2) == '1') && (bits.charAt(6) == '1')){
    			IC = addr;
    		}
    	}else{
    		PI = 2;
    	}
    }
    public void CP(byte[] cmd){
    	byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])};
    	int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
    	if (realAddr > -1){
        	byte[] word = realMemory.getWord(realAddr);
        	long wordInt = Converter.byteArrayToInt(word);
        	long RInt = Converter.byteArrayToInt(R);
        	System.out.println(wordInt+" "+RInt);
        	if (wordInt == RInt){
        		changeFlag('0', 2);
        	}
        	if (wordInt> RInt){
        		changeFlag('1', 2);
        		changeFlag('1', 6);
        	}
        	if (wordInt < RInt){
        		changeFlag('1', 2);
        		changeFlag('0', 6);
        	}
    	}
    	else {
    		PI = 2;
    	}
    }
    public void HALT(){
    	SI = 5;
    	error = "Baigiama programa"; //Ne klaida tiesiog baigiasi programa
    }
    public void NOTR(){
		String tmp = "";
		String value = "";
		for(int i = 0; i < R.length; i++){
			tmp = Integer.toBinaryString(Converter.byteToInt(R[i]));//PERKELT Y KONVERTERI WORDTOSTRING
			System.out.println(tmp);
			for (int j=tmp.length();j<8;j++){
				tmp = "0"+tmp;
			}
			value = value + tmp;
		}
		char[] array = value.toCharArray();
		value = "";
		boolean isSubed = false;
		for (int i = array.length-1;i>=0;i--){
			if (array[i] == '0'){
				if (isSubed){
					array[i] = '1';
				}
			} else {
				if (isSubed){
					array[i] = '0';
				} else {
					array[i] = '1';
					isSubed = true;
				}
			}
			value = array[i] + value;
		}
		R = (Converter.stringToWord(value));
		if (isSubed == false){
			//Ivyko perkelimas nustatom CF
			changeFlag('1', 3);
		} else {
			changeFlag('0', 3);
		}
    }
    public void AN(byte[] cmd){
		byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])};
		int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
		if (realAddr > -1){
        	byte[] word = realMemory.getWord(realAddr);	
	    	String regValue = Converter.wordToString(R);
			char[] regArray = regValue.toCharArray();
			char[] wordArray = Converter.wordToString(word).toCharArray();
			regValue = "";
			for (int i = 0;i<regArray.length;i++){
				if ((regArray[i] == '1') && (wordArray[i] == '1')){
					regValue = regValue + '1';
				} else {
					regValue = regValue + '0';
				}
			}
			R = Converter.stringToWord(regValue);
		} else {
			PI = 2;
		}
    }   
    public void OR(byte[] cmd){
		byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])};
		int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
		if (realAddr > -1){
        	byte[] word = realMemory.getWord(realAddr);	
	    	String regValue = Converter.wordToString(R);
			char[] regArray = regValue.toCharArray();
			char[] wordArray = Converter.wordToString(word).toCharArray();
			regValue = "";
			System.out.println(regValue+" OR "+Converter.wordToString(word));
			for (int i = 0;i<regArray.length;i++){
				if ((regArray[i] == '1') || (wordArray[i] == '1')){
					regValue = regValue + '1';
				} else {
					regValue = regValue + '0';
				}
			}
			setR(Converter.stringToWord(regValue));
		} else {
			PI = 2;
		}
    }  
	public void LP(byte[] cmd){
		long count = Converter.byteArrayToInt(P);
		if (count > 0){
			count--;
			JP(cmd);
			String pString = Converter.longToBinaryWord(count);
			P = Converter.stringToWord(pString);
		}
	}
	public void MR (byte[] cmd){
		 byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])}; 
		 int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
		 if (realAddr > -1){
			 realMemory.setWord(realAddr, R);
		 }else{
			 PI = 2;
		 }
	}
	public void RM (byte[] cmd){
		 byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])}; 
		 int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
		 if (realAddr > -1){
			 setR(realMemory.getWord(realAddr));
		 } else{
			 PI = 2;
		 }
	}
	public void MVRP(){
		setP(R);
	}
	public void MVPR(){		
		setR(P);
	}	
	public void AD(byte[] cmd){
		byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])}; 
		int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
		if (realAddr > -1){	
			byte[] word = realMemory.getWord(realAddr);
			long wordInt = Converter.byteArrayToInt(word);
	    	long RInt = Converter.byteArrayToInt(R);
	    	long sum = wordInt+RInt;
	    	if (Converter.longToBinaryWord(sum).length() > 32){
	    		changeFlag('1', 3); //Nustatome carryFlag
	    		long max = Converter.byteArrayToInt(new byte[]{(byte)255, (byte)255, (byte)255, (byte)255});
	    		sum = (sum - max) - 1;
	    	} else {
	    		changeFlag('0', 3);
	    	}
	    	R = Converter.stringToWord(Converter.longToBinaryWord(sum));
	    	System.out.println(wordInt+ " + " + RInt + " " + Converter.longToBinaryWord(RInt)+ " " + "=" + (RInt+wordInt) + " OR " + Converter.longToBinaryWord(sum));
		}else {
			PI = 2;
		}
	}
	public void SB(byte[] cmd){
		byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])}; 
		int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
		if (realAddr > -1){	
			byte[] word = realMemory.getWord(realAddr);
			long wordInt = Converter.byteArrayToInt(word);
	    	long RInt = Converter.byteArrayToInt(R);
	    	long sub = 0;
	    	if (RInt < wordInt){
	    		changeFlag('1', 3); //Nustatome carryFlag
	    		long max = Converter.byteArrayToInt(new byte[]{(byte)255, (byte)255, (byte)255, (byte)255});
	    		sub = wordInt - RInt;
	    		sub = (max - sub) + 1;
	    	} else {
	    		changeFlag('0', 3);
	    		sub = RInt - wordInt;
	    	}
	    	R = Converter.stringToWord(Converter.longToBinaryWord(sub));
		}else {
			PI = 2;
		}
	}
	public void DV(byte[] cmd){
		byte[] addr = new byte[]{Converter.HexCharToByte((char)cmd[2]), Converter.HexCharToByte((char)cmd[3])}; 
		int realAddr = paging.convertRMAddress(realMemory, PTR, addr);
		if (realAddr > -1){	
			byte[] word = realMemory.getWord(realAddr);
			long wordInt = Converter.byteArrayToInt(word);
	    	long RInt = Converter.byteArrayToInt(R);
	    	if (wordInt == 0){
	    		changeFlag('1', 4); //Nustatome zeroFlag
	    	} else {
	    		changeFlag('0', 4);
	    		long div = RInt/wordInt;
	    		long mod = RInt%wordInt;
	    		R = Converter.stringToWord(Converter.longToBinaryWord(div));
	    		P = Converter.stringToWord(Converter.longToBinaryWord(mod));
	    	}
		}else {
			PI = 2;
		}
	}
	public void LK(byte[] word){
		SI = 3;
		int num = Converter.byteToInt(Converter.HexCharToByte((char)word[2]));
		if (Converter.isHex((char)word[2])){
			this.changeSM('1', num);
		} else{
			PI = 2;
		}
	}
	public void NK(byte[] word){
		SI = 4;
		int num = Converter.byteToInt(Converter.HexCharToByte((char)word[2]));
		if (Converter.isHex((char)word[2])){
			this.changeSM('0', num);
		} else{
			PI = 2;
		}
	}
	
	public void LR(byte[] word){
		int blockNum = Converter.byteToInt(Converter.HexCharToByte((char)word[2]));
		String SMString = Converter.wordToString(SM);
		if (SMString.charAt(blockNum) == '1'){
			byte[] mem = realMemory.getWord(blockNum*16 + Converter.byteToInt(Converter.HexCharToByte((char)word[3])));
			setR(mem.clone());
		} else {
			PI = 2;
		}
	}
	public void SR(byte[] word){
		int blockNum = Converter.byteToInt(Converter.HexCharToByte((char)word[2]));
		String SMString = Converter.wordToString(SM);
		if (SMString.charAt(blockNum) == '1'){
			 realMemory.setWord(blockNum*16 + Converter.byteToInt(Converter.HexCharToByte((char)word[3])), R);
		} else {
			PI = 2;
		}
	}
	
	
    public byte[] getIC() {return IC;}
	public void setIC(byte[] IC) {this.IC = IC;}
	public byte getSF() {return SF;}
	public void setSF(byte SF) {this.SF = SF;}
	public byte[] getSM() {return SM;}
	public void setSM(byte[] SM) {this.SM = SM;}
	public byte[] getP() {return P;}
	public void setP(byte[] P) {this.P = P;}
	public byte[] getR() {return R;}
	public void setR(byte[] R) {this.R = R;}
	public byte getPI() {return PI;}
	public void setPI(byte PI) {this.PI = PI;}
	public byte getSI() {return SI;}
	public void setSI(byte SI) {this.SI = SI;}
	public byte getTI() {return TI;}
	public void setTI(byte TI) {this.TI = TI;}
	public byte getMODE() {return MODE;}
	public void setMODE(byte MODE) {this.MODE = MODE;}
	public byte[] getPTR() {return PTR;}
	public void setPTR(byte[] PTR) {this.PTR = PTR;}
	public Channel1 getChannel1() {return channel1;}
	public void setChannel1(Channel1 channel1) {this.channel1 = channel1;}
	public Channel2 getChannel2() {return channel2;}
	public void setChannel2(Channel2 channel2) {this.channel2 = channel2;}
	public String getError() {return error;}
	public void setError(String error) {this.error = error;}
	public RealMemory getRealMemory() {return realMemory;}
	public void setRealMemory(RealMemory realMemory) {this.realMemory = realMemory;}
	public VirtualMachine getActiveVirtualMachine() {return activeVirtualMachine;}
	public void setActiveVirtualMachine(VirtualMachine activeVirtualMachine) {this.activeVirtualMachine = activeVirtualMachine;}
	public LinkedList<VirtualMachine> getVirtualMachines() {return virtualMachines;}
	public void setVirtualMachines(LinkedList<VirtualMachine> virtualMachines) {this.virtualMachines = virtualMachines;}
	public Paging getPaging() {	return paging;}
	public void setPaging(Paging paging) {this.paging = paging;}
	public Channel3 getChannel3() {return channel3;}
	public void setChannel3(Channel3 channel3) {this.channel3 = channel3;}
	
	public int randomAdrress(){
		int randomAddress = 0;
		boolean used = true;
		while (used) {
			used = false;
			int min = 16+maxMachineCount;
			int max = 63;
			randomAddress = min + (int)(Math.random() * ((max - min) + 1));
			if (isMemoryUsed[randomAddress]){
				used = true;
			} else{
				isMemoryUsed[randomAddress] = true;
				return randomAddress;
			}
		}
		return -1;
	}
	public int freeMemoryCount(){
		int count = 0;
		for (int i=16;i<isMemoryUsed.length;i++){
			if (!isMemoryUsed[i]){
				count++;
			}
		}
		return count;
	}
	
    public boolean registerNewVirtualmachine(byte[][] program, int size){
    	if (size > freeMemoryCount()){
    		return false;
    		//NEPAKANKA ATMINTIES
    	} else {
    		VirtualMachine newMachine = new VirtualMachine();
    		virtualMachines.add(newMachine);
    		int pageBlockAddress = randomAdrress();
    		int pageTableAddress = pageBlockAddress*16;
    		for (int i=0;i<size-1;i++){
    			int randomAddress = randomAdrress();
    			byte[] addr = new byte[4];
    			addr[0] = (byte) randomAddress;
    			addr[1] = 0;
    			addr[2] = 0;
    			addr[3] = 0;
    			realMemory.setWord(pageTableAddress, addr);
    			byte[][] block = new byte[16][4];
    			for (int j=0;j<block.length;j++){
    				block[j]=program[i*16+j];
    			}
    			realMemory.setBlock(randomAddress, block);
    			pageTableAddress = pageTableAddress + 1;
    		}
    		resetRegisters();
    		byte[] addr = new byte[4];
    		addr[0] = 16;
    		addr[1] = (byte) size;
    		addr[2] = (byte) pageBlockAddress;
    		addr[3] = 0;
    		this.setPTR(addr);
    		addr = new byte[2];
    		addr[0] = 0;
    		addr[1] = 0;
    		this.setIC(addr);
    		return true;	
    	}
    	//}
    }
    private void resetRegisters(){
    	byte[] two = new byte[2];
    	two[0] = 0;
    	two[1] = 0;
    	byte[] four = new byte[4];
    	four[0] = 0;
    	four[1] = 0;
    	four[2] = 0;
    	four[3] = 0;
    	this.setR(four);
    	four = new byte[4];
    	four[0] = 0;
    	four[1] = 0;
    	four[2] = 0;
    	four[3] = 0;
    	this.setP(four);
        this.setIC(two);
        this.setSF((byte) 0);
        this.setSM(two);
        this.setPTR(four);
        this.setPI((byte) 0);
        this.setSI((byte) 0);
        this.setTI((byte) 255);
        this.setMODE((byte) 0);
    }
	public byte getChnl() {return chnl;}
	public void setChnl(byte chnl) {this.chnl = chnl;}
	
	public void changeFlag(char value, int number){
		if((number <= 7) && (number >=0)){
			String bits = Integer.toBinaryString(Converter.byteToInt(SF));
			for (int j=bits.length();j<8;j++){
				bits = "0"+bits;
			}
			char[] tmp = bits.toCharArray();
			tmp[number] = value;
			bits = "";
			for (int i = 0;i<tmp.length;i++){
				bits = bits + tmp[i];
			}
			SF = (byte) new BigInteger(bits, 2).intValue();
		}
	}
	public void changeSM(char value, int number){
		if((number <= 15) && (number >=0)){
			String bits = Converter.wordToString(SM);
			char[] tmp = bits.toCharArray();
			tmp[number] = value;
			bits = "0000000000000000";
			for (int i = 0;i<tmp.length;i++){
				bits = bits + tmp[i];
			}
			byte[] word = Converter.stringToWord(bits);
			SM = new byte[]{word[2], word[3]};
		}
	}
	
}
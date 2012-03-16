import java.math.BigInteger;
import java.util.LinkedList;


public class RealMachine {


	private static int maxMachineSize = 16;
	private static int maxMachineCount = 3;

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

    public RealMachine()
    {
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
    }
    public void executeNextCommand(){
    	byte[] word = realMemory.getWord(paging.convertRMAddress(realMemory, PTR, IC));
    	if (IC[1] >= 15){
    		IC[0]++;
    		IC[1] = 0;
    	} else {
    		IC[1]++;
    	}
    	boolean isLeggit = false;
    	System.out.println(word[0]+" "+word[1]+" "+word[2]+" "+word[3]+"   "+paging.convertRMAddress(realMemory, PTR, IC));
    	//FOUR BYTES
    	if ((word[0]==78)&&(word[1]==79)&&(word[2]==84)&&(word[3]==82)){
    		//NOTR
    		isLeggit = true;
    		System.out.println("NOTR");
    		NOTR();
    	}
    	if ((word[0]==77)&&(word[1]==86)&&(word[2]==82)&&(word[3]==80)){
    		//MVPR
    		isLeggit = true;
    		System.out.println("MVPR");
    	}
    	if ((word[0]==77)&&(word[1]==86)&&(word[2]==80)&&(word[3]==82)){
    		//MVRP
    		isLeggit = true;
    		System.out.println("MVRP");
    	}
    	if ((word[0]==72)&&(word[1]==65)&&(word[2]==76)&&(word[3]==84)){
    		//HALT
    		isLeggit = true;
    		System.out.println("HALT");
    		HALT();
    	}
    	//TWO BYTES
    	//Aritmetinës
    	if ((word[0]==65)&&(word[1]==68)){
    		//AD
    		System.out.println("AD");
    		isLeggit = true;
    	}
    	if ((word[0]==83)&&(word[1]==66)){
    		//SB
    		System.out.println("SB");
    		isLeggit = true;
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
    	}
    	if ((word[0]==74)&&(word[1]==61)){
    		//JB
    		System.out.println("JB");
    		isLeggit = true;
    	}
    	//Logines ir ciklas
    	
    	if ((word[0]==65)&&(word[1]==78)){
    		//AN
    		System.out.println("AN");
    		isLeggit = true;
    	}
    	if ((word[0]==81)&&(word[1]==81)){
    		//OR
    		System.out.println("OR");
    		isLeggit = true;
    	}
    	if ((word[0]==76)&&(word[1]==80)){
    		//LP
    		System.out.println("LP");
    		isLeggit = true;
    	}
    	//Mov'ai
    	if ((word[0]==77)&&(word[1]==82)){
    		//MR
    		System.out.println("MR");
    		isLeggit = true;
    	}
    	if ((word[0]==82)&&(word[1]==77)){
    		//RM
    		System.out.println("RM");
    		isLeggit = true;
    	}
    	//Atmintis ir kanalai
    	if ((word[0]==71)&&(word[1]==44)){
    		//GD
    		System.out.println("GD");
    		isLeggit = true;
    	}
    	if ((word[0]==80)&&(word[1]==68)){
    		//PD
    		System.out.println("PD");
    		isLeggit = true;
    	}
    	if ((word[0]==76)&&(word[1]==82)){
    		//LR
    		System.out.println("LR");
    		isLeggit = true;
    	}
    	if ((word[0]==83)&&(word[1]==82)){
    		//SR
    		System.out.println("SR");
    		isLeggit = true;
    	}
    	if ((word[0]==76)&&(word[1]==75)){
    		//LK
    		System.out.println("LK");
    		isLeggit = true;
    	}
    	if ((word[0]==78)&&(word[1]==75)){
    		//NK
    		System.out.println("NK");
    		isLeggit = true;
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
	
	
    public boolean registerNewVirtualmachine(byte[][] program, int size){
    	if ((size > maxMachineSize) && (size < 1) || (virtualMachines.size() >= maxMachineCount)){
    		return false;
    	} else {
    		VirtualMachine newMachine = new VirtualMachine();
    		virtualMachines.add(newMachine);
    		int pageTableAddress = (virtualMachines.size() + 15)*16;
    		for (int i=0;i<size-1;i++){
    			
    			int randomAddress = 0;
    			boolean used = true;
    			while (used) {
    				used = false;
    				int min = 16+maxMachineCount;
    				int max = 63;
    				randomAddress = min + (int)(Math.random() * ((max - min) + 1));
    				for (int j=0;j<virtualMachines.size();j++){  					
    					int tableAddress = (j + 16)*16;
    					for (int k=0;k<16;k++){
    						byte[] word = realMemory.getWord(tableAddress+k);
    						if (word[0] == randomAddress){
    							used = true;
    						}
    					}
    				}
    			}
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
			addr[2] = (byte) (virtualMachines.size() + 15);
			addr[3] = 0;
			this.setPTR(addr);
			addr = new byte[2];
			addr[0] = 0;
			addr[1] = 0;
			this.setIC(addr);
    		return true;
    	}
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
        this.setTI((byte) 127);
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
	
}
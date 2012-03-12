import java.util.LinkedList;


public class RealMachine {


	private static int maxMachineSize = 16;
	private static int maxMachineCount = 3;

    private byte[] IC;     	 										// komandu skaitiklio registras
    private byte[] SF; 												// status flag (!3 baitas Loginis C registras!)
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
        this.setSF(new byte[2]);
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
    	if (IC[1] == 15){
    		IC[0]++;
    		IC[1] = 0;
    	} else {
    		IC[1]++;
    	}
    	boolean isLeggit = false;
    	
    	//FOUR BYTES
    	if ((word[0]==78)&&(word[1]==79)&&(word[2]==84)&&(word[3]==82)){
    		//NOTR
    		isLeggit = true;
    		System.out.println("NOTR");
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
    	if ((word[0]==72)&&(word[1]==64)&&(word[2]==76)&&(word[3]==84)){
    		//HALT
    		isLeggit = true;
    		System.out.println("HALT");
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
    	}
    	if ((word[0]==74)&&(word[1]==69)){
    		//JE
    		System.out.println("JE");
    		isLeggit = true;
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
    	
//    	if ((word[0]==)&&(word[1]==)){
//    		//
//    		System.out.println("");
//    		isLeggit = true;
//    	}
    }
	public byte[] getIC() {
		return IC;
	}
	public void setIC(byte[] IC) {
		this.IC = IC;
	}
	public byte[] getSF() {
		return SF;
	}
	public void setSF(byte[] SF) {
		SF[0] = 10;
		SF[1] = 10;
		this.SF = SF;
	}
	public byte[] getSM() {
		return SM;
	}
	public void setSM(byte[] SM) {
		this.SM = SM;
	}
	public byte[] getP() {
		return P;
	}
	public void setP(byte[] P) {
		this.P = P;
	}
	public byte[] getR() {
		return R;
	}
	public void setR(byte[] R) {
		this.R = R;
	}
	public byte getPI() {
		return PI;
	}
	public void setPI(byte PI) {
		this.PI = PI;
	}
	public byte getSI() {
		return SI;
	}
	public void setSI(byte SI) {
		this.SI = SI;
	}
	public byte getTI() {
		return TI;
	}
	public void setTI(byte TI) {
		this.TI = TI;
	}
	public byte getMODE() {
		return MODE;
	}
	public void setMODE(byte MODE) {
		this.MODE = MODE;
	}
	public byte[] getPTR() {
		return PTR;
	}
	public void setPTR(byte[] PTR) {
		this.PTR = PTR;
	}
	public Channel1 getChannel1() {
		return channel1;
	}
	public void setChannel1(Channel1 channel1) {
		this.channel1 = channel1;
	}
	public Channel2 getChannel2() {
		return channel2;
	}
	public void setChannel2(Channel2 channel2) {
		this.channel2 = channel2;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public RealMemory getRealMemory() {
		return realMemory;
	}
	public void setRealMemory(RealMemory realMemory) {
		this.realMemory = realMemory;
	}
	public VirtualMachine getActiveVirtualMachine() {
		return activeVirtualMachine;
	}
	public void setActiveVirtualMachine(VirtualMachine activeVirtualMachine) {
		this.activeVirtualMachine = activeVirtualMachine;
	}
	public LinkedList<VirtualMachine> getVirtualMachines() {
		return virtualMachines;
	}
	public void setVirtualMachines(LinkedList<VirtualMachine> virtualMachines) {
		this.virtualMachines = virtualMachines;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	public Channel3 getChannel3() {
		return channel3;
	}
	public void setChannel3(Channel3 channel3) {
		this.channel3 = channel3;
	}
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
			addr[0] = 1;
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
        this.setIC(two);
        this.setSF(two);
        this.setSM(two);
        this.setP(four);
        this.setR(four);
        this.setPTR(four);
        this.setPI((byte) 0);
        this.setSI((byte) 0);
        this.setTI((byte) 127);
        this.setMODE((byte) 0);
    }
	public byte getChnl() {
		return chnl;
	}
	public void setChnl(byte chnl) {
		this.chnl = chnl;
	}
}
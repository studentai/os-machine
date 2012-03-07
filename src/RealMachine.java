
public class RealMachine {
	
    private byte[] IC;     	 										// komandu skaitiklio registras
    private byte[] SF; 												// status flag (!3 baitas Loginis C registras!)
    private byte[] SM; 												// semaforo registras
    private byte[] P;  												// bendro naudojimo registras
    private byte[] R;												// bendro naudojimo registras
    private byte PI;												// programiniu pertraukimu registras
    private byte SI;												// sisteminiu pertraukimu registras
    private byte TI;												// taimerio registras
    private byte MODE;												// procesoriaus darbo busenos registras
    //private RealMemory realMemory;
    //private VirtualMachine virtualMachine;
    private byte[] PTR;												// puslapiavimo registras
    //private Paging paging;
    private Channel1 channel1;										
    private Channel2 channel2;										
    //private Channel3 channel3;									
    
    private String error;

    public RealMachine()
    {
        this.setIC(new byte[2]);
        this.setSF(new byte[2]);
        this.setSM(new byte[2]);
        this.setP(new byte[4]);
        this.setR(new byte[4]);
        this.setPTR(new byte[4]);
        this.setPI((byte) 0);
        this.setSI((byte) 0);
        this.setTI((byte) 0);
        this.setMODE((byte) 0);         
        //this.realMemory;
        //this.virtualMachine = null;
        //this.paging = null;
        this.setError("");
        this.setChannel1(new Channel1());
        this.setChannel2(new Channel2());
        //this.channel3 = new Channel3();
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
    
}

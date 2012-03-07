
public class RealMachine {
	
    private byte[] IC;
    private byte[] SF;
    private byte[] SM;
    private byte[] P;
    private byte[] R;
    private byte PI;
    private byte SI;
    private byte TI;
    private byte MODE;
    private byte C;
    //private RealMemory realMemory;
    //private VirtualMachine virtualMachine;
    private byte[] PTR;
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
        this.setC((byte) 0);        
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

	public void setIC(byte[] iC) {
		IC = iC;
	}

	public byte[] getSF() {
		return SF;
	}

	public void setSF(byte[] sF) {
		SF = sF;
	}

	public byte[] getSM() {
		return SM;
	}

	public void setSM(byte[] sM) {
		SM = sM;
	}

	public byte[] getP() {
		return P;
	}

	public void setP(byte[] p) {
		P = p;
	}

	public byte[] getR() {
		return R;
	}

	public void setR(byte[] r) {
		R = r;
	}

	public byte getPI() {
		return PI;
	}

	public void setPI(byte pI) {
		PI = pI;
	}

	public byte getSI() {
		return SI;
	}

	public void setSI(byte sI) {
		SI = sI;
	}

	public byte getTI() {
		return TI;
	}

	public void setTI(byte tI) {
		TI = tI;
	}

	public byte getMODE() {
		return MODE;
	}

	public void setMODE(byte mODE) {
		MODE = mODE;
	}

	public byte[] getPTR() {
		return PTR;
	}

	public void setPTR(byte[] pTR) {
		PTR = pTR;
	}

	public byte getC() {
		return C;
	}

	public void setC(byte c) {
		C = c;
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

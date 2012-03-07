
public class VirtualMachine {
	private byte[] IC;     	 										// komandu skaitiklio registras
    private byte[] SF; 												// status flag (!3 baitas Loginis C registras!)
    private byte[] P;  												// bendro naudojimo registras
    private byte[] R;												// bendro naudojimo registras
    
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
    
    
}

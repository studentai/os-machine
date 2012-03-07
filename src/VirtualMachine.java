
public class VirtualMachine {
	private byte[] IC;     	 										// komandu skaitiklio registras
    private byte[] SF; 												// status flag (!3 baitas Loginis C registras!)
    private byte[] P;  												// bendro naudojimo registras
    private byte[] R;												// bendro naudojimo registras
	public byte[] getIC() {
		return IC;
	}
	public void setIC(byte[] iC) {
		IC = iC;
	}
    
    
}

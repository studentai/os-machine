
public class Main {
	public static void main(String[] args){
		//TEST DONT DELETE
		RealMachine realMachine = new RealMachine();
		byte[][] program = new byte[240][4];
		for (int i=0;i<program.length;i++){
			program[i][0] = (byte) (i/2+1);
			program[i][1] = (byte) (i/2+2);
			program[i][2] = (byte) (i/2+3);
			program[i][3] = (byte)  (i/2+4);
		}
		
		
		realMachine.registerNewVirtualmachine(program, 16);
		program = new byte[240][4];
		for (int i=0;i<program.length;i++){
			program[i][0] = (byte) (i/3+1);
			program[i][1] = (byte) (i/3+2);
			program[i][2] = (byte) (i/3+3);
			program[i][3] = (byte)  (i/3+4);
		}
		
		
		realMachine.registerNewVirtualmachine(program, 16);
		program = new byte[240][4];
		for (int i=0;i<program.length;i++){
			program[i][0] = (byte) (i/4+1);
			program[i][1] = (byte) (i/4+2);
			program[i][2] = (byte) (i/4+3);
			program[i][3] = (byte)  (i/4+4);
		}
		
		
		realMachine.registerNewVirtualmachine(program, 16);


		program = new byte[32][4];
		for (int i=0;i<program.length;i++){
			program[i][0] = (byte) (i+1);
			program[i][1] = (byte) (i+2);
			program[i][2] = (byte) (i+3);
			program[i][3] = (byte)  (i+4);
		}
		
		
		realMachine.registerNewVirtualmachine(program, 3);
		
		realMachine.getRealMemory().print();
		//
	}
}

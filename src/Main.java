import javax.swing.SwingUtilities;

public class Main {
	
	//Sunumeruoju realios atminties zodziu numerius lentelej
	public static void setRealMemoryValues(int size){
		GUI.values = new Integer[size][2];
		for(int i = 0; i<size;i++){
			GUI.values[i][0] =(Integer) i;
			GUI.values[i][1] =(Integer) 0;
		}
	}
	//sunumeruoja virtualios atminties zodziu numerius lentelei
	public static void setVirtualMemoryValues(int size){
		GUI.values2 = new Integer[size][2];
		for(int i = 0; i < size; i++){
			GUI.values2[i][0] = (Integer) i;
			GUI.values2[i][1] = (Integer) 0;
		}
	}
	
	public static void main(String[] args){
		
		//GUI----------------------------------------
		setRealMemoryValues(1024);
		setVirtualMemoryValues(256);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI frame = new GUI();
				frame.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
				frame.setTitle("GUI");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		//GUI---------------------------------------
		
		
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


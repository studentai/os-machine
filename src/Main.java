import javax.swing.SwingUtilities;

public class Main {

	//Sunumeruoju realios atminties zodziu numerius lentelej
	private static GUI gui;
	private static RealMachine realMachine;
	public static void setRealMemoryValues(int size){
		GUI.values = new String[size][5];
		String adress;
		for(int i = 0; i<size;i++){
			adress = String.valueOf(i);
			switch(adress.length()){
			case 1: adress = "000"+adress;
				break;
			case 2: adress = "00"+adress;
				break;
			case 3: adress = "0"+adress;
				break;
			}
			GUI.values[i][0] = adress;
			GUI.values[i][1] = String.valueOf(0);
			GUI.values[i][2] = String.valueOf(0);
			GUI.values[i][3] = String.valueOf(0);
			GUI.values[i][4] = String.valueOf(0);
		}
	}
	//sunumeruoja virtualios atminties zodziu numerius lentelei

	public static void main(String[] args){
<<<<<<< HEAD

=======
		
>>>>>>> 5f95153bb0824c1de178d6190a1dd771be6e631f

		//TEST DONT DELETE
	     realMachine = new RealMachine();
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
<<<<<<< HEAD

		realMachine.registerNewVirtualmachine(program, 3);

=======
		
		realMachine.registerNewVirtualmachine(program, 3);
		
>>>>>>> 5f95153bb0824c1de178d6190a1dd771be6e631f
		//GUI----------------------------------------
				setRealMemoryValues(1024);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						gui = new GUI();
						gui.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
						gui.setTitle("GUI");
						gui.getContentPane().setPreferredSize(gui.getSize());
						gui.pack();
						gui.setLocationRelativeTo(null);
						gui.setVisible(true);
						gui.setRealMachine(realMachine);
						gui.updateRegistersValues();
						gui.updateRealMemory();
						gui.updateFlags();
					}
				});
				//GUI---------------------------------------
<<<<<<< HEAD



=======
		
		
		
>>>>>>> 5f95153bb0824c1de178d6190a1dd771be6e631f
		realMachine.getRealMemory().print();
		//
	}
}

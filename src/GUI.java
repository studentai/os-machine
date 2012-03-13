import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

//bbzn
//VS4E -- DO NOT REMOVE THIS LINE!
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton loadVMButton;
	private JButton playButton;
	private JButton stepButton;
	private JButton changeRegistersButton;
	private JButton changeMemoryButton;

	private JTable realMemoryTable;
	private JTable registersTable;
	private JTable flagsTable;
	private JTable commandsTable;

	private JScrollPane jScrollPane0;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane5;
	private JLabel jLabel0;

	public static String[][] values;
	public static Integer[][] values2;
	public static String[][] values3;
	private BufferedReader file;

	private JTextArea jTextArea0;
	private JFrame framek;
	private JFrame frameks;
	private JFrame frame2;
	private JButton okButton;

	private RealMachine realMachine;
	private JTextField jTextField6;
	private JLabel jLabel3;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField5;
	private JLabel jLabel4;
	private JPanel jPanel2;
	private JPanel jPanel0;
	private JLabel jLabel1;
	private JTextField jTextField0;
	private JButton jButton6;
	private JComboBox<String> jComboBox0;
	private JPanel jPanel3;
	private JTextField jTextFieldA;
	private JTextField jTextFieldB;
	private JTextField jTextFieldC;
	private JTextField jTextFieldD;
	private JButton jButton7;
	private ListSelectionModel selectionModel;

	public GUI() {
		initComponents();
	}

	public void setRealMachine(RealMachine realMachine){
		this.realMachine = realMachine;
	}

	public RealMachine getRealMachine(){
		return realMachine;
	}

	public void updateRegistersValues(){

		for(int i = 0; i<4; i++){
			registersTable.setValueAt(realMachine.getPTR()[i], 0, i+1);
			registersTable.setValueAt(realMachine.getR()[i], 1, i+1);
			registersTable.setValueAt(realMachine.getP()[i], 2, i+1);
		}
		for(int i = 0; i < 2; i++){
			registersTable.setValueAt(realMachine.getIC()[i], 3, i+1);
			registersTable.setValueAt(realMachine.getSF(), 4, i+1);
			registersTable.setValueAt(realMachine.getSM()[i], 5, i+1);
		}

		registersTable.setValueAt(realMachine.getPI(), 6, 1);
		registersTable.setValueAt(realMachine.getSI(), 7, 1);
		registersTable.setValueAt(realMachine.getChnl(), 8, 1);

	}

	public void updateRealMemory(){
		byte[][] memory = realMachine.getRealMemory().getMemory();
		for(int i = 0; i<memory.length; i++){
			realMemoryTable.setValueAt(memory[i][0], i, 1);
			realMemoryTable.setValueAt(memory[i][1], i, 2);
			realMemoryTable.setValueAt(memory[i][2], i, 3);
			realMemoryTable.setValueAt(memory[i][3], i, 4);
		}
	}

	public void updateFlags(){
		byte flag = realMachine.getSF();
		String firstByte = Integer.toBinaryString(Converter.byteToInt(flag));
	
	
		for (int j=firstByte.length();j<8;j++){
			firstByte = "0"+firstByte;
		}

		char[] charsArray = firstByte.toCharArray();
		for(int i = 0; i<firstByte.length(); i++){
			flagsTable.setValueAt(charsArray[i], i, 1);
		}

	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJButton0(), new Constraints(new Leading(8, 10, 10), new Leading(8, 10, 10)));
		add(getJButton2(), new Constraints(new Leading(8, 12, 12), new Leading(77, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(563, 12, 12), new Leading(159, 10, 10)));
		add(getJScrollPane3(), new Constraints(new Leading(707, 58, 10, 10), new Leading(6, 136, 12, 12)));
		add(getJButton1(), new Constraints(new Leading(8, 80, 12, 12), new Leading(43, 10, 10)));
		add(getJScrollPane4(), new Constraints(new Leading(232, 200, 10, 10), new Leading(8, 361, 12, 12)));
		add(getJButton3(), new Constraints(new Leading(8, 12, 12), new Leading(470, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(563, 200, 10, 10), new Leading(177, 319, 12, 12)));
		add(getJScrollPane5(), new Constraints(new Leading(233, 198, 12, 12), new Leading(386, 110, 12, 12)));
		add(getJButton4(), new Constraints(new Leading(8, 120, 12, 12), new Leading(432, 12, 12)));
		add(getJScrollPane2(), new Constraints(new Leading(535, 156, 10, 10), new Leading(6, 132, 12, 12)));
		setSize(775, 513);
	}

	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setText("Gerai");
			jButton7.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButton7ActionActionPerformed(event);
				}
			});
		}
		return jButton7;
	}

	private JTextField getJTextFieldD() {
		if (jTextFieldD == null) {
			jTextFieldD = new JTextField();
			jTextFieldD.setText("");
		}
		return jTextFieldD;
	}

	private JTextField getJTextFieldC() {
		if (jTextFieldC == null) {
			jTextFieldC = new JTextField();
			jTextFieldC.setText("");
		}
		return jTextFieldC;
	}

	private JTextField getJTextFieldB() {
		if (jTextFieldB == null) {
			jTextFieldB = new JTextField();
			jTextFieldB.setText("");
		}
		return jTextFieldB;
	}

	private JTextField getJTextFieldA() {
		if (jTextFieldA == null) {
			jTextFieldA = new JTextField();
			jTextFieldA.setText("");
		}
		return jTextFieldA;
	}

	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GroupLayout());
			jPanel3.add(getJComboBox0(), new Constraints(new Leading(4, 10, 10), new Leading(5, 10, 10)));
			jPanel3.add(getJTextFieldB(), new Constraints(new Leading(110, 24, 12, 12), new Leading(10, 12, 12)));
			jPanel3.add(getJTextFieldC(), new Constraints(new Leading(140, 24, 12, 12), new Leading(10, 12, 12)));
			jPanel3.add(getJTextFieldD(), new Constraints(new Leading(170, 24, 12, 12), new Leading(10, 12, 12)));
			jPanel3.add(getJButton7(), new Constraints(new Leading(63, 10, 10), new Leading(48, 12, 12)));
			jPanel3.add(getJTextFieldA(), new Constraints(new Leading(80, 24, 12, 12), new Leading(10, 12, 12)));
		}
		return jPanel3;
	}

	private JComboBox<String> getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox<String>();
			jComboBox0.setModel(new DefaultComboBoxModel<String>(new String[] { "PTR", "R", "P", "IC", "SF", "SM", "PI", "SI", "CHNL" }));
			jComboBox0.setDoubleBuffered(false);
			jComboBox0.setSelectedIndex(0);
			jComboBox0.setBorder(null);
			jComboBox0.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jComboBox0ActionActionPerformed(event);
				}
			});
		}
		return jComboBox0;
	}

	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					try {
						ok3ButtonActionActionPerformed(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			jButton6.setText("Uzkrauti");
		}
		return jButton6;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.setText("");
		}
		return jTextField0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Failo pavadinimas");
		}
		return jLabel1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJLabel1(), new Constraints(new Leading(6, 10, 10), new Leading(8, 10, 10)));
			jPanel0.add(getJTextField0(), new Constraints(new Leading(6, 140, 12, 10), new Leading(33, 10, 10)));
			jPanel0.add(getJButton6(), new Constraints(new Leading(18, 10, 10), new Trailing(12, 65, 65)));
		}
		return jPanel0;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getJLabel3(), new Constraints(new Leading(10, 10, 10), new Leading(17, 12, 12)));
			jPanel2.add(getJTextField4(), new Constraints(new Leading(160, 24, 12, 12), new Leading(47, 12, 12)));
			jPanel2.add(getJTextField3(), new Constraints(new Leading(130, 24, 12, 12), new Leading(47, 12, 12)));
			jPanel2.add(getJTextField2(), new Constraints(new Leading(100, 24, 12, 12), new Leading(47, 12, 12)));
			jPanel2.add(getJTextField5(), new Constraints(new Leading(70, 24, 12, 12), new Leading(47, 12, 12)));
			jPanel2.add(getJLabel4(), new Constraints(new Leading(10, 12, 12), new Leading(49, 12, 12)));
			jPanel2.add(getOkButton(), new Constraints(new Leading(63, 10, 10), new Leading(85, 12, 12)));
			jPanel2.add(getJTextField6(), new Constraints(new Leading(70, 39, 10, 10), new Leading(17, 12, 12)));
		}
		return jPanel2;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Reik?m?");
			jLabel4.setText("Reik?m?");
		}
		return jLabel4;
	}

	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setText("");
		}
		return jTextField5;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("");
		}
		return jTextField2;
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setText("");
		}
		return jTextField3;
	}

	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setText("");
		}
		return jTextField4;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Adresas");
		}
		return jLabel3;
	}

	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setDocument(new JTextFieldLimit(4));
			jTextField6.setText("");
		}
		return jTextField6;
	}
	
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					okButtonActionActionPerformed(event);
				}
			});
			okButton.setText("Gerai");
		}
		return okButton;
	}

	private JScrollPane getJScrollPane5() {
		if (jScrollPane5 == null) {
			jScrollPane5 = new JScrollPane();
			jScrollPane5.setViewportView(getJTextArea0());
		}
		return jScrollPane5;
	}

	private JTextArea getJTextArea0() {
		if (jTextArea0 == null) {
			jTextArea0 = new JTextArea();
			jTextArea0.setText("wassup fags");
		}
		return jTextArea0;
	}

	private JScrollPane getJScrollPane4() {
		if (jScrollPane4 == null) {
			jScrollPane4 = new JScrollPane();
			jScrollPane4.setViewportView(getCommandsTable());
		}
		return jScrollPane4;
	}

	private JTable getCommandsTable() {
		if (commandsTable == null) {
			commandsTable = new JTable();
			values3 = new String[256][1];
			commandsTable.setModel(new DefaultTableModel(values3,
					new String[] { "Komanda" }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { String.class };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			commandsTable.setEnabled(false);
		}
		return commandsTable;
	}

	private JButton getJButton1() {
		if (playButton == null) {
			playButton = new JButton();
			playButton.setText("Vykdyti");
			playButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					playButtonActionActionPerformed(event);
				}
			});
		}
		return playButton;
	}

	private JButton getJButton0() {
		if (loadVMButton == null) {
			loadVMButton = new JButton();
			loadVMButton.setText("?kelti VM");
			loadVMButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					loadVMButtonActionActionPerformed(event);
				}
			});
		}
		return loadVMButton;
	}

	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getFlagsTable());
		}
		return jScrollPane3;
	}

	private JTable getFlagsTable() {
		if (flagsTable == null) {
			flagsTable = new JTable();
			flagsTable.setModel(new DefaultTableModel(new String[][] { { "X", "0", }, { "X", "0", }, { "BF", "0", }, { "CF", "0", }, { "ZF", "0", },
					{ "SF", "0", }, { "JF", "0", }, { "MF", "0", }, }, new String[] { "FL", "B", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { String.class, String.class, };
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			flagsTable.setEnabled(false);
		}
		return flagsTable;
	}

	private JButton getJButton4() {
		if (changeMemoryButton == null) {
			changeMemoryButton = new JButton();
			changeMemoryButton.setText("Keisti atmint?");
			changeMemoryButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					changeMemoryButtonActionActionPerformed(event);
				}
			});
		}
		return changeMemoryButton;
	}

	private JButton getJButton3() {
		if (changeRegistersButton == null) {
			changeRegistersButton = new JButton();
			changeRegistersButton.setText("Keisti registrus");
			changeRegistersButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					changeRegistersButtonActionActionPerformed(event);
				}
			});
		}
		return changeRegistersButton;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Realioji atmintis");
		}
		return jLabel0;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getRegistersTable());
		}
		return jScrollPane2;
	}

	private JTable getRegistersTable() {
		if (registersTable == null) {
			registersTable = new JTable();
			registersTable.setModel(new DefaultTableModel(new Object[][] { { "PTR", 0, 0, 0, 0, }, { "R", 0, 0, 0, 0, }, { "P", 0, 0, 0, 0, },
					{ "IC", 0, 0, }, { "SF", 0, 0, }, { "SM", 0, 0, }, { "PI", 0}, { "SI", 0 }, { "CHNL", 0}, },
					new String[] { "Reg", "1", "2", "3", "4", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Integer.class, Integer.class, Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			registersTable.setEnabled(false);
		}
		return registersTable;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getRealMemoryTable());
		}
		return jScrollPane0;
	}

	private JTable getRealMemoryTable() {
		if (realMemoryTable == null) {
			realMemoryTable = new JTable();
			realMemoryTable.setModel(new DefaultTableModel(values, new String[] { "Adr", "1", "2", "3", "4", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { String.class, String.class, String.class, String.class, String.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			realMemoryTable.setEnabled(false);
		}
		return realMemoryTable;
	}

	private JButton getJButton2() {
		if (stepButton == null) {
			stepButton = new JButton();
			stepButton.setText("?ingsnis");
			stepButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					stepButtonActionActionPerformed(event);
				}
			});
		}
		return stepButton;
	}

	private void changeRegistersButtonActionActionPerformed(ActionEvent event) {
		if(framek == null){
			framek = new JFrame("Registr� Keitimas");
			framek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			framek.getContentPane().add(getJPanel3(), BorderLayout.CENTER);
			framek.pack();
			framek.setLocation(getLocation());
			framek.setVisible(true);
		}else {
			framek.setVisible(true);
		}

	}

	private void changeMemoryButtonActionActionPerformed(ActionEvent event) {
		if(frameks == null){
			frameks = new JFrame("Atminties Keitimas");
			frameks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			realMemoryTable.setEnabled(true);
			frameks.getContentPane().add(getJPanel2(), BorderLayout.CENTER);
			frameks.pack();
			frameks.setLocation(getLocation());
			frameks.setVisible(true);
		}else{ 
			frameks.setVisible(true);
		}
	}

	private void okButtonActionActionPerformed(ActionEvent event){
		frameks.setVisible(false);
		byte[] b = new byte[4];
		b[0] = (byte)Integer.parseInt(jTextField5.getText());
		b[1] = (byte)Integer.parseInt(jTextField2.getText());
		b[2] = (byte)Integer.parseInt(jTextField3.getText());
		b[3] = (byte)Integer.parseInt(jTextField4.getText());
		
		
		realMachine.getRealMemory().setWord(Integer.parseInt(jTextField6.getText()), b);
		updateRealMemory();
	}
	private void stepButtonActionActionPerformed(ActionEvent event) {
		realMachine.executeNextCommand();
		selectionModel = commandsTable.getSelectionModel();
		selectionModel.setSelectionInterval(commandsTable.getSelectedRow()+1, commandsTable.getSelectedRow()+1);
		updateRealMemory();
		updateRegistersValues();
		
	}

	private void loadVMButtonActionActionPerformed(ActionEvent event) {
		if(frame2 == null){
			frame2 = new JFrame("Load VM");
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.getContentPane().add(getJPanel0(), BorderLayout.CENTER);
			frame2.pack();
			frame2.setLocation(getLocation());
			frame2.setVisible(true);
		}else frame2.setVisible(true);
	}

	private void playButtonActionActionPerformed(ActionEvent event) {
	}
	private void ok3ButtonActionActionPerformed(ActionEvent event)throws IOException{
		frame2.setVisible(false);
		
		 try{
			FileReader fileReader = new FileReader(jTextField0.getText());
			file = new BufferedReader(fileReader);
			byte[][] program = new byte[256][4];
			int i = 0;
			String line;
			char[] lineArray;
			while((file.ready()== true)&& (i < program.length)){
				line = file.readLine();
				lineArray =  line.toCharArray();
				commandsTable.setValueAt(line, i, 0);
				program[i][0] = (byte)lineArray[0];
				program[i][1] = (byte)lineArray[1];
				program[i][2] = (byte)lineArray[2];
				program[i][3] = (byte)lineArray[3];
				i++;
			}
			selectionModel = commandsTable.getSelectionModel();
			selectionModel.setSelectionInterval(0,0);
			registersTable.setValueAt(Math.round((i/16)+0.5), 0, 0);
			realMachine.registerNewVirtualmachine(program, (int) (Math.round((i/16)+0.5)+1));
			updateRealMemory();
			updateRegistersValues();
		 }catch(FileNotFoundException e){System.out.println("Klaida atidarant faila");}
		
	}

	private void jComboBox0ActionActionPerformed(ActionEvent event) {
		byte[] value = new byte[4];
		byte[] value2 = new byte[2];
		byte value3;
		switch(jComboBox0.getSelectedIndex()){
		case 0: value = realMachine.getPTR(); 
				jTextFieldA.setEditable(true);
				jTextFieldA.setText(String.valueOf(value[0]));
				jTextFieldB.setEditable(true);
				jTextFieldB.setText(String.valueOf(value[1]));
				jTextFieldC.setEditable(true);
				jTextFieldC.setText(String.valueOf(value[2]));
				jTextFieldD.setEditable(true);
				jTextFieldD.setText(String.valueOf(value[3]));
			break;
		case 1: value = realMachine.getR();
				jTextFieldA.setText(String.valueOf(value[0]));
				jTextFieldB.setEditable(true);
				jTextFieldB.setText(String.valueOf(value[1]));
				jTextFieldC.setEditable(true);
				jTextFieldC.setText(String.valueOf(value[2]));
				jTextFieldD.setEditable(true);
				jTextFieldD.setText(String.valueOf(value[3]));
			break;
		case 2: value = realMachine.getP();
				jTextFieldA.setText(String.valueOf(value[0]));
				jTextFieldB.setEditable(true);
				jTextFieldB.setText(String.valueOf(value[1]));
				jTextFieldC.setEditable(true);
				jTextFieldC.setText(String.valueOf(value[2]));
				jTextFieldD.setEditable(true);
				jTextFieldD.setText(String.valueOf(value[3]));
			break;
		case 3: value2 = realMachine.getIC();
				jTextFieldA.setEditable(true);
				jTextFieldA.setText(String.valueOf(value2[0]));
				jTextFieldB.setEditable(true);
				jTextFieldB.setText(String.valueOf(value2[1]));
				jTextFieldC.setEditable(false);
				jTextFieldC.setText("");
				jTextFieldD.setEditable(false);
				jTextFieldD.setText("");
			break;
		case 4:	value3 = realMachine.getSF();
				jTextFieldA.setEditable(true);
				jTextFieldA.setText(String.valueOf(value3));
				jTextFieldB.setEditable(false);
				jTextFieldB.setText("");
				jTextFieldC.setEditable(false);
				jTextFieldC.setText("");
				jTextFieldD.setEditable(false);
				jTextFieldD.setText("");
			break;
		case 5:	value2 = realMachine.getSM();
				jTextFieldA.setEditable(true);
				jTextFieldA.setText(String.valueOf(value2[0]));
				jTextFieldB.setEditable(true);
				jTextFieldB.setText(String.valueOf(value2[1]));
				jTextFieldC.setEditable(false);
				jTextFieldC.setText("");
				jTextFieldD.setEditable(false);
				jTextFieldD.setText("");
			break;
		case 6:	value3 = realMachine.getPI();
				jTextFieldA.setText(String.valueOf(value3));
				jTextFieldB.setEditable(false);
				jTextFieldB.setText("");
				jTextFieldC.setEditable(false);
				jTextFieldC.setText("");
				jTextFieldD.setEditable(false);
				jTextFieldD.setText("");
			break;
		case 7: value3 = realMachine.getSI();
				jTextFieldA.setText(String.valueOf(value3));
				jTextFieldB.setEditable(false);
				jTextFieldB.setText("");
				jTextFieldC.setEditable(false);
				jTextFieldC.setText("");
				jTextFieldD.setEditable(false);
				jTextFieldD.setText("");
			break;
		default:value3 = realMachine.getChnl();
				jTextFieldA.setText(String.valueOf(value3));
				jTextFieldB.setEditable(false);
				jTextFieldB.setText("");
				jTextFieldC.setEditable(false);
				jTextFieldC.setText("");
				jTextFieldD.setEditable(false);
				jTextFieldD.setText("");
			break;
		}
		
	}

	private void jButton7ActionActionPerformed(ActionEvent event) {
		framek.setVisible(true);
		byte[] value = new byte[4];
		byte[] valueb = new byte[]{0,0};
		if (jComboBox0.getSelectedIndex() == 4 ){
			value[0] = (byte)Integer.parseInt(jTextFieldA.getText());
		} else {
			if(jComboBox0.getSelectedIndex()> 2){
				value[0] = (byte)Integer.parseInt(jTextFieldA.getText());
				value[1] = (byte)Integer.parseInt(jTextFieldB.getText());
				
			}else{
				value[0] = (byte)Integer.parseInt(jTextFieldA.getText());
				value[1] = (byte)Integer.parseInt(jTextFieldB.getText());
				value[2] = (byte)Integer.parseInt(jTextFieldC.getText());
				value[3] = (byte)Integer.parseInt(jTextFieldD.getText());
			}	
		}
		valueb[0] = value[0];
		valueb[1] = value[1];
		
		switch(jComboBox0.getSelectedIndex()){
		case 0: realMachine.setPTR(value);
			break;
		case 1: realMachine.setR(value);
			break;
		case 2: realMachine.setP(value);
			break;
		case 3: realMachine.setIC(valueb);
			break;
		case 4: realMachine.setSF(valueb[0]);
				updateFlags();
			break;
		case 5: realMachine.setSM(valueb);
			break;
		case 6: realMachine.setPI(value[0]);
			break;
		case 7: realMachine.setSI(value[0]);
			break;
		default:realMachine.setChnl(value[0]);
			break;
		}
	    updateRegistersValues();
	    framek.setVisible(false);
	}
}

class JTextFieldLimit extends PlainDocument {

		private static final long serialVersionUID = 1L;
		private int limit;
		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
}
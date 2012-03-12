import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

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

	private JTextArea jTextArea0;
	private JPanel jPanel1;
	private JFrame framek;
	private JFrame frameks;
	private JButton okButton;
	private JScrollPane jScrollPane1;
	private JButton jButton5;

	private RealMachine realMachine;
	private JTextField jTextField6;
	private JLabel jLabel3;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField5;
	private JLabel jLabel4;
	private JPanel jPanel2;

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
			registersTable.setValueAt(realMachine.getR()[i], 2, i+1);
		}
		for(int i = 0; i < 2; i++){
			registersTable.setValueAt(realMachine.getIC()[i], 3, i+1);
			registersTable.setValueAt(realMachine.getSF()[i], 4, i+1);
			registersTable.setValueAt(realMachine.getSM()[i], 5, i+1);
		}

		registersTable.setValueAt(realMachine.getPI(), 6, 1);
		registersTable.setValueAt(realMachine.getSI(), 7, 1);
		registersTable.setValueAt(realMachine.getChnl(), 8, 1);

	}

	public void updateRealMemory(){
		byte[][] memory = realMachine.getRealMemory().getMemory();
		for(int i = 0; i<memory.length; i++){
			realMemoryTable.setValueAt(Converter.ByteToChar(memory[i][0]), i, 1);
			realMemoryTable.setValueAt(Converter.ByteToChar(memory[i][1]), i, 2);
			realMemoryTable.setValueAt(Converter.ByteToChar(memory[i][2]), i, 3);
			realMemoryTable.setValueAt(Converter.ByteToChar(memory[i][3]), i, 4);
		}
	}

	public void updateFlags(){
		byte[] flag = realMachine.getSF();
		String firstByte = Integer.toBinaryString(flag[0]);
		String secondByte = Integer.toBinaryString(flag[1]);

		if(firstByte.length() == 3) firstByte = "0"+firstByte;
		if(firstByte.length() == 2) firstByte = "00"+firstByte;
		if(firstByte.length() == 1) firstByte = "000"+firstByte;
		if(secondByte.length() == 3) secondByte = "0"+secondByte;
		if(secondByte.length() == 2) secondByte = "00"+secondByte;
		if(secondByte.length() == 1) secondByte = "000"+secondByte;

		char[] charsArray1 = firstByte.toCharArray();
		char[] charsArray2 = secondByte.toCharArray();

		for(int i = 0; i<firstByte.length(); i++){
			flagsTable.setValueAt(charsArray1[i], i, 1);
			flagsTable.setValueAt(charsArray2[i], i+4, 1);
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
		add(getJScrollPane2(), new Constraints(new Leading(535, 156, 10, 10), new Leading(8, 132, 12, 12)));
		setSize(775, 513);
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

	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					ok2ButtonActionActionPerformed(event);
				}
			});
			jButton5.setText("Gerai");
		}
		return jButton5;
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

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJScrollPane1(), new Constraints(new Leading(12, 126, 12, 12), new Leading(4, 168, 10, 10)));
			jPanel1.add(getJButton5(), new Constraints(new Leading(40, 10, 10), new Leading(178, 120, 10)));
		}
		return jPanel1;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getRegistersTable());
		}
		return jScrollPane1;
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
			jTextArea0.setText("jTextArea0");
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
			commandsTable.setModel(new DefaultTableModel(new Object[][] { { "ADD", "0000", }, { "SUB", "0001",} },
					new String[] { "Komanda", "Adresas", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { String.class, String.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
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
			framek = new JFrame("Registr¸ Keitimas");
			framek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			registersTable.setEnabled(true);;
			framek.getContentPane().add(getJPanel1(), BorderLayout.CENTER);
			framek.pack();
			framek.setLocation(getLocation());
			framek.setVisible(true);
		}else {
			registersTable.setEnabled(true);
			jScrollPane1.setViewportView(getRegistersTable());
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

	private void ok2ButtonActionActionPerformed(ActionEvent event) {
		framek.setVisible(false);
		getRegistersTable().setEnabled(false);
		jScrollPane2.setViewportView(getRegistersTable());
	}

	private void okButtonActionActionPerformed(ActionEvent event){
		frameks.setVisible(false);
		realMemoryTable.setValueAt(jTextField5.getText(), Integer.parseInt(jTextField6.getText()), 1);
		realMemoryTable.setValueAt(jTextField2.getText(), Integer.parseInt(jTextField6.getText()), 2);
		realMemoryTable.setValueAt(jTextField3.getText(), Integer.parseInt(jTextField6.getText()), 3);
		realMemoryTable.setValueAt(jTextField4.getText(), Integer.parseInt(jTextField6.getText()), 4);
	}
	private void stepButtonActionActionPerformed(ActionEvent event) {
	}

	private void loadVMButtonActionActionPerformed(ActionEvent event) {
	}

	private void playButtonActionActionPerformed(ActionEvent event) {
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
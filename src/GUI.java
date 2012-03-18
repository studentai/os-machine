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
import javax.swing.JOptionPane;
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
	private JTable flagsTable;
	private JScrollPane jScrollPane0;
	private JScrollPane jScrollPane3;
	private JLabel jLabel0;

	public static String[][] values;
	public static Integer[][] values2;
	public static String[][] values3;
	public static String[][] values4;
	private BufferedReader file;

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
	private JTable virtualMemoryTable;
	private JScrollPane jScrollPane1;
	private JLabel jLabel2;
	private JTable semaforTable;
	private JScrollPane jScrollPane6;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JPanel jPanel1;
	private JTextField jTextField1;
	private JTextField jTextField7;
	private JTextField jTextField8;
	private JTextField jTextField9;
	private JTextField jTextField11;
	private JTextField jTextField12;
	private JTextField jTextField13;
	private JTextField jTextField14;
	private JTextField jTextField15;
	private JTextField jTextField16;
	private JTextField jTextField17;
	private JTextField jTextField18;
	private JTextField jTextField19;
	private JTextField jTextField20;
	private JTextField jTextField21;
	private JTextField jTextField22;
	private JTextField jTextField23;
	private JTextField jTextField24;
	private JTextField jTextField25;
	private JTextField jTextField26;
	private JTextArea jTextArea0;
	private JScrollPane jScrollPane7;
	private JLabel jLabel14;
	private JTextField jTextField10;
	private JLabel jLabel15;
	private JLabel jLabel16;

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

		jTextField1.setText(String.valueOf(realMachine.getPTR()[0]));
		jTextField7.setText(String.valueOf(realMachine.getPTR()[1]));
		jTextField8.setText(String.valueOf(realMachine.getPTR()[2]));
		jTextField9.setText(String.valueOf(realMachine.getPTR()[3]));
		
		jTextField11.setText(String.valueOf(realMachine.getR()[0]));
		jTextField12.setText(String.valueOf(realMachine.getR()[1]));
		jTextField13.setText(String.valueOf(realMachine.getR()[2]));
		jTextField14.setText(String.valueOf(realMachine.getR()[3]));
		
		jTextField15.setText(String.valueOf(realMachine.getP()[0]));
		jTextField16.setText(String.valueOf(realMachine.getP()[1]));
		jTextField17.setText(String.valueOf(realMachine.getP()[2]));
		jTextField18.setText(String.valueOf(realMachine.getP()[3]));
		
		jTextField19.setText(String.valueOf(realMachine.getIC()[0]));
		jTextField20.setText(String.valueOf(realMachine.getIC()[1]));
		
		jTextField21.setText(String.valueOf(realMachine.getSM()[0]));
		jTextField22.setText(String.valueOf(realMachine.getSM()[1]));
		
		jTextField23.setText(String.valueOf(realMachine.getSF()));
		jTextField24.setText(String.valueOf(realMachine.getPI()));
		
		jTextField25.setText(String.valueOf(realMachine.getSI()));
		jTextField26.setText(String.valueOf(realMachine.getTI()));
		jTextField10.setText(String.valueOf(realMachine.getChnl()));
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
		add(getJButton2(), new Constraints(new Leading(8, 116, 12, 12), new Leading(77, 10, 10)));
		add(getJButton1(), new Constraints(new Leading(8, 116, 12, 12), new Leading(43, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(8, 116, 12, 12), new Leading(8, 10, 10)));
		add(getJScrollPane0(), new Constraints(new Leading(566, 200, 12, 12), new Leading(278, 271, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(566, 12, 12), new Leading(255, 12, 12)));
		add(getRegistersPanel(), new Constraints(new Leading(566, 164, 12, 12), new Leading(4, 252, 12, 12)));
		add(getJScrollPane3(), new Constraints(new Leading(484, 58, 12, 12), new Leading(31, 150, 40, 37)));
		add(getJLabel15(), new Constraints(new Leading(252, 10, 10), new Leading(8, 40, 37)));
		add(getJLabel16(), new Constraints(new Leading(506, 12, 12), new Leading(8, 40, 37)));
		add(getJLabel2(), new Constraints(new Leading(317, 12, 12), new Leading(12, 46, 243)));
		add(getJButton3(), new Constraints(new Leading(8, 116, 12, 12), new Leading(517, 10, 10)));
		add(getJButton4(), new Constraints(new Leading(8, 114, 12, 12), new Leading(479, 12, 12)));
		add(getJScrollPane6(), new Constraints(new Leading(211, 59, 12, 12), new Leading(30, 150, 46, 243)));
		add(getJScrollPane1(), new Constraints(new Leading(282, 186, 12, 12), new Leading(30, 270, 46, 243)));
		add(getJScrollPane7(), new Constraints(new Leading(210, 304, 10, 10), new Leading(326, 219, 12, 12)));
		setSize(775, 559);
	}

	private JLabel getJLabel16() {
		if (jLabel16 == null) {
			jLabel16 = new JLabel();
			jLabel16.setText("SF");
		}
		return jLabel16;
	}

	private JLabel getJLabel15() {
		if (jLabel15 == null) {
			jLabel15 = new JLabel();
			jLabel15.setText("SM");
		}
		return jLabel15;
	}

	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
			jTextField10.setText("0");
		}
		return jTextField10;
	}

	private JLabel getJLabel14() {
		if (jLabel14 == null) {
			jLabel14 = new JLabel();
			jLabel14.setText("CHL");
		}
		return jLabel14;
	}

	private JScrollPane getJScrollPane7() {
		if (jScrollPane7 == null) {
			jScrollPane7 = new JScrollPane();
			jScrollPane7.setViewportView(getJTextArea0());
		}
		return jScrollPane7;
	}

	private JTextArea getJTextArea0() {
		if (jTextArea0 == null) {
			jTextArea0 = new JTextArea();
			jTextArea0.setText("jTextArea0");
		}
		return jTextArea0;
	}

	private JTextField getJTextField26() {
		if (jTextField26 == null) {
			jTextField26 = new JTextField();
			jTextField26.setText("0");
		}
		return jTextField26;
	}

	private JTextField getJTextField25() {
		if (jTextField25 == null) {
			jTextField25 = new JTextField();
			jTextField25.setText("0");
		}
		return jTextField25;
	}

	private JTextField getJTextField24() {
		if (jTextField24 == null) {
			jTextField24 = new JTextField();
			jTextField24.setText("0");
		}
		return jTextField24;
	}

	private JTextField getJTextField23() {
		if (jTextField23 == null) {
			jTextField23 = new JTextField();
			jTextField23.setText("0");
		}
		return jTextField23;
	}

	private JTextField getJTextField22() {
		if (jTextField22 == null) {
			jTextField22 = new JTextField();
			jTextField22.setText("0");
		}
		return jTextField22;
	}

	private JTextField getJTextField21() {
		if (jTextField21 == null) {
			jTextField21 = new JTextField();
			jTextField21.setText("0");
		}
		return jTextField21;
	}

	private JTextField getJTextField20() {
		if (jTextField20 == null) {
			jTextField20 = new JTextField();
			jTextField20.setText("0");
		}
		return jTextField20;
	}

	private JTextField getJTextField19() {
		if (jTextField19 == null) {
			jTextField19 = new JTextField();
			jTextField19.setText("0");
		}
		return jTextField19;
	}

	private JTextField getJTextField18() {
		if (jTextField18 == null) {
			jTextField18 = new JTextField();
			jTextField18.setText("0");
		}
		return jTextField18;
	}

	private JTextField getJTextField17() {
		if (jTextField17 == null) {
			jTextField17 = new JTextField();
			jTextField17.setText("0");
		}
		return jTextField17;
	}

	private JTextField getJTextField16() {
		if (jTextField16 == null) {
			jTextField16 = new JTextField();
			jTextField16.setText("0");
		}
		return jTextField16;
	}

	private JTextField getJTextField15() {
		if (jTextField15 == null) {
			jTextField15 = new JTextField();
			jTextField15.setText("0");
		}
		return jTextField15;
	}

	private JTextField getJTextField14() {
		if (jTextField14 == null) {
			jTextField14 = new JTextField();
			jTextField14.setText("0");
		}
		return jTextField14;
	}

	private JTextField getJTextField13() {
		if (jTextField13 == null) {
			jTextField13 = new JTextField();
			jTextField13.setText("0");
		}
		return jTextField13;
	}

	private JTextField getJTextField12() {
		if (jTextField12 == null) {
			jTextField12 = new JTextField();
			jTextField12.setText("0");
		}
		return jTextField12;
	}

	private JTextField getJTextField11() {
		if (jTextField11 == null) {
			jTextField11 = new JTextField();
			jTextField11.setText("0");
		}
		return jTextField11;
	}

	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setText("0");
		}
		return jTextField9;
	}

	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setText("0");
		}
		return jTextField8;
	}

	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setText("0");
		}
		return jTextField7;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("0");
		}
		return jTextField1;
	}

	private JPanel getRegistersPanel() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJLabel5(), new Constraints(new Leading(3, 12, 12), new Leading(3, 12, 12)));
			jPanel1.add(getJLabel6(), new Constraints(new Leading(3, 12, 12), new Leading(28, 12, 12)));
			jPanel1.add(getJLabel7(), new Constraints(new Leading(3, 12, 12), new Leading(53, 12, 12)));
			jPanel1.add(getJLabel8(), new Constraints(new Leading(3, 12, 12), new Leading(78, 12, 12)));
			jPanel1.add(getJLabel9(), new Constraints(new Leading(3, 12, 12), new Leading(103, 12, 12)));
			jPanel1.add(getJLabel10(), new Constraints(new Leading(3, 12, 12), new Leading(128, 12, 12)));
			jPanel1.add(getJLabel11(), new Constraints(new Leading(3, 12, 12), new Leading(153, 12, 12)));
			jPanel1.add(getJLabel12(), new Constraints(new Leading(3, 12, 12), new Leading(178, 12, 12)));
			jPanel1.add(getJLabel13(), new Constraints(new Leading(3, 12, 12), new Leading(203, 12, 12)));
			jPanel1.add(getJTextField1(), new Constraints(new Leading(36, 24, 10, 10), new Leading(1, 12, 12)));
			jPanel1.add(getJTextField7(), new Constraints(new Leading(66, 24, 10, 10), new Leading(1, 12, 12)));
			jPanel1.add(getJTextField8(), new Constraints(new Leading(96, 24, 10, 10), new Leading(1, 12, 12)));
			jPanel1.add(getJTextField9(), new Constraints(new Leading(126, 24, 10, 10), new Leading(1, 12, 12)));
			jPanel1.add(getJTextField11(), new Constraints(new Leading(36, 24, 12, 12), new Leading(25, 12, 12)));
			jPanel1.add(getJTextField12(), new Constraints(new Leading(66, 24, 12, 12), new Leading(25, 12, 12)));
			jPanel1.add(getJTextField13(), new Constraints(new Leading(96, 24, 12, 12), new Leading(25, 12, 12)));
			jPanel1.add(getJTextField14(), new Constraints(new Leading(126, 24, 12, 12), new Leading(25, 12, 12)));
			jPanel1.add(getJTextField15(), new Constraints(new Leading(36, 24, 12, 12), new Leading(51, 12, 12)));
			jPanel1.add(getJTextField17(), new Constraints(new Leading(96, 24, 12, 12), new Leading(51, 12, 12)));
			jPanel1.add(getJTextField18(), new Constraints(new Leading(126, 24, 12, 12), new Leading(51, 12, 12)));
			jPanel1.add(getJTextField19(), new Constraints(new Leading(36, 24, 12, 12), new Leading(75, 12, 12)));
			jPanel1.add(getJTextField20(), new Constraints(new Leading(66, 24, 12, 12), new Leading(75, 12, 12)));
			jPanel1.add(getJTextField21(), new Constraints(new Leading(36, 24, 12, 12), new Leading(101, 12, 12)));
			jPanel1.add(getJTextField22(), new Constraints(new Leading(66, 24, 12, 12), new Leading(101, 12, 12)));
			jPanel1.add(getJTextField23(), new Constraints(new Leading(36, 24, 12, 12), new Leading(127, 12, 12)));
			jPanel1.add(getJTextField24(), new Constraints(new Leading(36, 24, 12, 12), new Leading(153, 12, 12)));
			jPanel1.add(getJTextField25(), new Constraints(new Leading(36, 24, 12, 12), new Leading(179, 12, 12)));
			jPanel1.add(getJTextField26(), new Constraints(new Leading(36, 24, 12, 12), new Leading(203, 12, 12)));
			jPanel1.add(getJTextField16(), new Constraints(new Leading(66, 24, 12, 12), new Leading(51, 12, 12)));
			jPanel1.add(getJLabel14(), new Constraints(new Leading(3, 12, 12), new Leading(229, 12, 12)));
			jPanel1.add(getJTextField10(), new Constraints(new Leading(36, 24, 12, 12), new Leading(227, 12, 12)));
		}
		return jPanel1;
	}

	private JLabel getJLabel13() {
		if (jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("TI");
		}
		return jLabel13;
	}

	private JLabel getJLabel12() {
		if (jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setText("SI");
		}
		return jLabel12;
	}

	private JLabel getJLabel11() {
		if (jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("PI");
		}
		return jLabel11;
	}

	private JLabel getJLabel10() {
		if (jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("SF");
		}
		return jLabel10;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("SM");
		}
		return jLabel9;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("IC");
		}
		return jLabel8;
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("P");
		}
		return jLabel7;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("R");
		}
		return jLabel6;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("PTR");
		}
		return jLabel5;
	}

	private JScrollPane getJScrollPane6() {
		if (jScrollPane6 == null) {
			jScrollPane6 = new JScrollPane();
			jScrollPane6.setViewportView(getSemaforTable());
		}
		return jScrollPane6;
	}

	private JTable getSemaforTable() {
		if (semaforTable == null) {
			semaforTable = new JTable();
			semaforTable.setModel(new DefaultTableModel(new String[][] { { "1", "0", }, { "2", "0", }, { "3", "0", }, { "4", "0", }, { "5", "0", },
					{ "5", "0", }, { "6", "0", }, { "7", "0", }, { "8", "0", },{ "9", "0", },{ "A", "0", },{ "B", "0", },{ "C", "0", },{ "D", "0", },
					{ "E", "0", },{ "F", "0", }, }, new String[] { "B", "V", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return semaforTable;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Virtuali atmintis");
		}
		return jLabel2;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getVirtualMemoryTable());
		}
		return jScrollPane1;
	}

	private JTable getVirtualMemoryTable() {
		if (virtualMemoryTable == null) {
			virtualMemoryTable = new JTable();
			virtualMemoryTable.setModel(new DefaultTableModel(values4 , new String[] { "Adr", "1","2","3","4", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { String.class, String.class, String.class, String.class, String.class };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return virtualMemoryTable;
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
			loadVMButton.setText("Ikelti VM");
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
			changeMemoryButton.setText("Keisti atminti");
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
			changeRegistersButton.setText("Keisti registra");
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
			stepButton.setText("Zingsnis");
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
		updateRealMemory();
		updateRegistersValues();
		updateFlags();
		
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
				program[i][0] = (byte)lineArray[0];
				program[i][1] = (byte)lineArray[1];
				program[i][2] = (byte)lineArray[2];
				program[i][3] = (byte)lineArray[3];
				i++;
			}
			if(realMachine.registerNewVirtualmachine(program, (int) (Math.round((i/16)+0.5)+1)) == false){
				JOptionPane.showMessageDialog(new JFrame(),
					    "Naujai virtualiai masinai, atminties neuztenka",
					    "Klaida",
					    JOptionPane.ERROR_MESSAGE);
			}else{
				updateVirtualMemory();
				updateRealMemory();
				updateRegistersValues();
			}
		 }catch(FileNotFoundException e){System.out.println("Klaida atidarant faila");}
		
	}

	private void updateVirtualMemory() {
		byte[] PTR = realMachine.getPTR();
		byte[][] block;
		int tmp = 16;
		for(int i = 0; i< PTR[1];i++){
			block = realMachine.getRealMemory().getBlock(PTR[2]+i);
			for(int j = i * 16; j < tmp; j++ ){
				virtualMemoryTable.setValueAt(block[j][0], j, 1);
				virtualMemoryTable.setValueAt(block[j][1], j, 2);
				virtualMemoryTable.setValueAt(block[j][2], j, 3);
				virtualMemoryTable.setValueAt(block[j][3], j, 4);
			}
			tmp = tmp * 2;
		}
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
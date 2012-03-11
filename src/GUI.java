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
	
	public static Integer[][] values;
	public static Integer[][] values2;
	
	private JTextArea jTextArea0;
	private JTextField jTextField0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JPanel jPanel0;
	private JFrame framek;
	private JButton okButton;
	
	public GUI() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJButton0(), new Constraints(new Leading(8, 10, 10), new Leading(8, 10, 10)));
		add(getJButton2(), new Constraints(new Leading(8, 12, 12), new Leading(77, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(563, 12, 12), new Leading(159, 10, 10)));
		add(getJScrollPane3(), new Constraints(new Leading(707, 58, 10, 10), new Leading(6, 136, 12, 12)));
		add(getJButton1(), new Constraints(new Leading(8, 80, 12, 12), new Leading(43, 10, 10)));
		add(getJScrollPane2(), new Constraints(new Leading(563, 128, 12, 12), new Leading(8, 132, 12, 12)));
		add(getJScrollPane4(), new Constraints(new Leading(232, 200, 10, 10), new Leading(8, 361, 12, 12)));
		add(getJButton3(), new Constraints(new Leading(8, 12, 12), new Leading(470, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(563, 200, 10, 10), new Leading(177, 319, 12, 12)));
		add(getJScrollPane5(), new Constraints(new Leading(233, 198, 12, 12), new Leading(386, 110, 12, 12)));
		add(getJButton4(), new Constraints(new Leading(8, 120, 12, 12), new Leading(432, 12, 12)));
		setSize(775, 513);
	}

	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText("Gerai");
		}
		return okButton;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJLabel1(), new Constraints(new Leading(8, 10, 10), new Leading(3, 10, 10)));
			jPanel0.add(getJTextField0(), new Constraints(new Leading(62, 34, 12, 12), new Leading(3, 12, 12)));
			jPanel0.add(getJTextField1(), new Constraints(new Leading(63, 12, 12), new Leading(27, 10, 10)));
			jPanel0.add(getJLabel2(), new Constraints(new Leading(7, 12, 12), new Leading(29, 12, 12)));
			jPanel0.add(getOkButton(), new Constraints(new Leading(18, 10, 10), new Leading(53, 12, 12)));
		}
		return jPanel0;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setDocument(new JTextFieldLimit(4));
			jTextField1.setText("FFFF");
		}
		return jTextField1;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Reikðmë");
		}
		return jLabel2;
	}
	
	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Adresas");
		}
		return jLabel1;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField(4);
			jTextField0.setDocument(new JTextFieldLimit(4));
			jTextField0.setText("0000");
		}
		return jTextField0;
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
			commandsTable.setModel(new DefaultTableModel(new Object[][] { { "ADD", "50", }, { "SUB", "80", }, }, new String[] { "Komanda", "Adresas", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
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
			loadVMButton.setText("Ákelti VM");
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
			flagsTable.setModel(new DefaultTableModel(new Object[][] { { "X", "0", }, { "X", "0", }, { "BF", "0", }, { "CF", "0", }, { "ZF", "0", },
					{ "SF", "0", }, { "JF", "0", }, { "MF", "0", }, }, new String[] { "", "", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return flagsTable;
	}

	private JButton getJButton4() {
		if (changeMemoryButton == null) {
			changeMemoryButton = new JButton();
			changeMemoryButton.setText("Keisti atmintá");
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
			registersTable.setModel(new DefaultTableModel(new Object[][] { { "PTR", "0000", }, { "R", "0000", }, { "P", "0000", }, { "IC", "00", },
					{ "SF", "00", }, { "SM", "00", }, { "PI", "0", }, { "SI", "0", }, { "CHNL", "0", }, },
					new String[] { "Registrai", "Reikðmë", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
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
			realMemoryTable.setModel(new DefaultTableModel(values, new String[] { "Adresas", "Reikðmë", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return realMemoryTable;
	}

	private JButton getJButton2() {
		if (stepButton == null) {
			stepButton = new JButton();
			stepButton.setText("Þingsnis");
			stepButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					stepButtonActionActionPerformed(event);
				}
			});
		}
		return stepButton;
	}

	private void changeRegistersButtonActionActionPerformed(ActionEvent event) {
	}

	private void changeMemoryButtonActionActionPerformed(ActionEvent event) {
		framek = new JFrame("Keitimas");
		framek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framek.getContentPane().add(getJPanel0(), BorderLayout.CENTER);
		framek.pack();
		framek.setLocation(getLocation());
		framek.setVisible(true);
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
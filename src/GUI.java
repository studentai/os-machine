import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jButton0;
	private JButton jButton1;
	private JButton jButton2;
	private JTable realMemoryTable;
	private JTable registersTable;
	private JTable flagsTable;
	private JScrollPane jScrollPane0;
	private JScrollPane jScrollPane2;
	private JLabel jLabel0;
	private JButton jButton3;
	private JButton jButton4;
	public static Integer[][] values;
	public static Integer[][] values2;
	
	private JScrollPane jScrollPane3;
	private JTable commandsTable;
	private JScrollPane jScrollPane4;
	private JTextArea jTextArea0;
	private JScrollPane jScrollPane5;
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
		add(getJButton4(), new Constraints(new Leading(8, 120, 12, 12), new Leading(438, 12, 12)));
		add(getJButton3(), new Constraints(new Leading(8, 12, 12), new Leading(470, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(563, 200, 10, 10), new Leading(177, 319, 12, 12)));
		add(getJScrollPane5(), new Constraints(new Leading(233, 198, 12, 12), new Leading(386, 110, 12, 12)));
		setSize(775, 513);
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
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Vykdyti");
		}
		return jButton1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Ákelti VM");
		}
		return jButton0;
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
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("Keisti atmintá");
		}
		return jButton4;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Keisti registrus");
		}
		return jButton3;
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
			realMemoryTable.setModel(new DefaultTableModel(values, new String[] { "Numeris", "Adresas", }) {
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
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Þingsnis");
		}
		return jButton2;
	}
}

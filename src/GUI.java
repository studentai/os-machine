import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
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
	private JTable virtualMemoryTable;
	private JScrollPane jScrollPane0;
	private JTable realMemoryTable;
	private JScrollPane jScrollPane1;
	private JTable registersTable;
	private JScrollPane jScrollPane2;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JButton jButton3;
	private JButton jButton4;
	private JSeparator jSeparator0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	private static Integer[][] values;
	private static Integer[][] values2;
	public GUI() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJButton0(), new Constraints(new Leading(8, 10, 10), new Leading(8, 10, 10)));
		add(getJButton1(), new Constraints(new Leading(8, 12, 12), new Leading(43, 10, 10)));
		add(getJButton2(), new Constraints(new Leading(8, 12, 12), new Leading(77, 10, 10)));
		add(getJScrollPane0(), new Constraints(new Leading(563, 200, 10, 10), new Leading(177, 150, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(563, 12, 12), new Leading(159, 10, 10)));
		add(getJScrollPane1(), new Constraints(new Leading(563, 200, 12, 12), new Leading(353, 150, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(565, 10, 10), new Leading(335, 10, 10)));
		add(getJButton3(), new Constraints(new Leading(24, 10, 10), new Leading(470, 10, 10)));
		add(getJButton4(), new Constraints(new Leading(138, 10, 10), new Leading(470, 12, 12)));
		add(getJSeparator0(), new Constraints(new Leading(545, 234, 12, 12), new Leading(140, 9, 10, 10)));
		add(getJScrollPane2(), new Constraints(new Leading(634, 128, 10, 10), new Leading(12, 120, 12, 12)));
		setSize(775, 513);
	}

	private JSeparator getJSeparator0() {
		if (jSeparator0 == null) {
			jSeparator0 = new JSeparator();
		}
		return jSeparator0;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("jButton4");
		}
		return jButton4;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("jButton3");
		}
		return jButton3;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Virtualioji atmintis");
		}
		return jLabel1;
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
			registersTable.setEnabled(false);
			registersTable.setModel(new DefaultTableModel(new Object[][] { { "PTR", "0000", }, { "IC", "0000", }, { "R", "0000", }, { "P", "0000", }, { "SF", "0000", },
					{ "SM", "0000", }, }, new String[] { "Registrai", "Reik�m�", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return registersTable;
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
			virtualMemoryTable.setModel(new DefaultTableModel(values2, new String[] { "Numeris", "Adresas", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return virtualMemoryTable;
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
			Integer[][] obj = new Integer[][]{{1,1}};
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
			jButton2.setText("jButton2");
		}
		return jButton2;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("jButton1");
		}
		return jButton1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("jButton0");
		}
		return jButton0;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		setRealMemoryValues(1024);
		setVirtualMemoryValues(256);
		installLnF();
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
	}
	
	public static void setRealMemoryValues(int size){
		values = new Integer[size][2];
		for(int i = 0; i<size;i++){
			values[i][0] =(Integer) i;
			values[i][1] =(Integer) 0;
		}
	}
	
	public static void setVirtualMemoryValues(int size){
		values2 = new Integer[size][2];
		for(int i = 0; i < size; i++){
			values2[i][0] = (Integer) i;
			values2[i][1] = (Integer) 0;
		}
	}

}

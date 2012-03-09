import javax.swing.JPanel;

import org.dyno.visual.swing.layouts.GroupLayout;


//VS4E -- DO NOT REMOVE THIS LINE!
public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		setSize(320, 240);
	}

}

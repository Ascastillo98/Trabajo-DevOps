package es.uca.mps.matrics.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainWindow {

	private JFrame frmMatrixCalculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMatrixCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMatrixCalculator = new JFrame();
		frmMatrixCalculator.setTitle("Matrix Calculator");
		frmMatrixCalculator.setBounds(100, 100, 900, 600);
		frmMatrixCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatrixCalculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matrix Calculator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(247, 24, 420, 104);
		frmMatrixCalculator.getContentPane().add(lblNewLabel);
	}
}

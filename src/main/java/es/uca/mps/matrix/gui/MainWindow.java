package es.uca.mps.matrix.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
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
		
		JMenuBar menuBar = new JMenuBar();
		frmMatrixCalculator.setJMenuBar(menuBar);
		
		JMenu mnMatrices = new JMenu("Matrices");
		menuBar.add(mnMatrices);
		
		JMenu mnOperacion = new JMenu("Operaciones");
		mnMatrices.add(mnOperacion);
		
		JMenuItem mnitSumar = new JMenuItem("Sumar");
		mnitSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMatrixCalculator = new FrmSuma();
				frmMatrixCalculator.setVisible(true);
			}
		});
		mnOperacion.add(mnitSumar);
		
		JMenuItem mnitRestar = new JMenuItem("Restar");
		mnOperacion.add(mnitRestar);
		
		JMenuItem mnitMult = new JMenuItem("Multiplicar");
		mnOperacion.add(mnitMult);
		
		JMenuItem mnitEsc = new JMenuItem("ProductoEscalar");
		mnOperacion.add(mnitEsc);
		frmMatrixCalculator.getContentPane().setLayout(new CardLayout(0, 0));
	}
}

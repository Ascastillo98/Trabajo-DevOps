package es.uca.mps.matrix.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
		
		JMenu mnOperaciones = new JMenu("Operaciones");
		mnMatrices.add(mnOperaciones);
		
		JMenuItem mntmSumar = new JMenuItem("Sumar");
		mntmSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrSumar frSumar = new FrSumar();
				frSumar.setVisible(true);
				frmMatrixCalculator.setVisible(false);
			}
		});
		mnOperaciones.add(mntmSumar);
		
		JMenuItem mntmRestar = new JMenuItem("Restar");
		mnOperaciones.add(mntmRestar);
		
		JMenuItem mntmMultiplicar = new JMenuItem("Multiplicar");
		mnOperaciones.add(mntmMultiplicar);
		
		JMenuItem mntmProductoEscalar = new JMenuItem("Producto Escalar");
		mnOperaciones.add(mntmProductoEscalar);
		
		JMenuItem mntmTraspuesta = new JMenuItem("Traspuesta");
		mnOperaciones.add(mntmTraspuesta);
		frmMatrixCalculator.getContentPane().setLayout(null);
		
		JLabel lblBienvenidoSeleccionaUna = new JLabel("Bienvenido, selecciona una operación en el menú superior para comenzar");
		lblBienvenidoSeleccionaUna.setBounds(12, 136, 568, 15);
		frmMatrixCalculator.getContentPane().add(lblBienvenidoSeleccionaUna);
	}
}

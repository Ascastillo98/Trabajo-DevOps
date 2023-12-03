package es.uca.mps.matrix.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

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

		JMenuItem mntmMultCellByCell = new JMenuItem("Multiplicar Celda a Celda");
		mnOperaciones.add(mntmMultCellByCell);
		
		frmMatrixCalculator.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWelcome = new JLabel("Bienvenido, seleccione una de las opciones del menú superior para continuar");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		frmMatrixCalculator.getContentPane().add(lblWelcome);
	}
}

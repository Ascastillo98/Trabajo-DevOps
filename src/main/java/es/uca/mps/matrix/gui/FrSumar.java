package es.uca.mps.matrix.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrSumar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTamano;

	/**
	 * Create the frame.
	 */
	public FrSumar() {
		setTitle("Sumar matrices");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTamano = new JLabel("Tamaño de la matriz");
		panelNorth.add(lblTamano);
		
		txtTamano = new JTextField();
		panelNorth.add(txtTamano);
		txtTamano.setColumns(10);
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cargarMatrices();
				if(txtTamano.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No has introducido un tamaño.", "Error", JOptionPane.ERROR_MESSAGE);
				try {
					JPanel internalPanel = new JPanel();
					MatrixInput matrixInput = new MatrixInput(Integer.parseInt(txtTamano.getText()));
					internalPanel.add(matrixInput);
					contentPane.add(internalPanel, BorderLayout.CENTER);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				FrSumar.this.setVisible(true);
			}
		});
		panelNorth.add(btnNewButton);
	}

}

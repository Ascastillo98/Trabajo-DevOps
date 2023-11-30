package es.uca.mps.matrix.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MatrixInput extends JPanel{
	private static final long serialVersionUID = 1L;
	private int _n;
	private List<JTextField> _textFields;

	public MatrixInput(int n) {
		try {
			_n = n;
			_textFields = new ArrayList<JTextField>(_n * _n);
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			setPreferredSize(new Dimension(400, 400));
			JPanel matrixPanel = new JPanel(new GridLayout(_n, _n));
			add(matrixPanel);
			
			Dimension textFielDimension = new Dimension(50, 50);
				
			for(int i = 0; i < _n; i++) {					
				for(int j = 0; j < _n; j++) {
					JTextField txtCell = new JTextField();
					txtCell.setColumns(4);
					txtCell.setPreferredSize(textFielDimension);
					txtCell.setHorizontalAlignment(JTextField.CENTER);
					matrixPanel.add(txtCell);
					
					_textFields.add(txtCell);
				}
			}
			
			JButton btnSave = new JButton();
			btnSave.setText("Introducir");
			add(btnSave);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

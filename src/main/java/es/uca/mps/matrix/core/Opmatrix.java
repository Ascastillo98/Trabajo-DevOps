package es.uca.mps.matrix.core;

public class Opmatrix {

	
	 private Opmatrix() {
	        throw new IllegalStateException("Utility class");
	 }
	
	public static void addMatrix(Matrix a, Matrix b, Matrix c) {
		checkMatrix(a, b);
		checkMatrix(a, c);
		for(int i = 0; i < a.getFilas(); i++) {
			for(int j = 0; j < a.getColumnas(); j++) {
				int suma = a.getValor(i, j) +  b.getValor(i, j);
				c.setValor(i, j, suma);
			}
		}
	}
	
	public static void subtractionMatrix(Matrix a, Matrix b, Matrix c) {
		checkMatrix(a, b);
		checkMatrix(a, c);
		for(int i = 0; i < a.getFilas(); i++) {
			for(int j = 0; j < a.getColumnas(); j++) {
				int resta = a.getValor(i, j) -  b.getValor(i, j);
				c.setValor(i, j, resta);
			}
		}
	}
	
	public static void multiplyMatrix(Matrix a, Matrix b, Matrix c) {
		checkMatrix(a, b);
		checkMatrix(a, c);
		for(int i = 0; i < a.getFilas(); i++) {
			for(int j = 0; j < a.getColumnas(); j++) {
				int mult = 0;
				for(int k = 0; k < a.getFilas(); k++)
					mult += a.getValor(i, k) * b.getValor(k, j);
				c.setValor(i, j, mult);
			}
		}
	}
	
	public static void scalarProductMatrix(Matrix a, Matrix c, int prod) {
		checkMatrix(a, c);
		for(int i = 0; i < a.getFilas(); i++) {
			for(int j = 0; j < a.getColumnas(); j++) {
				c.setValor(i, j, prod * a.getValor(i, j));
			}
		}
	}
	
	public static void transposedMatrix(Matrix a, Matrix c) {
		checkMatrix(a, c);
		for(int i = 0; i < a.getFilas(); i++) {
			for(int j = 0; j < a.getColumnas(); j++) {
				c.setValor(i, j, a.getValor(j, i));  //Asignamos a C[i][j] el valor de A[j][i]
			}
		}
	}
	
	private static void checkMatrix(Matrix a, Matrix b) {
		if(a.getFilas() != b.getFilas()) {
			throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
		}
	}
	
}

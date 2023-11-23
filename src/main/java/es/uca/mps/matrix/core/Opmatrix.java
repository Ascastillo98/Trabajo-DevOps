package es.uca.mps.matrix.core;

public class Opmatrix {

	private static Matrix A;
	private static Matrix B;
	private static Matrix C;
	
	public Opmatrix(Matrix A, Matrix B, Matrix C) {
		if(A.getFilas() != B.getFilas() || A.getFilas() != C.getFilas()) {
			throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
		}
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public static void addMatrix() {
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				int suma = A.getValor(i, j) +  B.getValor(i, j);
				C.setValor(i, j, suma);
			}
		}
	}
	
	public static void subtractionMatrix() {
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				int resta = A.getValor(i, j) -  B.getValor(i, j);
				C.setValor(i, j, resta);
			}
		}
	}
	
	public static void multiplyMatrix() {
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				int mult = 0;
				for(int k = 0; k < A.getFilas(); k++)
					mult += A.getValor(i, k) * B.getValor(k, j);
				C.setValor(i, j, mult);
			}
		}
	}
	
	public static void scalarProductMatrix(int prod) {
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				C.setValor(i, j, prod * A.getValor(i, j));
			}
		}
	}
	
	public static void transposedMatrix() {
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				C.setValor(i, j, A.getValor(j, i));  //Asignamos a C[i][j] el valor de A[j][i]
			}
		}
	}
	
}

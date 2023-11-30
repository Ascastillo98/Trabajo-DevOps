package es.uca.mps.matrix.core;

public class Opmatrix {

	
	 private Opmatrix() {
	        throw new IllegalStateException("Utility class");
	 }
	
	public static void addMatrix(Matrix A, Matrix B, Matrix C) {
		checkMatrix(A, B);
		checkMatrix(A, C);
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				int suma = A.getValor(i, j) +  B.getValor(i, j);
				C.setValor(i, j, suma);
			}
		}
	}
	
	public static void subtractionMatrix(Matrix A, Matrix B, Matrix C) {
		checkMatrix(A, B);
		checkMatrix(A, C);
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				int resta = A.getValor(i, j) -  B.getValor(i, j);
				C.setValor(i, j, resta);
			}
		}
	}
	
	public static void multiplyMatrix(Matrix A, Matrix B, Matrix C) {
		checkMatrix(A, B);
		checkMatrix(A, C);
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				int mult = 0;
				for(int k = 0; k < A.getFilas(); k++)
					mult += A.getValor(i, k) * B.getValor(k, j);
				C.setValor(i, j, mult);
			}
		}
	}
	
	public static void scalarProductMatrix(Matrix A, Matrix C, int prod) {
		checkMatrix(A, C);
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				C.setValor(i, j, prod * A.getValor(i, j));
			}
		}
	}
	
	public static void transposedMatrix(Matrix A, Matrix C) {
		checkMatrix(A, C);
		for(int i = 0; i < A.getFilas(); i++) {
			for(int j = 0; j < A.getColumnas(); j++) {
				C.setValor(i, j, A.getValor(j, i));  //Asignamos a C[i][j] el valor de A[j][i]
			}
		}
	}
	
	private static void checkMatrix(Matrix A, Matrix B) {
		if(A.getFilas() != B.getFilas()) {
			throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
		}
	}
	
}

package es.uca.mps.matrix.core;

/**
 * Hello world!
 *
 */



public class Matrix {
	
	int[][] matrix;
	int filas;
	int columnas;
	
	public Matrix(int[][] valores) {
		this.filas = valores.length;
		this.columnas = valores[0].length;
		this.matrix = new int[filas][columnas];
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				matrix[i][j] = valores[i][j];
			}
		}
	}
	
	public Matrix() {
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public int getFilas() {
		return this.filas;
	}
	
	public int getColumnas() {
		return this.columnas;
	}
	
	public int getValor(int i, int j) {
		return this.matrix[i][j];
	}
	
	public void setValor(int i, int j, int valor) {
		this.matrix[i][j] = valor;
	}
	
}

package es.uca.mps.matrix.core;

import java.util.Arrays;

/**
 * Hello world!
 *
 */



public class Matrix {
	
	int[][] matriz;
	int filas;
	int columnas;
	
	public Matrix(int n, int m, int[][] valores) {
		if(n != m) {
			throw new IllegalArgumentException("Las matrices deben ser cuadradas");
		}
		if(n == 0) {
			throw new IllegalArgumentException("Las matrices no pueden ser nulas");
		}
		if(n != valores[0].length || m != valores.length) {
			throw new IllegalArgumentException("Las dimensiones no coinciden con la matriz");
		}
		
		this.filas = m;
		this.columnas = n;
		this.matriz = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
	        matriz[i] = Arrays.copyOf(valores[i], columnas);
	    }
	}
	
	public Matrix(int dimensiones) {
		this.matriz = new int[dimensiones][dimensiones];
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				matriz[i][j] = 0;
			}
		}
		this.filas = dimensiones;
		this.columnas = dimensiones;
	}
	
	public int getFilas() {
		return this.filas;
	}
	
	public int getColumnas() {
		return this.columnas;
	}
	
	public int getValor(int i, int j) {
		return this.matriz[i][j];
	}
	
	public void setValor(int i, int j, int valor) {
		this.matriz[i][j] = valor;
	}
	
	
	@Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                result.append(getValor(i, j)).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Matrix otherMatrix = (Matrix) obj;
	    if (filas != otherMatrix.filas || columnas != otherMatrix.columnas) {
	        return false;
	    }
	    for (int i = 0; i < filas; i++) {
	        for (int j = 0; j < columnas; j++) {
	            if (matriz[i][j] != otherMatrix.matriz[i][j]) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + filas;
	    result = prime * result + columnas;
	    for (int i = 0; i < filas; i++) {
	        for (int j = 0; j < columnas; j++) {
	            result = prime * result + matriz[i][j];
	        }
	    }
	    return result;
	}


	
}



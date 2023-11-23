package es.uca.mps.matrix.core;

/**
 * Hello world!
 *
 */



public class Matrix {
	
	int[][] matrix;
	int filas;
	int columnas;
	
	public Matrix(int n, int m, int[][] valores) {
		if(n != m) {
			throw new IllegalArgumentException("Las matrices deben ser cuadradas");
		}
		if(n == 0 || m == 0) {
			throw new IllegalArgumentException("Las matrices no pueden ser nulas");
		}
		if(n != valores[0].length || m != valores.length) {
			throw new IllegalArgumentException("Las dimensiones no coinciden con la matriz");
		}
		
		this.filas = m;
		this.columnas = n;
		this.matrix = new int[filas][columnas];
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				matrix[i][j] = valores[i][j];
			}
		}
	}
	
	public Matrix(int dimensiones) {
		this.matrix = new int[dimensiones][dimensiones];
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				matrix[i][j] = 0;
			}
		}
		this.filas = matrix.length;
		this.columnas = matrix[0].length;
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
	
	public void mostrar() {
		for(int i = 0; i < getFilas(); i++) {
			for(int j = 0; j < getColumnas(); j++) {
				System.out.print(getValor(i, j) + " ");
			}
			System.out.println();
		}
		//System.out.println();
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
	            if (matrix[i][j] != otherMatrix.matrix[i][j]) {
	                return false;
	            }
	        }
	    }
	    return true;
	}

	
}



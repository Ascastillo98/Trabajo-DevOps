package es.uca.mps.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import es.uca.mps.matrix.core.Matrix;

class MatrixTest {

	@Test
	void testMatrixInitialization() {
		int dimension = 4;
		int[][] a = new int[][] { {1, 2, 3, 4}, {4, 3, 2, 1}, {7, 7, 7, 7}, {5, 9, 18, 3} };
		Matrix A = new Matrix(dimension, dimension, a);
		
		for(int i = 0; i < dimension; i++) {
			for(int j = 0; j < dimension; j++) {
				assertEquals(a[i][j], A.getValor(i, j));
			}
		}
	}
	
	@Test
	void testInvalidMatrixCreation() {
	    assertThrows(IllegalArgumentException.class, () -> new Matrix(3, 4, new int[][]{{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}}));
	}
	
	@Test
	void testNullMatrixCreation() {
		assertThrows(IllegalArgumentException.class, () -> new Matrix(0, 0, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}
	
	@Test
	void testMatrixCreationWithInconsistentDimensions() {
		assertThrows(IllegalArgumentException.class, () -> new Matrix(4, 4, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}
	
	
	@Test
	void testGetFilasAndColumnas() {
	    int dimension = 3;
	    Matrix matrix = new Matrix(dimension);
	    assertEquals(dimension, matrix.getFilas(), "Incorrect number of filas");
	    assertEquals(dimension, matrix.getColumnas(), "Incorrect number of columnas");
	}
	
	@Test
	void testSetValor() {
	    int dimension = 3;
	    Matrix matrix = new Matrix(dimension);
	    int newValue = 10;
	    matrix.setValor(1, 1, newValue);
	    assertEquals(newValue, matrix.getValor(1, 1), "SetValor did not update the value");
	}


}

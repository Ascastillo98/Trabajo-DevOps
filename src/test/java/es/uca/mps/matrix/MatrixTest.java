package es.uca.mps.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.uca.mps.matrix.core.Matrix;

public class MatrixTest {

    @Test
    public void testMatrixInitialization() {
        int dimension = 4;
        int[][] a = new int[][]{{1, 2, 3, 4}, {4, 3, 2, 1}, {7, 7, 7, 7}, {5, 9, 18, 3}};
        Matrix A = new Matrix(dimension, dimension, a);

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                assertEquals(a[i][j], A.getValor(i, j));
            }
        }
    }

    @Test
    public void testInvalidMatrixCreation() {
        try {
            new Matrix(3, 4, new int[][]{{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}});
            // Si no se lanza la excepción, falla la prueba
            assert false : "Expected IllegalArgumentException, but no exception was thrown.";
        } catch (IllegalArgumentException e) {
            assertEquals("Las matrices deben ser cuadradas", e.getMessage());
        }
    }

    @Test
    public void testNullMatrixCreation() {
        try {
            new Matrix(0, 0, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
            // Si no se lanza la excepción, falla la prueba
            assert false : "Expected IllegalArgumentException, but no exception was thrown.";
        } catch (IllegalArgumentException e) {
            // Se espera una excepción, no se hace nada
        	assertEquals("Las matrices no pueden ser nulas", e.getMessage());
        }
    }

    @Test
    public void testMatrixCreationWithInconsistentDimensions() {
        try {
            new Matrix(4, 4, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
            // Si no se lanza la excepción, falla la prueba
            assert false : "Expected IllegalArgumentException, but no exception was thrown.";
        } catch (IllegalArgumentException e) {
            assertEquals("Las dimensiones no coinciden con la matriz", e.getMessage());
        }
    }

    @Test
    public void testGetFilasAndColumnas() {
        int dimension = 3;
        Matrix matrix = new Matrix(dimension);
        assertEquals(dimension, matrix.getFilas());
        assertEquals(dimension, matrix.getColumnas());
    }

    @Test
    public void testSetValor() {
        int dimension = 3;
        Matrix matrix = new Matrix(dimension);
        int newValue = 10;
        matrix.setValor(1, 1, newValue);
        assertEquals(newValue, matrix.getValor(1, 1));
    }
}

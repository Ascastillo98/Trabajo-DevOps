package es.uca.mps.matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import es.uca.mps.matrix.core.Matrix;
import es.uca.mps.matrix.core.Opmatrix;

public class OpmatrixTest {

    private Matrix A;
    private Matrix B;
    private Matrix C;
    private Opmatrix op;

    @Before
    public void setUp() {
        // Configurar matrices para cada prueba
        int[][] valuesA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] valuesB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        A = new Matrix(3, 3, valuesA);
        B = new Matrix(3, 3, valuesB);
        C = new Matrix(3);
    }

    @Test
    public void testAddMatrix() {
        op.addMatrix(A, B, C);
        Matrix expected = new Matrix(3, 3, new int[][]{{10, 10, 10}, {10, 10, 10}, {10, 10, 10}});
        assertEquals("AddMatrix result is incorrect", expected, C);
    }

    @Test
    public void testSubtractionMatrix() {
        op.subtractionMatrix(A, B, C);
        Matrix expected = new Matrix(3, 3, new int[][]{{-8, -6, -4}, {-2, 0, 2}, {4, 6, 8}});
        assertEquals("SubtractionMatrix result is incorrect", expected, C);
    }

    @Test
    public void testMultiplyMatrix() {
        op.multiplyMatrix(A, B, C);
        Matrix expected = new Matrix(3, 3, new int[][]{{30, 24, 18}, {84, 69, 54}, {138, 114, 90}});
        assertEquals("MultiplyMatrix result is incorrect", expected, C);
    }

    @Test
    public void testScalarProductMatrix() {
        op.scalarProductMatrix(A, C, 2);
        Matrix expected = new Matrix(3, 3, new int[][]{{2, 4, 6}, {8, 10, 12}, {14, 16, 18}});
        assertEquals("ScalarProductMatrix result is incorrect", expected, C);
    }

    @Test
    public void testTransposedMatrix() {
        op.transposedMatrix(A, C);
        Matrix expected = new Matrix(3, 3, new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});
        assertEquals("TransposedMatrix result is incorrect", expected, C);
    }

    @Test
    public void testAddMatrixWithDifferentDimensions() {
        // Configurar matrices con dimensiones diferentes
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{5, 6, 7}, {8, 9, 10}, {11, 12, 13}};
        Matrix A2 = new Matrix(2, 2, valuesA);
        Matrix B2 = new Matrix(3, 3, valuesB);
        Matrix C2 = new Matrix(2);

       

        // Intentar sumar matrices con dimensiones diferentes debería lanzar una excepción
        try {
            op.addMatrix(A2, B2, C2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Se espera una excepción, no se hace nada
        }
    }

    @Test
    public void testMultiplyMatrixCellByCell() {
        op.multiplyMatrixCellByCell(A, B, C);
        Matrix expected = new Matrix(3, 3, new int[][]{{9, 16, 21}, {24, 25, 24}, {21, 16, 9}});
        assertEquals("MultiplyMatrixCellByCell result is incorrect", expected, C);
    }
}

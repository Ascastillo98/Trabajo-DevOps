package es.uca.mps.matrix;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.uca.mps.matrix.core.Matrix;
import es.uca.mps.matrix.core.Opmatrix;

class OpmatrixTest {

    private Matrix A;
    private Matrix B;
    private Matrix C;
    private Opmatrix op;

    @BeforeEach
    void setUp() {
        // Configurar matrices para cada prueba
        int[][] valuesA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] valuesB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        A = new Matrix(3, 3, valuesA);
        B = new Matrix(3, 3, valuesB);
        C = new Matrix(3);
        op = new Opmatrix(A, B, C);
    }

    @Test
    void testAddMatrix() {
        Opmatrix.addMatrix();
        Matrix expected = new Matrix(3, 3, new int[][]{{10, 10, 10}, {10, 10, 10}, {10, 10, 10}});
        assertEquals(expected, C, "AddMatrix result is incorrect");
    }

    @Test
    void testSubtractionMatrix() {
        Opmatrix.subtractionMatrix();
        Matrix expected = new Matrix(3, 3, new int[][]{{-8, -6, -4}, {-2, 0, 2}, {4, 6, 8}});
        assertEquals(expected, C, "SubtractionMatrix result is incorrect");
    }

    @Test
    void testMultiplyMatrix() {
        Opmatrix.multiplyMatrix();
        Matrix expected = new Matrix(3, 3, new int[][]{{30, 24, 18}, {84, 69, 54}, {138, 114, 90}});
        assertEquals(expected, C, "MultiplyMatrix result is incorrect");
    }

    @Test
    void testScalarProductMatrix() {
        Opmatrix.scalarProductMatrix(2);
        Matrix expected = new Matrix(3, 3, new int[][]{{2, 4, 6}, {8, 10, 12}, {14, 16, 18}});
        assertEquals(expected, C, "ScalarProductMatrix result is incorrect");
    }

    @Test
    void testTransposedMatrix() {
        Opmatrix.transposedMatrix();
        Matrix expected = new Matrix(3, 3, new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});
        assertEquals(expected, C, "TransposedMatrix result is incorrect");
    }

    
    @Test
    void testAddMatrixWithDifferentDimensions() {
        // Configurar matrices con dimensiones diferentes
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{5, 6, 7}, {8, 9, 10}, {11, 12, 13}};  
        Matrix A2 = new Matrix(2, 2, valuesA);
        Matrix B2 = new Matrix(3, 3, valuesB);
        Matrix C2 = new Matrix(2);

        Opmatrix op;  // Usar la instancia creada como miembro

        // Intentar sumar matrices con dimensiones diferentes debería lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> new Opmatrix(A2, B2, C2));
    }
}

package br.com.junitsetup.IVetorUtil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Teste {
    /* 
    Testes realizados para os metodos    
    1° A e B com mesma quantidade de elementos no array
    2° A e B com quantidade de elementos diferentes no array A maior que B
    3° A e B com quantidade de elementos diferentes no array B maior que A
    4° A e B com quantidade de elementos diferentes no array A com nenhum elemento
    5° A e B com quantidade de elementos diferentes no array B com nenhum elemento
    6° A ou B com entrada de null
    */

    private final IVetorUtilAluno vetorUtil = new IVetorUtilAluno();

    @Nested
    class TesteMetodoCopiarValores{
    
        @Test
        @DisplayName("Copia os valores do array A para o array B (A=B)")
        public void testCopiarValoresAIgualB() {
            int[] a = {1,2,3};
            int[] b = {0, 0, 0};
            
            int [] resultado = vetorUtil.copiarValores(a, b);
            assertArrayEquals(new int[] {1,2,3}, resultado);
        }
    
        @Test
        @DisplayName("Copia os valores do array A para o array B (A>B)")
        public void testCopiarValoresAMaiorQueB() {
            int[] a = {1, 2, 3};
            int[] b = {0};
            
            int [] resultado = vetorUtil.copiarValores(a, b);
            assertArrayEquals(new int[] {1}, resultado);
        }
    
        @Test
        @DisplayName("Copia os valores do array A para o array B (B>A)")
        public void testCopiarValoresBMaiorQueA() {
            int[] a = {1};
            int[] b = {0, 0, 0};
    
            int [] resultado = vetorUtil.copiarValores(a, b);
            assertArrayEquals(new int[] {1, 0, 0}, resultado);
        }

        @Test
        @DisplayName("Copia os valores do array A para o array B (A=0)")
        public void testCopiarValoresASemElemento() {
            int[] a = {};
            int[] b = {0, 0, 0};
    
            int [] resultado = vetorUtil.copiarValores(a, b);
            assertArrayEquals(new int[] {0,0,0}, resultado);
        }

        @Test
        @DisplayName("Copia os valores do array A para o array B (B=0)")
        public void testCopiarValoresBSemElemento() {
            int[] a = {1,2,3};
            int[] b = {};

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                vetorUtil.copiarValores(a, b);});
            assertEquals("O tamanho de b não pode ser 0", exception.getMessage());
        }

        @Test
        @DisplayName("Copia os valores do array A para o array B (algum null)")
        public void testCopiarValoresUmNull() {
            int[] a = null;
            int[] b = {1, 2};

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                vetorUtil.copiarValores(a, b);});
            assertEquals("Arrays não podem ser nulos", exception.getMessage());
        }
    }
    
    @Nested
    class TesteMetodoCopiarValoresInverso{

        @Test
        @DisplayName("Copia os valores do array A para o array B de forma inversa (A=B)")
        public void testCopiarValoresInversoAIgualB() {
            int[] a = {1, 2, 3};
            int[] b = {0, 0, 0};
            
            int[] resultado = vetorUtil.copiarValoresInverso(a, b);
            assertArrayEquals(new int[] {3, 2, 1}, resultado);
        }

        @Test
        @DisplayName("Copia os valores do array A para o array B de forma inversa (A>B)")
        public void testCopiarValoresInversoAMaiorQueB() {
            int[] a = {1, 2, 3};
            int[] b = {0};
            
            int[] resultado = vetorUtil.copiarValoresInverso(a, b);
            assertArrayEquals(new int[] {3}, resultado);
        }

        @Test
        @DisplayName("Copia os valores do array A para o array B de forma inversa (B>A)")
        public void testCopiarValoresInversoBMaiorQueA() {
            int[] a = {1};
            int[] b = {0, 0, 0};

            int[] resultado = vetorUtil.copiarValoresInverso(a, b);            
            assertArrayEquals(new int[] {1, 0, 0}, resultado);
        }

        @Test
        @DisplayName("Copia os valores do array A para o array B de forma inversa (A=0)")
        public void testCopiarValoresInversoASemElemento() {
            int[] a = {};
            int[] b = {0, 0, 0};
    
            int [] resultado = vetorUtil.copiarValores(a, b);
            assertArrayEquals(new int[] {0,0,0}, resultado);
        }

        @Test
        @DisplayName("Copia os valores do array A para o array B de forma inversa (B=0)")
        public void testCopiarValoresInversoBSemElemento() {
            int[] a = {1,2,3};
            int[] b = {};

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                vetorUtil.copiarValores(a, b);});
            assertEquals("O tamanho de b não pode ser 0", exception.getMessage());
        }


        @Test
        @DisplayName("Copia os valores do array A para o array B de forma inversa (algumm null)")
        public void testCopiarValoresInversoUmNull() {
            int[] a = {1, 2};
            int[] b = null;

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                vetorUtil.copiarValoresInverso(a, b);});
            assertEquals("Arrays não podem ser nulos", exception.getMessage());
        }

    }

    @Nested
    class TesteMetodoSomarVetores{
        
        @Test
        @DisplayName("Somar os valores de A e B (B=A)")
        public void testSomarVetoresAIgualB() {
            int[] a = {1, 2, 3};
            int[] b = {1, 2, 3};
            
            int resultado = vetorUtil.somarVetores(a, b);
            assertEquals(12,resultado);
        }

        @Test
        @DisplayName("Somar os valores de A e B (A>B)")
        public void testSomarVetoresAMaiorQueB() {
            int[] a = {1, 2, 3};
            int[] b = {1, 2};
        
            int resultado = vetorUtil.somarVetores(a, b);
            assertEquals(9,resultado);
        }

        @Test
        @DisplayName("Somar os valores de A e B (B>A)")
        public void testSomarVetoresBMaiorQueA() {
            int[] a = {1};
            int[] b = {1, 2, 3};
            
            int resultado = vetorUtil.somarVetores(a, b);
            assertEquals(7,resultado);
        }

        @Test
        @DisplayName("Somar os valores de A e B (A=0)")
        public void testSomarVetoresASemElemento() {
            int[] a = {};
            int[] b = {2, 2, 3};

            int resultado = vetorUtil.somarVetores(a, b);
            assertEquals(7,resultado);
        }

        @Test
        @DisplayName("Somar os valores de A e B (B=0)")
        public void testSomarVetoresBSemElemento() {
            int[] a = {1,2,3};
            int[] b = {};

            int resultado = vetorUtil.somarVetores(a, b);
            assertEquals(6,resultado);
        }

        @Test
        @DisplayName("Somar os valores de A e B (algum null)")
        public void testSomarVetoresUmNull() {
            int[] a = {1, 2};
            int[] b = null;

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                vetorUtil.somarVetores(a, b);});
            assertEquals("Arrays não podem ser nulos", exception.getMessage());
        }
    }

    @Nested
    class TesteMetodoIntercalarElementos{

        @Test
        @DisplayName("Intercalar os valores de A e B (B=A)")
        public void testIntercalarElementosAIgualB() {
            int[] a = {1, 3, 5};
            int[] b = {2, 4, 6};
        
            int[] resultado = vetorUtil.intercalarElementos(a, b);
            assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6},resultado);
        }

        @Test
        @DisplayName("Intercalar os valores de A e B (A>B)")
        public void testIntercalarElementosAMaiorQueB() {
            int[] a = {1, 3, 5};
            int[] b = {2, 4};
        
            int[] resultado = vetorUtil.intercalarElementos(a, b);
            assertArrayEquals(new int[] {1, 2, 3, 4, 5},resultado);       
        }

        @Test
        @DisplayName("Intercalar os valores de A e B (B>A)")
        public void testIntercalarElementosBMaiorQueA() {
            int[] a = {1};
            int[] b = {2, 4, 6};
            
            int[] resultado = vetorUtil.intercalarElementos(a, b);
            assertArrayEquals(new int[] {1, 2, 4, 6},resultado);        
        }

        @Test
        @DisplayName("Intercalar os valores de A e B (A=0)")
        public void testIntercalarElementosASemElemento() {
            int[] a = {};
            int[] b = {2, 2, 3};

            int[] resultado = vetorUtil.intercalarElementos(a, b);
            assertArrayEquals(new int[] {2, 2, 3},resultado);
        }

        @Test
        @DisplayName("Intercalar os valores de A e B (B=0)")
        public void testIntercalarElementosBSemElemento() {
            int[] a = {1,2,3};
            int[] b = {};

            int[] resultado = vetorUtil.intercalarElementos(a, b);
            assertArrayEquals(new int[] {1, 2, 3},resultado);
        }

        @Test
        @DisplayName("Intercalar os valores de A e B (algum null)")
        public void testIntercalarElementosUmNull() {
            int[] a = {1, 2};
            int[] b = null;

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                vetorUtil.intercalarElementos(a, b);});
            assertEquals("Arrays não podem ser nulos", exception.getMessage());
        }
    }
}

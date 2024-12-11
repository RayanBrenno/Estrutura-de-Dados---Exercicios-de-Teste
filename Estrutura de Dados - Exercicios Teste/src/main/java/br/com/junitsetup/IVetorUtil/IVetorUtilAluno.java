package br.com.junitsetup.IVetorUtil;

public class IVetorUtilAluno implements IVetorUtil {

    public int[] copiarValores(int[] a, int[] b) {
        if (a == null || b == null) throw new RuntimeException("Arrays não podem ser nulos");
        else if (a.length == 0) return b;
        else if (b.length == 0) throw new RuntimeException("O tamanho de b não pode ser 0");
        else {
            for (int i = 0; i < a.length; i++) {
                if (i < b.length){
                    b[i] = a[i];
                }
            }
            return b; 
        }
    }

    public int[] copiarValoresInverso(int[] a, int[] b) {
        if (a == null || b == null) throw new RuntimeException("Arrays não podem ser nulos");
        if (a.length == 0) return b;
        else if (b.length == 0) throw new RuntimeException("O tamanho de b não pode ser 0");  
        else{
            for (int i = 0; i < a.length; i++) {
                if (i < b.length){
                    b[i] = a[a.length - 1 - i];
                }
            }
            return b;
        }
    }   

    public Integer somarVetores(int[] a, int[] b) {
        if (a == null || b == null) throw new RuntimeException("Arrays não podem ser nulos");
        int soma = 0;
        int maxLength = Math.max(a.length,b.length);
        for (int i = 0; i < maxLength; i++) {
            if (i < a.length) {
                soma += a[i];
            }
            if (i < b.length) {
                soma += b[i];
            }
        }
        return soma;
    }

    public int[] intercalarElementos(int[] a, int[] b) {
        if (a == null || b == null) throw new RuntimeException("Arrays não podem ser nulos");
        int[] intercalado = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        // '++' utiliza o valor inicial para realizar a operação e dps soma +1
        while (i < a.length && j < b.length) {
            intercalado[k++] = a[i++]; 
            intercalado[k++] = b[j++]; 
        }
        while (i < a.length) {
            intercalado[k++] = a[i++];
        }
        while (j < b.length) {
            intercalado[k++] = b[j++];
        }

        /* 
        int minLength = Math.min(a.length, b.length);
        int k = 0;
        for (int i = 0; i < minLength; i++) {
            intercalado[k++] = a[i];
            intercalado[k++] = b[i];
        }
        if (a.length > minLength) System.arraycopy(a, minLength, intercalado, k, a.length - minLength);
        else if (b.length > minLength) System.arraycopy(b, minLength, intercalado, k, b.length - minLength);
        */ 
        
        return intercalado;
    }
    
}

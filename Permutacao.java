package src;

public class Permutacao {


    static void permutar(int primeira_linha, int segunda_linha, double[][] a){
        for (int j = 0; j < a[0].length; j++) {
            double aux = a[primeira_linha][j];
            a[primeira_linha][j] = a[segunda_linha][j];
            a[segunda_linha][j] = aux;
        }
    }

    static int validarOperacaoPermuta(int linha, int coluna, double[][] a) {
        for(int i = linha + 1; i < a.length; i++){
            if(a[i][coluna] != 0) {
                return i;
            }
        }
        return -1;
    }
}

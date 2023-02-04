package src;

public class Determinante {
    static void obterCofator(double[][] matriz, double[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        for (int fila = 0; fila < n; fila++) {
            for (int coluna = 0; coluna < n; coluna++) {
                if (fila != p && coluna != q) {
                    temp[i][j++] = matriz[fila][coluna];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }//termina o cofator

    static double determinanteDaMatriz(double[][] matriz, int n) {
        double Determinante = 0.0;
        if (n == 1) {
            return matriz[0][0];
        }
        double temp[][] = new double[n][n];
        double Multiplicador = 1;
        for (int f = 0; f < matriz.length; f++) {
            obterCofator(matriz, temp, 0, f, n);
            Determinante += Multiplicador * matriz[0][f] * determinanteDaMatriz(temp, n - 1);
            Multiplicador = -Multiplicador;
        }
        return Determinante;
    }
}
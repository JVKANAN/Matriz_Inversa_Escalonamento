package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Lembre-se, a matriz deve ser quadrada");

        System.out.println("Tamanho da matriz: ");
        int n = sc.nextInt();

        double matrizA [][] = new double[n][n];
        double matrizIndent[][] = new double[n][n] ;

        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                int ii = i+1;
                int jj = j+1;
                System.out.println("Insira os valores de a" + ii + jj + ":");
                matrizA[i][j] = sc.nextInt();
                matrizIndent[i][j] = 0;

                if(i==j){
                    matrizIndent[i][j] = 1;
                }
            }
        }

        double det = Determinante.determinanteDaMatriz(matrizA, n);

        System.out.println("---------------------------------");
        System.out.println("Determinante da Matriz Inserida: "+ det);
        System.out.println("---------------------------------");



        if(det != 0){

            Inversa.matInversa(n, matrizA, matrizIndent);
        }else{
            System.out.println("O determinante da matriz é 0\nPortanto, não possuí inversa");
        }






    }
}

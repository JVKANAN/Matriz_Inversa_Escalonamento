package src;

import java.util.Scanner;

public class Inversa {

    static void matInversa(int n, double[][] matrizA, double[][] matrizIndent ){

        double pivor;
        //matriz expandida

        int varAux ;
        double[][] matrizTest = new double[matrizA.length][ 2 * matrizA.length];


        //Adiciona os elementos da matriz A e da matriz Indentidade na matriz Expandida
        for(int lin = 0; lin <matrizTest.length; lin++){
            varAux = 0;
            for(int col = 0 ; col <matrizTest[lin].length; col++){
                if(col >= matrizA.length){
                    matrizTest[lin][col] = matrizIndent[lin][varAux];
                    varAux++;
                }else{
                    matrizTest[lin][col] = matrizA[lin][col];
                }
            }
        }

        //começa a calcular os pivores e fazer a permutação caso necessário

        for(int diagonalP = 0; diagonalP < matrizA.length; diagonalP++){
            if(matrizTest[diagonalP][diagonalP] != 1){

                if(matrizTest[diagonalP][diagonalP] != 0){
                    pivor = matrizTest[diagonalP][diagonalP];
                    for(int divPivor = 0; divPivor < matrizTest[diagonalP].length; divPivor++){
                        matrizTest[diagonalP][divPivor] = matrizTest[diagonalP][divPivor]/pivor;
                    }
                }

                else{
                    Permutacao.permutar(diagonalP, Permutacao.validarOperacaoPermuta(diagonalP, diagonalP,matrizTest), matrizTest);
                    pivor = matrizTest[diagonalP][diagonalP];
                    for(int divPivor = 0; divPivor < matrizTest[diagonalP].length; divPivor++){
                        matrizTest[diagonalP][divPivor] = matrizTest[diagonalP][divPivor]/pivor;
                    }

                }
            }
            //for responsável por zerar os elementos abaixo do pivor.

            for(int zerar = diagonalP+1; zerar< matrizTest.length; zerar++ ){
                if(matrizTest[zerar][diagonalP] != 0){
                    double pElemento = matrizTest[zerar][diagonalP];

                    for(int c = 0; c < matrizTest[zerar].length; c++){
                        matrizTest[zerar][c] = matrizTest[zerar][c] - pElemento * matrizTest[diagonalP][c];
                    }
                }

            }
        }

        //zerar os elementos da coluna acima do pivor

        int varcolum = matrizA[0].length -1;

        for(int w = matrizTest.length-1; w > 0; w--){

            for(int y = w-1; y>=0; y--){
                if(matrizTest[y][varcolum] != 0){
                    double uElemento = matrizTest[y][varcolum];

                    for(int u =0 ; u<matrizTest[y].length; u++){
                        matrizTest[y][u] = matrizTest[y][u] - uElemento * matrizTest[w][u];
                    }
                }
            }
            varcolum --;

        }

        System.out.println ("Matriz Inserida = ");
            for(int i=0;i< matrizA.length;i++){
                for(int j=0;j< matrizA.length;j++){
                    System.out.print ("|"+ matrizA[i][j] +"|");
                }
                System.out.println ();
            }
            System.out.println("---------------------------------");
            System.out.println ("Inversa Indentidade = ");
            for(int i=0;i< matrizA.length;i++){
                for(int j=0;j< matrizA.length;j++){
                    System.out.print ("|"+ matrizTest[i][j] +"|");
                }
                System.out.println ();
            }
            System.out.println("---------------------------------");

            System.out.println("Inversa da Matriz = ");

        for(int i=0;i< matrizA.length;i++){
            for(int j=matrizA.length; j< matrizTest[i].length; j++){
                System.out.print ("|"+ matrizTest[i][j] +"|");
            }
            System.out.println ();
        }
        }//fim da chave
    }

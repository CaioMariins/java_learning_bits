import java.util.Scanner;
public class Entre1E100 {
    public static String Entre(int numInicial, int numFinal, int num){
        String resultado;

        //Se o valor "num" - o valor "numInicial" der um número negativo
        //quando eu mover ele 31 casas bit, o resultado dele sera 1
        //pois somente números negativos ou números muitos grandes positivamente que 
        //possuem 1 na casa 32 do bit, assim quando eu andar 31 casas para direita ainda terá 1 bit
        //resultando o valor 1.
        if ((num - numInicial) >> 31 == 0 && (numFinal - num) >> 31 == 0) {
            resultado = " está entre ";
          } else {
            resultado = " não está entre ";
          }

        return resultado;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.println ("Entre com um número");
        int num = entrada.nextInt ();

        String resultado = Entre(1, 100, num);

        System.out.println("o número " + num + resultado + " 1 e 100" );

        entrada.close();
    }
}
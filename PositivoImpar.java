import java.util.Scanner;
public class PositivoImpar{
    public static boolean Positivo_Impar(int num) {
        boolean resultado;
        String ultimoNumero = Integer.toBinaryString(num);

        // todo numero ímpar é 1 no final
        if(ultimoNumero .charAt(ultimoNumero .length()-1) == '1'){
            
            // estou jogando o 1 para o final, já que um número inteiro tem 32 "casas bit"
            // e o número inserido quando for feito o AND já com o valor 1 deslocado para casa 31
            // irei ter o 0 se for positivo
            // ja que o AND só adiciona 1 se for 1 na mesma casa bit em ambos números
            // assim só um número muito grande positivamente que ocupasse todas as casas bit 
            // ou um número negativo que o resuldado daria 1
            
            if ((num & (1 << 31)) == 0) {
                resultado = true;
            }else{
                resultado = false;
            }
            
        } else {
            resultado = false;
        }

        return resultado;
    }
    public static void main (String[] args){
        Scanner entrada = new Scanner (System.in);
        System.out.println ("Entre com um número");
        int num = entrada.nextInt ();
        
        boolean resultado = Positivo_Impar(num);

        if(resultado == true){
            System.out.println("O numero é positivo e ímpar!" );
        } else {
            System.out.println("O numero não tem o resultado desejado!" );

        entrada.close();
        } 
    }
}
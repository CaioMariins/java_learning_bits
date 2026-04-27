public class calculadora{

        // | 
        // 1 + 1 = 1 
        // 0 + 1 ou 1 + 0 = 1 
        // 0 + 0 = 0


        // & 
        // 1 + 1 = 1 
        // 0 + 1 ou 1 + 0 = 0 
        // 0 + 0 = 0


        //  ^    
        //  1 + 1 = 0 
        //  0 + 0 = 0 
        //  1 + 0 ou 0 + 1 = 1


    public static int soma(int a, int b){
        int soma =0;
        while(b != 0 ){
            soma = a ^ b; 
            b = (a & b) << 1;
            a = soma;
        }

        return soma;
    }

    public static int subtrair(int a, int b){
        int subtracao = 0;
        while (b != 0){

            subtracao = a & b; //reduzimos b salvando na variavel

            a = a^b;  // aumentamos a com o xor.

            b = (a & b) << 1; // b recebe o resultado da diminuição andando uma casa para esquerda.

            subtracao = a; // atualizamos o valor da soma para a.
        }
        return subtracao;
    }
    
    public static int multiplica(int a, int b){
        int multi = 0;
        while( b != 0){
           b = subtrair(b, 1);
           multi = soma(multi, a);
        }
        return multi;
    }
    
    public static int divide(int a, int b){ // quantas vezes o valor B multiplicado vai ser igual a A?
        int v = 0;
        int count = 0;
        while(v != a){
            v = soma(v,b);
            count += 1;
            }
        return count;
        }

    public static void main(String arg[]){
        int a = 16;
        int b = 4;

        //int soma = 0;
        
        //while(b != 0){ // como a receberá a soma do looping anterior, quando b for 0 significará que a chegou ao resultado final
        //soma = a ^ b; //executa o or exclusivo entre os bits e salva na soma
        //System.out.println("soma" + Integer.toBinaryString(soma));
        //    b = soma << 1; //andamos 1 casa para esquerda para soma
        //    )
        //}
        System.out.println("Subtracao:");
        System.out.println(subtrair(a,b));
        System.out.println("Soma");
        System.out.println(soma(a,b));
        System.out.println("Multiplicação");
        System.out.println(multiplica(a,b));
        System.out.println("Divisão");
        System.out.println(divide(a,b));

        //System.out.println("a:" + Integer.toBinaryString(a));
        //System.out.println("b:" + Integer.toBinaryString(b));
        //System.out.println("soma" + Integer.toBinaryString(soma));

    }
}
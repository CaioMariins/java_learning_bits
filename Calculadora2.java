public class Calculadora2 {
    public static void main(String[] args){
        int a = 16;
        int b = 4;

        System.out.println("\n");

        //adição
        System.out.println("Adição:");
        System.out.println(somar(a,b));
        System.out.println("=================");
        //subtração
        System.out.println("Subtraão:");
        System.out.println(diminuir(a,b));
        System.out.println("=================");

        //multiplicação
        System.out.println("Multiplicar:");
        System.out.println(multiplicar(a,b));
        System.out.println("=================");

        //divisão

        System.out.println("Dividir:");
        System.out.println(dividir(a,b));
        System.out.println("=================");
    }

    public static int somar(int valor1, int valor2){
        int soma = 0;

        while (valor2 != 0) {

            //na variável "soma" estamos acionando os "1" nos "0", 
            //e estamos zerando quando os dois da mesma casa forem "1",
            //assim estamos adicionando um valor na variavel "soma"

            soma = valor1 ^ valor2;

            //estamos verificando quais numeros foram zerados, na variavel soma, 
            //e deslocando um bit para esquerda, para que seja adicionado a uma casa a frente. 
            //Isso será feito ate não ter mais nenhum "1", 
            //assim o valor da variavel "valor2" sera 0 e parando o loop

            valor2 = (valor1 & valor2) << 1;

            //definindo o valor da variavel "soma" na variavel "valor1" 
            //para que agora seja o loop seja trabalhado em cima no novo valor 

            valor1 = soma;
        }
        return soma;
    }


    public static int diminuir(int valor1, int valor2){
        while (valor2 != 0) {
            
            //na variável "valor1" estamos acionando os "1" nos "0", 
            //e estamos zerando quando os dois da mesma casa for "1", 
            //assim estamos adicionando um valor na variavel "valor1"
            //quase igual como fizemos na função somar, so que a diferença e que setamos 
            //o valor diretamente na variavel "valor1"

            valor1 = valor1 ^ valor2;

            //aqui nos estamos verificando quais casas vamos remover na frente, 
            //nesse caso na esquerda, vamos pegar todos os "1" que estão na mesma casa bit das duas variaveis, 
            //e jogamos para esquera, para que no loop seguinte, se necessário, 
            //zerarmos os "1" necessários para subtrair

            valor2 = (valor1 & valor2) << 1;
        }
        return valor1;
    }

    //estamos diminuindo o "valor2" para que cada vez que ele seja diminuído, 
    //a variável "multi" seja somado pela variável "valor1", 
    //assim vai ser somado o "valor1" quantas vezes o loop rodar, 
    //que nesse caso o vai ser o valor da variável "valor2"

    public static int multiplicar(int valor1, int valor2){
        int multi = 0;
        while (valor2 != 0) {

            valor2 = diminuir(valor2, 1);
            multi = somar(multi, valor1);
        }
        return multi;
    }

    //estamos somando a variável "div" com + 1 para que cada vez que ele seja somado, 
    //a variável "valor1" seja subtraído pela variavel "valor2", 
    //assim vai ser somado o "div" + 1 quantas vezes o loop rodar, 
    //que nesse caso o vai ser enquanto o valor da variável "valor1" for maior ou igual ao valor da variável "valor2"

    public static int dividir(int valor1, int valor2){
        int div = 0;
        while (valor1 >= valor2) {
            valor1 = diminuir(valor1 , valor2);
            div = somar(div, 1);
        }
        return div;
    }
}

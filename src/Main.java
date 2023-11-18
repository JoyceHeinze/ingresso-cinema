import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] sala = {
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 5, 4},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 8, 8, 8, 8, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 4, 5, 4, 5, 6, 2, 2, 7, 2, 2, 6, 1, 5, 4, 6, 7},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                {7, 8, 8, 1, 1, 1, 1, 1, 7, 1, 8, 8, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 8, 8, 8, 8, 7, 1, 1, 1, 8, 8, 8, 8, 7},
                {7, 6, 6, 3, 5, 5, 3, 3, 5, 1, 5, 3, 3, 5, 1, 6, 7},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                {1, 1, 1, 1, 8, 8, 1, 1, 7, 1, 1, 8, 8, 1, 6, 2, 2},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                {0},
        };

        String fileira = "NLKJIHGFEDCBA ";

        int opcaoIngresso = exibeOpcoesIngresso();
        exibeSala(sala, fileira);
        sala = selecionaPoltrona(sala, fileira, opcaoIngresso);
        exibeSala(sala, fileira);
        novoIngresso(sala, fileira);
    }

    public static int exibeOpcoesIngresso() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Por favor, informe a numeração da categoria de ingresso desejada:");
        System.out.println("1: Normal | 2: Conforto | 3: Pessoa com Deficiência | 4: Obeso | 5: Acompanhante");

        int categoriaEscolhida = scan.nextInt();

        switch (categoriaEscolhida) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return categoriaEscolhida;
            default:
                System.out.println("Ops! Não foi possível encontrar uma poltrona para a categoria desejada.");
        }
        return 0;
    }

    public static void exibeSala(int[][] sala, String fileira) {
        System.out.println("Disponibilidade de lugares na sala: \n");
        System.out.println("Legenda: C: CONDIÇÃO | 8 - Ocupado | 1 - Normal | 2 - Conforto | 3 - Pessoa com Deficiência | 4 - Obeso | 5 - Acompanhante | 6 - área indisponível | 7 - corredor \n");

        for (int i = 0; i < sala.length; i++) {
            System.out.print(fileira.charAt(i) + " ");
            for (int j = 0; j < sala[i].length; j++) {
                if (i == sala.length - 1) {
                    System.out.println("_______________________________________________________________________________________________TELA__________________________________________________________________________________________________");
                } else {
                    System.out.print(" |" + (j) + fileira.charAt(i) + " C: " + sala[i][j] + "| ");
                }
            }
            System.out.print(" " + fileira.charAt(i) + "\n");
        }
    }

    public static int[][] selecionaPoltrona(int[][] sala, String fileira, int opcaoIngresso) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Por favor, selecione o número da poltrona desejada:");
        int numeroPoltronaSelecionada = scan.nextInt();

        System.out.println("Por favor, selecione a letra da poltrona desejada:");
        String letraPoltronaSelecionada = scan.next().toUpperCase();

        System.out.print("\n");

        int categoriaPoltronaSelecionada = sala[fileira.indexOf(letraPoltronaSelecionada)][numeroPoltronaSelecionada];

        if (categoriaPoltronaSelecionada == opcaoIngresso) {
            switch (categoriaPoltronaSelecionada) {
                case 1:
                    System.out.println("Você acabou de adquirir um ingresso para a categoria: 1 - Normal.");
                    break;
                case 2:
                    System.out.println("Você acabou de adquirir um ingresso para a categoria: 2 - Conforto.");
                    break;
                case 3:
                    System.out.println("Você acabou de adquirir um ingresso para a categoria: 3 - Pessoa com Deficiência.");
                    break;
                case 4:
                    System.out.println("Você acabou de adquirir um ingresso para a categoria: 4 - Obeso.");
                    break;
                case 5:
                    System.out.println("Você acabou de adquirir um ingresso para a categoria: 5 - Acompanhante.");
                    break;
                default:
                    System.out.println("Ops, não encontramos a categoria desejada!");
            }

            System.out.println("\n" + "Confira sua poltrona selecionada: " + numeroPoltronaSelecionada + letraPoltronaSelecionada);
            sala[fileira.indexOf(letraPoltronaSelecionada)][numeroPoltronaSelecionada] = 8;
        } else {
            if (categoriaPoltronaSelecionada == 8) {
                System.out.println("Lamentamos, mas a poltrona " + letraPoltronaSelecionada + numeroPoltronaSelecionada + " já está ocupada!");
            } else if (categoriaPoltronaSelecionada == 6 || categoriaPoltronaSelecionada == 7) {
                System.out.println("Lamentamos, mas esta categoria não está disponível para compra.");
            } else {
                System.out.println("Lamentamos, mas a poltrona " + letraPoltronaSelecionada + numeroPoltronaSelecionada + " não é compátivel com a categoria do seu ingresso.");
            }
        }
        System.out.print("\n");
        return sala;
    }

    public static void novoIngresso(int[][] sala, String fileira) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Deseja continuar comprando? Se sim, digite 1, senão digite 0");
        int continuarCompra = scan.nextInt();

        if (continuarCompra == 1) {
            int opcaoIngresso = exibeOpcoesIngresso();
            exibeSala(sala, fileira);
            sala = selecionaPoltrona(sala, fileira, opcaoIngresso);
            exibeSala(sala, fileira);
            novoIngresso(sala, fileira);
        } else if (continuarCompra == 0) {
            System.out.println("Agradecemos e esperamos que tenha aproveitado a experiência! até a próxima :)");
        }
    }
}
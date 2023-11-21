import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] sala = {
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 5, 4},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 4, 5, 4, 5, 6, 2, 2, 7, 2, 2, 6, 1, 5, 4, 6, 7},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 7},
                {7, 6, 6, 3, 5, 5, 3, 3, 5, 1, 5, 3, 3, 5, 1, 6, 7},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                {1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 6, 2, 2},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
                {0},
        };

        String fileira = "LKJIHGFEDCBA  ";

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
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED_BACKGROUND = "\u001B[41m";
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        final String ANSI_BRIGHT_BLACK_BACKGROUND = "\u001B[100m";

        System.out.println("\nDisponibilidade de lugares na sala:");
        System.out.println("Legenda:");
        System.out.printf("%s Ocupado %s | %s Normal %s | %s Conforto %s | %s Pessoa com Deficiência %s | %s Obeso %s | %s Acompanhante %s\n",
                ANSI_RED_BACKGROUND, ANSI_RESET, ANSI_GREEN_BACKGROUND, ANSI_RESET, ANSI_BLUE_BACKGROUND, ANSI_RESET, ANSI_PURPLE_BACKGROUND, ANSI_RESET, ANSI_YELLOW_BACKGROUND, ANSI_RESET, ANSI_BRIGHT_BLACK_BACKGROUND, ANSI_RESET);
        System.out.println();

        for (int i = 0; i < sala.length; i++) {
            System.out.print(fileira.charAt(i) + " ");
            for (int j = 0; j < sala[i].length; j++) {
                if (i == sala.length - 1) {
                    System.out.println("____________________________________________________TELA____________________________________________________");
                } else {
                    switch (sala[i][j]) {
                        case 1:
                            System.out.print(" |" + ANSI_GREEN_BACKGROUND + (j) + fileira.charAt(i) + ANSI_RESET + "| ");
                            break;
                        case 2:
                            System.out.print(" |" + ANSI_BLUE_BACKGROUND + (j) + fileira.charAt(i) + ANSI_RESET + "| ");
                            break;
                        case 3:
                            System.out.print(" |" + ANSI_PURPLE_BACKGROUND + (j) + fileira.charAt(i) + ANSI_RESET + "| ");
                            break;
                        case 4:
                            System.out.print(" |" + ANSI_YELLOW_BACKGROUND + (j) + fileira.charAt(i) + ANSI_RESET + "| ");
                            break;
                        case 5:
                            System.out.print(" |" + ANSI_BRIGHT_BLACK_BACKGROUND + (j) + fileira.charAt(i) + ANSI_RESET + "| ");
                            break;
                        case 6:
                        case 7:
                            if (j < 10) {
                                System.out.print("      ");
                            } else {
                                System.out.print("       ");
                            }
                            break;
                        case 8:
                            System.out.print(" |" + ANSI_RED_BACKGROUND + (j) + fileira.charAt(i) + ANSI_RESET + "| ");
                            break;
                        default:
                            System.out.print(" |" + (j) + fileira.charAt(i) + "| ");
                    }
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
            final String ANSI_RESET = "\u001B[0m";
            final String ANSI_RED_BACKGROUND = "\u001B[41m";
            final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
            final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
            final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
            final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
            final String ANSI_BRIGHT_BLACK_BACKGROUND = "\u001B[100m";

            switch (categoriaPoltronaSelecionada) {
                case 1:
                    System.out.printf("Você acabou de adquirir um ingresso para a categoria: %sNormal%s.", ANSI_GREEN_BACKGROUND, ANSI_RESET);
                    break;
                case 2:
                    System.out.printf("Você acabou de adquirir um ingresso para a categoria: %sConforto%s.", ANSI_BLUE_BACKGROUND, ANSI_RESET);
                    break;
                case 3:
                    System.out.printf("Você acabou de adquirir um ingresso para a categoria: %sPessoa com Deficiência%s.", ANSI_PURPLE_BACKGROUND, ANSI_RESET);
                    break;
                case 4:
                    System.out.printf("Você acabou de adquirir um ingresso para a categoria: %sObeso%s.", ANSI_YELLOW_BACKGROUND, ANSI_RESET);
                    break;
                case 5:
                    System.out.printf("Você acabou de adquirir um ingresso para a categoria: %sAcompanhante%s.", ANSI_BRIGHT_BLACK_BACKGROUND, ANSI_RESET);
                    break;
                default:
                    System.out.printf("%sOps, não encontramos a categoria desejada!%s", ANSI_RED_BACKGROUND, ANSI_RESET);
            }
            System.out.printf(" Confira sua poltrona selecionada: %s" + numeroPoltronaSelecionada + letraPoltronaSelecionada + "%s \n", ANSI_RED_BACKGROUND, ANSI_RESET);
            sala[fileira.indexOf(letraPoltronaSelecionada)][numeroPoltronaSelecionada] = 8;
        } else {
            if (categoriaPoltronaSelecionada == 8) {
                System.out.println("Lamentamos, mas a poltrona " + numeroPoltronaSelecionada + letraPoltronaSelecionada + " já está ocupada!");
            } else if (categoriaPoltronaSelecionada == 6 || categoriaPoltronaSelecionada == 7) {
                System.out.println("Lamentamos, mas esta categoria não está disponível para compra.");
            } else {
                System.out.println("Lamentamos, mas a poltrona " + numeroPoltronaSelecionada + letraPoltronaSelecionada + " não é compátivel com a categoria do seu ingresso.");
            }
        }
        return sala;
    }

    public static void novoIngresso(int[][] sala, String fileira) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Deseja continuar comprando? Se sim: digite 1 | Se não: digite 0");
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
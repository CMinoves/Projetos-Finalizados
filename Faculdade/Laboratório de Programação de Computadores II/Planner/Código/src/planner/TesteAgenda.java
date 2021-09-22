/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import java.util.Scanner;

/**
 *
 * @author Cristhian Sala Minoves
 */
public class TesteAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Semana agenda = new Semana();
        int duracao, horario;
        String descricao = new String();
        int op1, op2, day;
        char conti;
        do {
            System.out.println("Bem vindo a sua agenda particular");
            System.out.println("O que deseja fazer?");
            System.out.println("1-Adicionar compromisso");
            System.out.println("2-Remove compromisso");
            System.out.println("3- Ver a agenda");
            System.out.println("4- Ver horários vagos");
            op1 = input.nextInt();
            switch (op1) {
                case 1:
                    System.out.println("Qual é o dia do compromisso?");
                    System.out.println("1-Segunda-feira");
                    System.out.println("2-Terça-feira");
                    System.out.println("3-Quarta-feira");
                    System.out.println("4-Quinta-feira");
                    System.out.println("5-Sexta-feira");
                    day = input.nextInt();
                    System.out.println("Digite o horário do compromisso");
                    horario = input.nextInt();
                    while (horario < 9 || horario > 18) {
                        System.out.println("Horário inválido. Digite novamente");
                        horario = input.nextInt();
                    }
                    System.out.println("Digite agora a duração do compromisso(entre 1 e " + (19 - horario) + ")");
                    duracao = input.nextInt();
                    while (duracao > 19 - horario) {
                        System.out.println("Duração de compromisso inválida. Digite novamente");
                        duracao = input.nextInt();
                    }
                    System.out.println("Digite a descrição do compromisso");
                    descricao = input.next();
                    agenda.adicionar(day, duracao, descricao, horario);
                    break;
                case 2:
                    System.out.println("Qual é o dia do compromisso a ser removido?");
                    System.out.println("1-Segunda-feira");
                    System.out.println("2-Terça-feira");
                    System.out.println("3-Quarta-feira");
                    System.out.println("4-Quinta-feira");
                    System.out.println("5-Sexta-feira");
                    day = input.nextInt();
                    agenda.exibir(day);
                    System.out.println("Qual horário será o compromisso a ser removido?");
                    horario = input.nextInt();
                    agenda.remover(day, horario);
                    break;
                case 3:
                    System.out.println("Deseja ver a agenda de qual dia?");
                    System.out.println("1-Segunda-feira");
                    System.out.println("2-Terça-feira");
                    System.out.println("3-Quarta-feira");
                    System.out.println("4-Quinta-feira");
                    System.out.println("5-Sexta-feira");
                    System.out.println("6-Todos os dias");
                    op2 = input.nextInt();
                    agenda.exibir(op2);
                    break;
                case 4:
                    agenda.exibirVagos();

            }
            System.out.println("Deseja realizar mais alguma operação? S/N");
            conti = input.next().charAt(0);
        }while (conti=='s' || conti=='S');
    }
}

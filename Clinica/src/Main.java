import Entidade.Paciente;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Queue<Paciente> fila = new LinkedList<>(); // criação da fila

            Scanner scanner = new Scanner(System.in);

            while (true) { // loop infinito para receber os pacientes

                System.out.println("Digite o nome do paciente (ou sair para encerrar):");
                String nome = scanner.nextLine();

                if (nome.equalsIgnoreCase("sair")) { // condição para encerrar o programa
                    break;
                }

                System.out.println("Digite o estado de saúde do paciente (Vermelho, Amarelo ou Verde):");
                String estado = scanner.nextLine();

                System.out.println("Digite o código do paciente (1 para Estado grave, 2 para Estado medio e 3 para Estado normal):");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                Paciente paciente = new Paciente(nome, estado, codigo); // criação do objeto paciente

                fila.offer(paciente); // adição do paciente na fila

                System.out.println("Paciente adicionado na fila de atendimento.");
                System.out.println();
            }

            // loop para atender os pacientes na fila
            while (!fila.isEmpty()) {
                Paciente paciente = fila.poll();
                System.out.println("Atendendo o paciente " + paciente.getNome() + " (" + paciente.getEstado() +
                        ")");
            }

            System.out.println("Fim do atendimento.");
        }

    }
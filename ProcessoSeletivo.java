import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Candidato {
    String nome;
    double salarioPretendido;

    Candidato(String nome, double salarioPretendido) {
        this.nome = nome;
        this.salarioPretendido = salarioPretendido;
    }
}

public class ProcessoSeletivo {
    private static final double SALARIO_BASE = 2000.00;
    private static final int MAX_CANDIDATOS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Candidato> candidatos = new ArrayList<>();
        List<Candidato> selecionados = new ArrayList<>();
        Random random = new Random();


        candidatos.add(new Candidato("João", 1500 + random.nextDouble() * 2000));
        candidatos.add(new Candidato("Maria", 1500 + random.nextDouble() * 2000));
        candidatos.add(new Candidato("Pedro", 1500 + random.nextDouble() * 2000));
        candidatos.add(new Candidato("Ana", 1500 + random.nextDouble() * 2000));
        candidatos.add(new Candidato("Carlos", 1500 + random.nextDouble() * 2000));
        candidatos.add(new Candidato("Fernanda", 1500 + random.nextDouble() * 2000));


        for (Candidato candidato : candidatos) {
            System.out.println("Candidato: " + candidato.nome + ", Salário Pretendido: R$ " + String.format("%.2f", candidato.salarioPretendido));
            if (SALARIO_BASE > candidato.salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO: " + candidato.nome);
            } else if (SALARIO_BASE == candidato.salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA: " + candidato.nome);
            } else {
                System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS: " + candidato.nome);
            }
        }


        for (Candidato candidato : candidatos) {
            if (selecionados.size() < MAX_CANDIDATOS && candidato.salarioPretendido <= SALARIO_BASE) {
                selecionados.add(candidato);
            }
        }


        System.out.println("\nCandidatos Selecionados:");
        for (Candidato candidato : selecionados) {
            System.out.println("Candidato: " + candidato.nome + ", Salário Pretendido: R$ " + String.format("%.2f", candidato.salarioPretendido));
        }


        for (Candidato candidato : selecionados) {
            int tentativas = 0;
            boolean contato = false;
            while (tentativas < 3 && !contato) {
                tentativas++;
                System.out.println("Tentativa " + tentativas + " de contato com " + candidato.nome);
                // Simulando contato (exemplo)
                if (Math.random() > 0.5) {
                    contato = true;
                    System.out.println("CONSEGUIMOS CONTATO COM " + candidato.nome + " APÓS " + tentativas + " TENTATIVAS");
                }
            }
            if (!contato) {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato.nome + " APÓS 3 TENTATIVAS");
            }
        }

        scanner.close();
    }
}

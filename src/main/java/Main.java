import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConexaoPessoa conexao = new ConexaoPessoa();
        conexao.conectar();
        conexao.desconectar();

            for (int x = 5; x <= 10; x++) {
                Scanner input = new Scanner(System.in);
                System.out.print("MENU:\n1-INSERIR\n2-ALTERAR\n3-REMOVER\n4-CONSULTAR\n5-SAIR\n");
                int numero = input.nextInt();
                input.nextLine();

                if (numero == 1) {
                    System.out.println("Digite o id: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o nome: ");
                    String nome = input.nextLine();

                    System.out.println("Digite a idade: ");
                    int idade = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite a altura: ");
                    double altura = input.nextDouble();
                    input.nextLine();

                    System.out.println("Digite o peso: ");
                    double peso = input.nextDouble();
                    input.nextLine();

                    System.out.println("Digite o gênero: ");
                    String genero = input.nextLine();

                    System.out.println("Digite o estado: ");
                    String estado = input.nextLine();

                    System.out.println("Digite a música: (Digite 1 ou 0)");
                    int musica = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o cinema: (Digite 1 ou 0)");
                    int cinema = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite a leitura: (Digite 1 ou 0)");
                    int leitura = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite os esportes: (Digite 1 ou 0)");
                    int esportes = input.nextInt();
                    input.nextLine();

                    conexao.inserir(id, nome, idade, altura, peso, genero, estado, musica, cinema, leitura, esportes);
                    System.out.println("A pessoa " + nome + " foi inserido com sucesso! ");
                }

            if (numero == 2) {

                System.out.println("MENU 2:\n1-ALTERAR IDADE, ALTURA E PESO\n2-ALTERAR ESTADO");
                int num = input.nextInt();
                input.nextLine();

                if (num == 1){
                System.out.println("Digite a idade: ");
                int idade = input.nextInt();
                input.nextLine();

                System.out.println("Digite a altura: ");
                double altura = input.nextDouble();
                    input.nextLine();

                System.out.println("Digite o peso: ");
                double peso = input.nextDouble();
                    input.nextLine();

                System.out.println("Digite o id: ");
                int id = input.nextInt();
                    input.nextLine();

                conexao.alterarIdadePesoAltura(idade, altura, peso, id);
                System.out.println("Foi alterado com sucesso! ");
            }if (num == 2){
                    System.out.println("Digite o estado: ");
                    String estado = input.nextLine();

                    System.out.println("Digite o id: ");
                    int id = input.nextInt();
                    input.nextLine();

                    conexao.alterarEstado(estado, id);
                    System.out.println("Foi alterado com sucesso! ");
                }
            }
            if (numero == 3) {
                System.out.println("Digite o id: ");
                int id = input.nextInt();
                input.nextLine();

                conexao.remover(id);
                System.out.println("O id foi removido com sucesso! ");
            }
            if (numero == 4) {

                ResultSet rs = conexao.consultar();
                while (rs.next()) {
                    String lista = ("ID: " + rs.getInt("PESSOAID") + "| NOME:" + rs.getString("NOME") + "| IDADE:" + rs.getInt("IDADE") + "| ALTURA: " + rs.getDouble("ALTURA") +
                            "| PESO: " + rs.getDouble("PESO") + "| GÊNERO: " + rs.getString("GENERO") + "| ESTADO: " + rs.getString("ESTADO") + "| MÚSICA: " + rs.getInt("MUSICA") + "| CINEMA: " + rs.getInt("CINEMA") + "| LEITURA: " + rs.getInt("LEITURA") + "| ESPORTES: " + rs.getInt("ESPORTES"));
                    System.out.println(lista);
                }
            }if (numero == 5) {
                    System.out.println("Até breve! ");
                break;
                }
                System.out.println("Deseja continuar? (responda com s/n)");
                String ctn = input.nextLine();

                if(ctn.equals("s")) {
                }else{
                    break;
                }}


    }
}


//        ConexaoPessoa conexao = new ConexaoPessoa();
//                System.out.println(conexao.conectar());
//                System.out.println(conexao.desconectar());
//
//                ResultSet rs = conexao.consultar();
//                while(rs.next()) {
//                    String lista = ("ID" + rs.getInt("PESSOAID") + "-" + "NOME:" + rs.getString("NOME") + "-" + "IDADE:" + rs.getInt("IDADE"));
//                    System.out.println(lista);
//                }

//        conexao.inserir(105,"BEATRIZ BORTOLUCCI", 16, 1.58, 55, "feminino", "São Paulo - SP", 1, 1, 1, 1);
//        conexao.alterarIdadePesoAltura(17, 1.59, 56, 105);
//        conexao.remover(105);





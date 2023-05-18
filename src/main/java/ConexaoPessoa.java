import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoPessoa {
        private Connection conn;
        private PreparedStatement pstmt;
        private ResultSet rs;

        public boolean conectar() {
            try {
                Class.forName("org.postgresql.Driver");

                conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/bdPessoa", "postgres", "1234");
                return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean desconectar(){
            try{
                if (conn != null && !conn.isClosed()){
                    conn.close();
                }
                return true;
            } catch (SQLException e){
                System.out.println(e);
            }
            return false;
        }

        public boolean inserir(int pessoaId, String nome, int idade, double altura, double peso, String genero, String estado, int musica, int cinema, int leitura, int esportes) {
            conectar();
            try {
                pstmt = conn.prepareStatement("INSERT INTO PESSOA (PESSOAID, NOME, IDADE, ALTURA, PESO, GENERO, ESTADO, MUSICA, CINEMA, LEITURA, ESPORTES) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
                pstmt.setInt(1, pessoaId);
                pstmt.setString(2, nome);
                pstmt.setInt(3, idade);
                pstmt.setDouble(4, altura);
                pstmt.setDouble(5, peso);
                pstmt.setString(6, genero);
                pstmt.setString(7, estado);
                pstmt.setInt(8, musica);
                pstmt.setInt(9, cinema);
                pstmt.setInt(10, leitura);
                pstmt.setInt(11, esportes);

                pstmt.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Não foi possível realizar a inserção, pois esse id já existe! Tente novamente! \nErro: " + e);
                return false;

            }
        }

        public boolean alterarIdadePesoAltura(int idade, double altura, double peso, int pessoaId) {
            try {
                conectar();
                pstmt = conn.prepareStatement("UPDATE PESSOA SET IDADE = ?, ALTURA = ?, PESO = ? WHERE PESSOAID = ?");
                pstmt.setInt(1, idade);
                pstmt.setDouble(2, altura);
                pstmt.setDouble(3, peso);
                pstmt.setInt(4, pessoaId);
                pstmt.execute();
                return true;

            } catch (SQLException e) {
                System.out.println("O id inserido não existe! Tente novamente! Erro:" + e);
                return false;

            }}

            public boolean alterarEstado(String estado, int pessoaId){
                try {
                    conectar();
                    pstmt = conn.prepareStatement("UPDATE PESSOA SET ESTADO = ? WHERE PESSOAID = ?");
                    pstmt.setString(1, estado);
                    pstmt.setInt(2, pessoaId);
                    pstmt.execute();
                    return true;

                } catch (SQLException e) {
                    System.out.println("O id inserido não existe! Tente novamente! Erro:" + e);
                    return false;
                }
            }

        public boolean remover(int pessoaId) {
            try{
                conectar();
                pstmt = conn.prepareStatement("DELETE FROM PESSOA WHERE PESSOAID = ?");
                pstmt.setInt(1, pessoaId);
                pstmt.execute();

                return true;

            }catch (SQLException e) {
                System.out.println("O id inserido não existe! Tente novamente! Erro:" + e);
                return false;

            }
        }
        public ResultSet consultar() {
            conectar();
            try {
                pstmt = conn.prepareStatement("SELECT * FROM PESSOA ORDER BY PESSOAID");
                rs = pstmt.executeQuery();
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            } finally {
                desconectar();
            }
        }
    }
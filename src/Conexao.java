import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Conexao {

    final String URL = "jdbc:mysql://localhost:3306/crud";
    final String USER = "root";
    final String PASSWORD = "root99"; //root99

    public Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");

            String sql = "INSERT INTO aluno (nome, matricula) VALUES (?,?)";

            Scanner sc = new Scanner(System.in);

            System.out.println("Digite o nome do aluno");
            String nomeAluno = sc.nextLine();
            System.out.println("Digite a matrícula do aluno");
            int matriculaAluno = sc.nextInt();

            //Criação da PreparedStatement = preparação dos dados para enviar ao banco

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nomeAluno);
            stmt.setInt(2,matriculaAluno);

            //Executar a inserção de dados
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Dados Inseridos!");

        } catch (Exception e) {
            System.out.println(e);

        }

    }
}

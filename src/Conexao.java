import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            String insert = "INSERT INTO aluno (nome, matricula) VALUES (?,?)";
            String consulta = "SELECT * FROM aluno";

            Scanner sc = new Scanner(System.in);

            String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno: ");
            int matriculaAluno = Integer.parseInt(JOptionPane.showInputDialog("Digite a matricula: "));

            //Criação da PreparedStatement = preparação dos dados para enviar ao banco

            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setString(1,nomeAluno);
            stmt.setInt(2,matriculaAluno);

            //Executar a inserção de dados
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Dados Inseridos!");

            //Exibe os dados da tabela após a inserção
            //Statement se refere a consultas (operações) no banco de dados

            ResultSet resultset = stmt.executeQuery(consulta);

            while (resultset.next()){
                System.out.println("Nome: "+ resultset.getString("nome"));
                System.out.println("Matrícula: " + resultset.getString("matricula"));
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }
}

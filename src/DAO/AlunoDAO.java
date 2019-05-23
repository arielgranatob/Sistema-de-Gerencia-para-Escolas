package DAO;

import Model.Aluno;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariel
 */
public class AlunoDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) {
        try {
            Aluno aluno = (Aluno) obj;
            sql = "INSERT INTO aluno (nomeAluno, cpfAluno) VALUES (?,?)";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNomeAluno());
            stmt.setString(2, aluno.getCpfAluno());
            stmt.execute();
            //Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void exclui(Object obj) {
        try {
            Aluno aluno = (Aluno) obj;
            sql = "DELETE FROM aluno WHERE idAluno=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNomeAluno());
            stmt.execute();
            // Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void altera(Object obj) {
        try {
            Aluno aluno = (Aluno) obj;
            sql = "UPDATE aluno SET nomeAluno=? WHERE idAluno=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNomeAluno());
            stmt.setString(2, aluno.getIdAluno());
            stmt.execute();
            //Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Object> consulta(Object obj) {
        try {
            sql = "SELECT * FROM aluno";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            //Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

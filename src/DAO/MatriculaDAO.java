package DAO;

import Model.Matricula;
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
public class MatriculaDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) {
        try {
            Matricula matricula = (Matricula) obj;
            sql = "INSERT INTO matricula (idAluno, idCurso) VALUES (?,?)";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            //        stmt.setInt(1, Aluno.matricula.getIdAluno());
            //        stmt.setInt(2, matricula.getIdCurso());
            stmt.execute();
            //Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void exclui(Object obj) {
        try {
            Matricula matricula = (Matricula) obj;
            sql = "DELETE FROM matricula WHERE idMatricula=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, matricula.getIdMatricula());
            stmt.execute();
            // Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void altera(Object obj) {
        try {
            Matricula matricula = (Matricula) obj;
            sql = "UPDATE matricula SET idAluno=?, idCurso=? WHERE idMatricula=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            //stmt.setInt(1, Aluno.matricula.getIdAluno());
            //stmt.setInt(1, Curso.matricula.getIdCurso());
            stmt.setInt(3, matricula.getIdMatricula());
            stmt.execute();
            //Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Object> consulta(Object obj) {
        try {
            sql = "SELECT * FROM matricula";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.execute();
            Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

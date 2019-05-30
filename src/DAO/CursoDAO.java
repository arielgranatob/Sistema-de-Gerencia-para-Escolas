package DAO;

import Model.Curso;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariel
 */
public class CursoDAO implements InterfaceDAO {

    private String sql;
    private Connection conn;

    @Override
    public void adiciona(Object obj) {
        try {
            Curso curso = (Curso) obj;
            sql = "INSERT INTO curso (nomeCurso) VALUES (?)";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.execute();
            //Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void exclui(Object obj) {
        try {
            Curso curso = (Curso) obj;
            sql = "DELETE FROM curso WHERE idCurso=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getIdCurso());
            stmt.execute();
            // Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void altera(Object obj) {
        try {
            Curso curso = (Curso) obj;
            sql = "UPDATE curso SET nomeCurso=? WHERE idCurso=?";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, curso.getIdCurso());
            stmt.execute();
            //Conexao.closeConn();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
 public ArrayList<Object> consulta(Object obj) {
        try {
            sql = "SELECT * FROM curso";
            conn = Conexao.conexao();
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Object> dados = new ArrayList<>();
            while (rs.next()) {
                Curso curso = new Curso(rs.getString("idCurso"), rs.getString("nomeCurso"));
                dados.add(curso);
            }
            //Conexao.closeConn();
            return dados;

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
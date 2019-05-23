package DAO;

import Model.Aluno;
import Model.Curso;
import Model.Matricula;
import java.util.ArrayList;

/**
 *
 * @author ariel
 */

public interface InterfaceDAO {
    
    public void adiciona(Object obj);
    public void exclui (Object obj);
    public void altera (Object obj);
    public ArrayList<Object> consulta (Object obj);
    
}

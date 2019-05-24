package Model;

public class Matricula {

    private int idMatricula;
    private Aluno aluno;
    private Curso curso;

    public Matricula() {
        this.idMatricula = -1;
        this.aluno = null;
        this.curso = null;
    }

    /**
     * @return the idMatricula
     */
    public int getIdMatricula() {
        return idMatricula;
    }

    /**
     * @param idMatricula the idMatricula to set
     */
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

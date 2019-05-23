package Model;

public class Matricula {

    private int idMatricula;
    private Aluno idAluno;
    private Curso idCurso;

    public Matricula() {
        this.idMatricula = -1;
        this.idAluno = null;
        this.idCurso = null;
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
     * @return the idAluno
     */
    public Aluno getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    /**
     * @return the idCurso
     */
    public Curso getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }
}

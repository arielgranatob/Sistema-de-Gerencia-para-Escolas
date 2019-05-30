package Model;

public class Curso {

    private String nomeCurso;
    private String idCurso;

    public Curso(String nomeCurso, String idCurso) {
        this.nomeCurso = nomeCurso;
        this.idCurso = idCurso;
    }

    public Curso() {
        this.nomeCurso = nomeCurso;
        this.idCurso = idCurso;
    }

    public Curso(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the idCurso
     */
    public String getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the nomeCurso
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * @param nomeCurso the nomeCurso to set
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}

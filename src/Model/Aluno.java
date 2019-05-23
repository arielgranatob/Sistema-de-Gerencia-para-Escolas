package Model;

public class Aluno {

    private String nomeAluno;
    private String cpfAluno;
    private String idAluno;

    /**
     * @return the idAluno
     */
    public String getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public Aluno() {
        this.cpfAluno = cpfAluno;
        this.nomeAluno = nomeAluno;
        this.idAluno = idAluno;
    }

    /**
     * @return the nomeAluno
     */
    public String getNomeAluno() {
        return nomeAluno;
    }

    /**
     * @param nomeAluno the nomeAluno to set
     */
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    /**
     * @return the cpfAluno
     */
    public String getCpfAluno() {
        return cpfAluno;
    }

    /**
     * @param cpfAluno the cpfAluno to set
     */
    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }
}

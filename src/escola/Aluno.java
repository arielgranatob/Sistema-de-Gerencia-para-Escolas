package escola;

public class Aluno {

    private int idAluno;
    private String nomeAluno;
    private String cpfAluno;

    public Aluno(int idAluno, String nomeAluno, String cpfAluno) {
        this.idAluno = idAluno;
        this.cpfAluno = cpfAluno;
        this.nomeAluno = nomeAluno;
    }

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(int idAluno) {
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

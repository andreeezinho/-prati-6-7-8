
public abstract class Usuario {

    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public abstract int getLimiteEmprestimos();

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public void adicionarEmprestimo() {
        quantidadeEmprestada++;
    }

    public void removerEmprestimo() {
        quantidadeEmprestada--;
    }
}

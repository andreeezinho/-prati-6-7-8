package exercicio1;

public class Biblioteca {

    private ItemBiblioteca[] acervo;
    private int quantidadeItens;

    public Biblioteca() {
        acervo = new ItemBiblioteca[100];
        quantidadeItens = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        if (quantidadeItens < acervo.length) {
            acervo[quantidadeItens] = item;
            quantidadeItens++;
        } else {
            System.out.println("Acervo cheio!");
        }
    }

    public void emprestar(ItemBiblioteca item, Usuario usuario) {

        if (!item.isDisponivel()) {
            System.out.println("Item indisponível para empréstimo.");
            return;
        }

        if (usuario.getQuantidadeEmprestada() >= usuario.getLimiteEmprestimos()) {
            System.out.println("Limite de empréstimos atingido para " + usuario.getNome());
            return;
        }

        item.emprestar();
        usuario.adicionarEmprestimo();

        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void devolver(ItemBiblioteca item, Usuario usuario) {

        if (item.isDisponivel()) {
            System.out.println("Esse item já está disponível.");
            return;
        }

        item.devolver();
        usuario.removerEmprestimo();

        System.out.println("Devolução realizada com sucesso!");
    }

    public void listarAcervo() {

        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");

        for (int i = 0; i < quantidadeItens; i++) {

            ItemBiblioteca item = acervo[i];

            System.out.println("Código: " + item.getCodigo());
            System.out.println("Título: " + item.getTitulo());
            System.out.println("Disponível: " + item.isDisponivel());
            System.out.println("Prazo: " + item.getPrazo() + " dias");
            System.out.println("Multa por dia: R$ " + item.getMultaPorDia());

            System.out.println("-------------------------");
        }
    }
}

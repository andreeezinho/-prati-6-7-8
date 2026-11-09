package exercicio1;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro(1, "Java para Iniciantes");
        Livro livro2 = new Livro(2, "Programação Orientada a Objetos");
        Revista revista1 = new Revista(3, "exercicio1.Revista de Tecnologia");
        Revista revista2 = new Revista(4, "exercicio1.Revista de Ciência");
        DVD dvd = new DVD(5, "Curso +PraTi :)");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);
        biblioteca.cadastrarItem(dvd);

        Aluno aluno = new Aluno("João");
        Professor professor = new Professor("Carlos");

        System.out.println("===== EMPRÉSTIMOS =====");

        biblioteca.emprestar(livro1, aluno);
        biblioteca.emprestar(livro2, aluno);
        biblioteca.emprestar(revista1, aluno);

        biblioteca.emprestar(revista2, aluno);

        biblioteca.listarAcervo();
    }
}

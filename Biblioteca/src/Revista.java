public class Revista extends ItemBiblioteca {

    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazo() {
        return 7;
    }

    @Override
    public double getMultaPorDia() {
        return 1.00;
    }
}
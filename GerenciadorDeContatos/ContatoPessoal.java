class ContatoPessoal extends Contato {
    public ContatoPessoal(String nome, String telefone) {
        super(nome, telefone);
    }

    @Override
    public String getTipo() {
        return "Contato Pessoal";
    }
}
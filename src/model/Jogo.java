package model;

public class Jogo {

    private int id;
    private String nome;
    private String genero;
    private String estudio;
    private int preco;
    private int duracao;

    public Jogo (String nome, String genero, String estudio, int preco, int duracao){
        this.nome = nome;
        this.genero = genero;
        this.estudio = estudio;
        this.preco = preco;
        this.duracao = duracao;
    }
    public Jogo(){}

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome){this.nome = nome;}

    public String getGenero(){return genero;}
    public void setGenero(String genero){this.genero = genero;}

    public String getEstudio(){return estudio;}
    public void setEstudio(String estudio){this.estudio = estudio;}

    public int getPreco(){return preco;}
    public void setPreco(int preco){this.preco = preco;}

    public int getDuracao(){return duracao;}
    public void setDuracao(int duracao){this.duracao = duracao;}

    @Override
    public String toString(){
        return "Jogo[id = '"+ id + '\''+
                "nome = '"+ nome + '\'' +
                ", genero = '"+ genero + '\''+
                ", estudio = '"+ estudio + '\''+
                ", preço = '"+ preco + '\''+
                ", duração '= "+ duracao +
                ']';
    }
}

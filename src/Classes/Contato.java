package Classes;

import java.util.HashSet;
import java.util.Set;

public abstract class Contato {
	
	    private String nome;
	    private int numero;
	    static Set<Contato> contatos = new HashSet<>(); //lista com todos os contatos adicionados

	    protected Contato(String nome, int numero) {
	        this.nome = nome;
	        this.numero = numero;
	        new Chat(this);  					// cria uma nova instancia de chat
	        contatos.add(this);					// adiciona o contato na lista de contatos
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public void setNumero(int numero) {
	        this.numero = numero;
	    }
	   
	    public static Contato acharContato(int numero) { // metodo estático para buscar contato na lista de contatos
	        for(Contato contato:contatos) {
	            if (contato.getNumero()==numero) {
	                return contato;
	            }
	        }
	        return null;
	    }


}

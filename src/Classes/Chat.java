package Classes;
import java.util.ArrayList;
import java.util.List;

public class Chat {
	private Contato contato;
    private List<Mensagem> mensagens; // cria uma lista de mensagens para cada chat
    private static List<Chat> chats = new ArrayList<>(); // lista statica para armazenar todos os chats

    public Chat(Contato contato) {
        this.contato = contato;
        this.mensagens = new ArrayList<>(); //cria uma nova lista de mensagens do chat
        chats.add(this); // adiciona o chat na lista de chats
        
    }

    public void adicionarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }
    
    //metodo para encontrar um chat dado um contato
    public static Chat selecionarChat(Contato contato) {
        for (Chat chat : chats) {
            if (chat.getContato() == contato) {
                return chat;
            }
        }
        return null;
    }
    
    // metodo para mostrar as mensagens de um chat
    public void showMensagens() {
    	System.out.println("                      "+this.getContato().getNome()+"");
        	for (Mensagem mensagem : this.getMensagens()) {
                if(mensagem.getContato().getNome()=="Eu"){
        		System.out.println("                          "+mensagem.mensagemModelo());
                }else{
                System.out.println(mensagem.mensagemModelo());
                }
        }
    }
    
    
}

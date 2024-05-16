package Classes;
import java.time.LocalDateTime;

public class Mensagem {
	    private Contato contato;
	    private LocalDateTime dataHora;
	    private String hora;
	    private String conteudo;

	    public Mensagem(Contato contato, String conteudo) {
	        this.contato = contato;
	        this.dataHora = LocalDateTime.now();
	        this.hora = dataHora.getHour()+":"+dataHora.getMinute();//formatação para mostrar apenas horas e minutos
	        this.conteudo = conteudo;
	    }
	    //modelo para as mensagens HH:MM Nome: mensagem
	    public String mensagemModelo() {
			if (contato.getNome() == "Eu") {
				return contato.getNome()+": "+conteudo + " | " + hora;
			}else{
	    		return hora +" | "+ contato.getNome()+": "+conteudo;
			}
	    }
	    
	    public Contato getContato() {
	        return contato;
	    }

	    public void setContato(Contato contato) {
	        this.contato = contato;
	    }

	    public String getHora() {
	        return hora;
	    }

	    public String getConteudo() {
	        return conteudo;
	    }

	    public void setConteudo(String conteudo) {
	        this.conteudo = conteudo;
	    }
	}


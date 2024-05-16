package Classes;

public class Eu extends Contato {
	private static Eu usuario;
	//construtor privado para evitar instanciar 2 usuários
    private Eu(int numero) {
        super("Eu", numero);
    }
    //metodo estatico para chamar o usuário único
    public static Eu getEu() {
    	if(usuario==null) {
    		usuario = new Eu(123456789);
    	}
    	return usuario;
    }
    

}

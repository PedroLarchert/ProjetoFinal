package Chat;

import Classes.*;
import java.util.Scanner;
import java.io.IOException;


public class ChatTexto {

	// metodo para limpar o terminal
	public static void clear() throws IOException, InterruptedException {       
		if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
	}

	//metodo main
	 public static void main(String[] args) throws IOException, InterruptedException {

		
		boolean run = true; // inicia a variavel run

		 while(run){  // executa um loop enquanto run for verdade
		 	
		 	Scanner scanner = new Scanner(System.in);
         	System.out.println("MENU DE OPÇÕES: (1)Salvar novo contato (2) Abrir conversa (0) Fechar programa");
         	int opcao = scanner.nextInt();
		 	clear();
            scanner.nextLine();
			
         	switch(opcao) { // usa um para selecionar qual opção utilizar
         	case 1:

             	System.out.println("Nome: ");
             	String nome = scanner.nextLine();
             	clear();
             
             	System.out.println("Numero: ");
             	int numero = scanner.nextInt();
				clear();
				if (Contato.acharContato(numero)==null){							// verifica se o contato existe 
             		new Outros(nome,numero);}
				else{
					System.out.println("esse contato ja existe!!");}				
					
            break;
           
            case 2: 
        	 	System.out.println("Digite o numero do contato que quer conversar : ");
             	numero = scanner.nextInt();
             	clear();
             	Chat chatnow = Chat.selecionarChat(Contato.acharContato(numero));
             	if(chatnow == null){                                                //verifica se o contato existe para poder iniciar a conversa
            	System.out.println("Esse contato nao existe!! ");
            	break;
                }

             	chatnow.showMensagens();
            	scanner.nextLine();
             	while(true) { 
            	 
            	System.out.println("\n\n\n\n\n"+"Digite a mensagem ou close para retornar ao menu: ");
            	String mensagem = scanner.nextLine();
            	

            	Mensagem newmensagem;
            	if(!mensagem.equals("close")) {
					int x = scanner.nextInt();
					clear();
            		if(x==1) {
            			newmensagem = new Mensagem(chatnow.getContato(), mensagem);}
            		else {
            			newmensagem = new Mensagem(Eu.getEu(), mensagem);}	 

            		chatnow.adicionarMensagem(newmensagem);
					clear();
            		chatnow.showMensagens();
            	 
            	}else {
					clear();
            		break;
            	 }
            	 scanner.nextLine(); 
             }
           break;
        	 
		case 0:
			run = false; // muda o valor de run para false e encerra o loop para encerrar o programa
         }
		}
        

	 }
}

 
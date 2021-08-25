package Thread;
import javax.swing.JOptionPane;

public class CursoThread {

	public static void main(String[] args) throws Exception {
		
		/* Thread processando em paralelo do envio de e-mail*/
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();
			
	
						/*DIVISÃO DAS THREADS*/
		
		/* Thread processando em paralelo do envio de NOTA FISCAL*/
		Thread threadNotaFiscal = new Thread(thread2);
		threadNotaFiscal.start();
			
		
			
		
		/* CODIGO DO SISTEMA DO USUARIO CONTINUA O FLUXO DE TRAALHO*/
		System.out.println("CHEGOU AO FIM DO CÓDIGO DE TESTE DE THREAD");
		
		/*FLUXO DO SISTEMA*/
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuario");
	}

	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			/*Código de rotina*/
			
			/*CÓDIGO DA ROTINA QUE EU QUERO EXECUTAR EM PARALELO*/
			for(int pos = 0; pos < 10; pos++) {
				
				
				/* Quero executar esse envio com um tempo de parada ou com um tempo determinado */
				System.out.println("Executando algo rotina, por exemplo envio de e-mail");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				} /* Dá um tempo*/
			}
			/* FIM DO CÓDIGO EM PARALELO*/
			
			
		}
	};
	
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			/*Código de rotina*/
			
			/*CÓDIGO DA ROTINA QUE EU QUERO EXECUTAR EM PARALELO*/
			for(int pos = 0; pos < 10; pos++) {
				
				
				/* Quero executar esse envio com um tempo de parada ou com um tempo determinado */
				System.out.println("Executando algo rotina, por exemplo envio de NOTA FISCAL");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				} /* Dá um tempo*/
			}
			/* FIM DO CÓDIGO EM PARALELO*/
			
		}
	};
	
}

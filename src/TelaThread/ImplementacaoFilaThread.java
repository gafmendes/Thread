package TelaThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("Fila Rodando");


		while (true) {
			synchronized (pilha_fila) { /* Bloquear o acesso a esta lista por outros processos */
				Iterator iteracao = pilha_fila.iterator();

				while (iteracao.hasNext()) { /* Enquanto conter dados na lista será processado */

					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next(); /* Pega o objeto atual */

					/* Exemplos do que poderia ser feito */
					/* Processar 10 mil notas fiscais */
					/* Gerar uma lista enorme de PDF */
					/* Gerar um envio em massa de email */

					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());

					iteracao.remove();

					try {
						Thread.sleep(100); /* Dar um tempo para descarga de memoria */
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(1000); /* Processou toda a lista, dar um tempo para limpeza a memoria */
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}

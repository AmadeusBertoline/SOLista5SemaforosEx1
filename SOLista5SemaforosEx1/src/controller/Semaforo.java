package controller;

import java.util.concurrent.Semaphore;

public class Semaforo extends Thread {

	private int id;
	private Semaphore semaforo;
	private int min;
	private int max;
	private int add;
	private int cont;

	public Semaforo(int id, Semaphore semaforo) {

		this.id = id;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {

		int res = id % 3;

		if (res == 1) {

			min = 200;
			max = 1000;
			add = 0;
			cont = 1;

		} else if (res == 2) {

			min = 500;
			max = 1500;
			add = 500;
			cont = 2;

		} else if (res == 0) {

			min = 1000;
			max = 2000;
			add = 500;
			cont = 2;

		}

		for (int i = 0; i <= cont; i++) {

			calc(min, max);
			transacao(add);

			try {

				semaforo.acquire();

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				semaforo.release();

			}

		}

	}

	// calculation time.
	private void calc(int min, int max) {

		System.out.println("A thread " + id + " iniciou um cálculo");

		int time = (int) ((Math.random() * (max - min + 1)) + min);

		try {

			sleep(time);

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("A thread " + id + " finalizou um cálculo");

	}

	// time of transaction
	private void transacao(int add) {

		System.out.println("A thread " + id + " iniciou uma transação");

		int time = 1000 + add;

		try {
			sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("A thread " + id + " finalizou uma transação");

	}

}

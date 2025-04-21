package controller;

public class Semaforo extends Thread {

	private static int id = 1;

	public Semaforo() {
	}

	@Override
	public void run() {

		if (id % 3 == 1) {

			calc(200, 1000);

		} else if (id % 3 == 1) {

		} else if (id % 3 == 1) {

		}

	}

	// Tempo de cálculo da thread.
	private void calc(int min, int max) {

		System.out.println("A thread " + id + " está realizando um cálculo");

		int time = (int) ((Math.random() * (max - min + 1)) + min);

		try {

			sleep(time);

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("A thread " + id + " finalizou um cálculo");

	}

	private void transacao(int add) {

		int time = 1000 + add;

		try {
			sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

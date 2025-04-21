package view;

import controller.*;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {

		int permissoes = 1;
		int i;

		Semaphore semaforo = new Semaphore(permissoes);

		for (i = 1; i <= 20; i++) {

			Semaforo sem = new Semaforo(i, semaforo);
			sem.start();

		}

	}

}

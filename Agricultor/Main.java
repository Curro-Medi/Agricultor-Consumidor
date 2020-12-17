package Agricultor;

import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		int existencias = 0;
		int limite = 20;
		Boolean bucle = false;
		
		do {
			
		int productosAG = (int) (Math.random() * 4) + 5;
		int productosCO = (int) (Math.random() * 3) + 2;
		Semaphore semaforo = new Semaphore(1);
		
		Agricultor ag1 = new Agricultor(productosAG);
		Thread ag = new Thread(ag1, "Agricultor");
		
		Consumidor con1 = new Consumidor(productosCO);
		Thread con = new Thread(con1,"Consumidor");
		
		if(existencias>=limite) {
			
			existencias = 0;
			Thread.sleep(1000);
			System.out.println();
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("La sobreproduccion de papayas ha hecho que vengan los macacos y se hayan comido todas las existencias ");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			Thread.sleep(2000);
			
		}
		
		System.out.println();
		System.out.println("=========================================================");
		System.out.println("--->  La cesta tiene actualmente: " + existencias + " productos  <---");
		System.out.println("=========================================================");
		System.out.println();
		Thread.sleep(2000);
		
		semaforo.acquire();
		ag.start();
		Thread.sleep(2000);
		semaforo.release();
		
		semaforo.acquire();
		con.start();
		Thread.sleep(2000);
		semaforo.release();
		
		existencias = existencias + productosAG;
		existencias = existencias - productosCO;
		
					
		}while(bucle==false);
	}

}

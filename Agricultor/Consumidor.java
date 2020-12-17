package Agricultor;

public class Consumidor implements Runnable{
	
	private int productos;
	
	
	public Consumidor(int productos) {
		super();
		this.productos = productos;
	}


	@Override
	public void run() {

			
			System.out.println("El Consumidor Jose Juan De Los Palomares se ha llevado " + productos +  " papayas de la cesta");
	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		
		
		
		System.out.println("El Consumidor se ha ido a dormir");

		
	}

	
}

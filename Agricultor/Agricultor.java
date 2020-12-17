package Agricultor;

public class Agricultor implements Runnable{

	private int productos;
	

	public Agricultor(int productos) {
		super();
		this.productos = productos;
	}




	@Override
	public void run() {
		
		System.out.println("El Agricultor Norberto De La Fuente ha dejado " + productos + " papayas en la cesta");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("El Agricultor ha ido a descansar");
				
	}




	public void setProductos(int productos) {
		this.productos = productos;
	}

	public int getProductos() {
		return productos;
	}

	
}

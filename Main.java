import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Scanner os = new Scanner(System.in);
		
		Libro l1 = new Libro("001", "titulo", 10, 3);
		Libro l2 = new Libro("002", "titulo", 23, 4);
		Libro l3 = new Libro("003", "titulo", 43, 5);
		Libro l4 = new Libro("004", "titulo", 32, 6);
		Libro l5 = new Libro("005", "titulo", 23, 7);
		
		Inventario inventario = new Inventario();
		
		inventario.almacenar(l1);
		inventario.almacenar(l2);
		inventario.almacenar(l3);
		inventario.almacenar(l4);
		inventario.almacenar(l5);
		
		ArrayList <Libro> libros = inventario.getLibros();
		
		int op = -1;
		
		
		while(op!=0) {
			System.out.println("1. Ingrese un libro con su isbn ");
			System.out.println("2. Buscar libro por isbn ");
			System.out.println("3. venta de un libro");
			System.out.println("4. Mostrar los 3 libros más caros");
			System.out.println("5. Mostrar todos los libros");
			System.out.println("0. Salir");
			
			System.out.println("Ingrese una opción: ");	
			op = sc.nextInt();
						
			String isbn;
			String titulo;
			double precio;
			int cantidad;
			
			
			switch (op) {
			
			case 1:			
							
				System.out.println("Ingrese el isbn del libro que quiere añadir al repostorio de la biblioteca: ");
				isbn = os.nextLine();
				
				inventario.result(isbn);				
				
				if(inventario.result(isbn) != null) {
					System.out.println("Ya se encuentra registrado el isbn ");
				}else {
					System.out.println("Ingresa un título: ");
					titulo = os.nextLine();
					
					System.out.println("Ingrese el precio: ");
					precio = os.nextDouble();
					
					System.out.println("Ingrese la cantidad de libros que quiere ingresar: ");
					cantidad = os.nextInt();
					
					Libro ln = new Libro(isbn, titulo, precio, cantidad);
					inventario.almacenar(ln);	
				}
				
				break;
			
			case 2:
				
				System.out.println();
				
				System.out.println("Ingrese el isbn del libro que quiere buscar: ");
				isbn = os.nextLine();
				
				Libro result = inventario.getLibrobyIsbn(isbn);
				
				if(result != null) {
					System.out.println(result);
				}else {
					System.out.println("No se encontro el libro con el ISBN "+ isbn);
				}
				
				System.out.println("------------------------------------------");
				
				break;
				
			case 3:
				
				System.out.println();
				
				System.out.println("Ingrese el isbn del libro que desea vender: ");
				isbn = os.nextLine();
				
				inventario.result(isbn);
				
				if (inventario.result(isbn)!=null) {
					System.out.println("Cuantos desea vender: ");
					cantidad=os.nextInt();
					inventario.venta(inventario.result(isbn), cantidad);
					System.out.println("Venta realizada con exito.");
					
				}else {
					System.out.println("No se encuentra el isbn del libro. ");
				}
				
				break;
				
			case 4:
				
				//Collections.sort(libros);
				for (int i=0 ; i<3 ; i++) {
					System.out.println(libros.get(i));
				}
					
				break;
				
			case 5:
				
				for(Libro l: libros) {
					 
					System.out.println(l);
				}
				
				break;
				
			default:
				System.out.println("Exit...");
				break;	
					
			}
				
		}
		sc.close();
		
	}

}

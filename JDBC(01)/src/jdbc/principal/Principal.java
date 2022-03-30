package jdbc.principal;

import java.util.Locale;
import java.util.Scanner;
import jdbc.entity.Fabricante;
import jdbc.service.FabricanteService;
import jdbc.service.ProductoService;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ProductoService productoService = new ProductoService();
        FabricanteService fabricanteService = new FabricanteService();

        int opcion = 0;

        do {
            System.out.printf("%25s \n", "MENU");
            System.out.println("1-Lista el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("2-Lista los nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("3-Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("4-Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("5-Listar el nombre y el precio del producto más barato.");
            System.out.println("6-Ingresar un producto a la base de datos.");
            System.out.println("7-Ingresar un fabricante a la base de datos");
            System.out.println("8-Editar un producto con datos a elección.");
            System.out.println("9-Salir.");
            try {
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        productoService.printProducts();
                        break;
                    case 2:
                        productoService.printProductsNamePrice();

                        break;
                    case 3:
                        productoService.printProductsInterval();
                        break;
                    case 4:
                        productoService.printPortatiles();
                        break;
                    case 5:
                        productoService.printProductoMasBarato();
                        break;
                    case 6:
                        System.out.println("Ingrese el nombre del producto");
                        String nombre = scan.next();
                        System.out.println("Ingrese el precio");
                        double precio = scan.nextDouble();
                        System.out.println("Ingrese el codigo del fabricante");
                        int codigoFabricante = scan.nextInt();
                        System.out.println("Ingrese el nombre del fabricante");
                        String nombreFabricante = scan.next();
                        
                        Fabricante fabricante = new Fabricante(codigoFabricante, nombreFabricante);
                        
                        productoService.createProduct(nombre, precio, fabricante);
                        
                        System.out.println("Producto añadido a la base de datos");
                        break;
                    case 7:
                        System.out.println("Ingrese el codigo del fabricante");
                        int codigoFab = scan.nextInt();
                        System.out.println("Ingrese el nombre del fabricante");
                        String nombreFab = scan.next();
                        fabricanteService.createFabricante(nombreFab, codigoFab);
                        System.out.println("Fabricante añadido a la base de datos");
                        break;
                    case 8:
                        productoService.printProducts();
                        System.out.println("Ingrese el codigo del producto que desea modificar");
                        int codigoProducto = scan.nextInt();

                        productoService.printModifiedProducts(codigoProducto);
                        break;
                    case 9:
                        System.out.println("Saliendo....");
                        break;
                    default:
                        System.out.println("Opcion invalida, intente nuevamente");
                        break;
                }
            } catch (Exception e) {

            }
        } while (opcion != 9);
    }

}

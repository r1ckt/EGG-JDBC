package jdbc.service;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import jdbc.entity.Fabricante;
import jdbc.entity.Producto;
import jdbc.persistence.ProductoDAO;

public class ProductoService {

    private final ProductoDAO productDAO;

    public ProductoService() {
        productDAO = new ProductoDAO();
    }

    //crear
    public void createProduct(String nombre, Double precio, Fabricante fabricante) throws Exception {
        try {

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre del producto es obligatorio");
            }
            if (precio <= 0) {
                throw new Exception("El precio debe ser mayor a 0");
            }

            Producto product = new Producto();

            product.setNombre(nombre);
            product.setPrecio(precio);
            product.setFabricante(fabricante);

            productDAO.addProduct(product);

        } catch (Exception e) {
            throw e;
        }
    }

    public void printProducts() throws Exception {
        try {
            List<Producto> products = productDAO.getProducts();

            if (products.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("PRODUCT LIST");
                System.out.printf("%-10s%-40s%-15s\n", "ID", "NOMBRE", "CODIGO FABRICANTE");

                for (Producto product : products) {
                    System.out.printf("%-10s%-40s%-15s\n", product.getCodigo(), product.getNombre(), product.getFabricante().getCodigo());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void printProductsNamePrice() throws Exception {
        try {
            List<Producto> products = productDAO.getProducts();

            if (products.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("PRODUCT LIST");
                System.out.printf("%-40s%-10s\n", "NOMBRE", "PRECIO");

                for (Producto product : products) {
                    System.out.printf("%-40s%-10s\n", product.getNombre(), product.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void printProductsInterval() throws Exception {
        try {
            List<Producto> products = productDAO.getProductsByPriceInterval();

            if (products.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("PRODUCT LIST");
                System.out.printf("%-40s%-10s\n", "NOMBRE", "PRECIO");

                for (Producto product : products) {
                    System.out.printf("%-40s%-10s\n", product.getNombre(), product.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void printPortatiles() throws Exception {
        try {
            List<Producto> products = productDAO.getPortatiles();

            if (products.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("PRODUCT LIST");
                System.out.printf("%-40s%-10s\n", "NOMBRE", "PRECIO");

                for (Producto product : products) {
                    System.out.printf("%-40s%-10s\n", product.getNombre(), product.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void printProductoMasBarato() throws Exception {
        try {
            List<Producto> products = productDAO.getProductoMasBarato();

            if (products.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("PRODUCT LIST");
                System.out.printf("%-40s%-10s\n", "NOMBRE", "PRECIO");

                for (Producto product : products) {
                    System.out.printf("%-40s%-10s\n", product.getNombre(), product.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void printModifiedProducts(Integer codigo) throws Exception {
        try {
            
            boolean bandera = false;
            Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
            
            System.out.println("Ingrese el nuevo nombre");
            String nombreProducto = scan.next();
            System.out.println("Ingrese el nuevo precio del producto");
            Double precioActualizado = scan.nextDouble();
            
            List<Producto> products = productDAO.getProducts();

            if (products.isEmpty()) {
                throw new Exception("No existen productos");
            } else {

                for (Producto product : products) {
                    if (product.getCodigo().equals(codigo)) {
                        bandera = true;
                        product.setNombre(nombreProducto);
                        product.setPrecio(precioActualizado);
                        productDAO.modifyProduct(product);
                    }
                }
                if(!bandera){
                    System.out.println("No existe producto con ese codigo");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}

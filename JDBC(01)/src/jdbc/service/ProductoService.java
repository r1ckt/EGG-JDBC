package jdbc.service;

import java.util.List;
import jdbc.entity.Producto;
import jdbc.persistence.ProductoDAO;

public class ProductoService {

    private final ProductoDAO productDAO;

    public ProductoService() {
        productDAO = new ProductoDAO();
    }

    //crear
    public void createProduct(String nombre, Double precio, Integer codigo_fabricante) throws Exception {
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
            product.setCodigoFabricante(codigo_fabricante);
            

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
                    System.out.printf("%-10s%-40s%-15s\n", product.getCodigo(), product.getNombre(), product.getCodigoFabricante());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
  
}




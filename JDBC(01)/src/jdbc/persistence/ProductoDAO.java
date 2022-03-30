package jdbc.persistence;

import java.util.ArrayList;
import java.util.List;
import jdbc.entity.Fabricante;
import jdbc.entity.Producto;

public class ProductoDAO extends DAO {

    // add
    public void addProduct(Producto product) throws Exception {
        try {

            if (product == null) {
                throw new Exception("Error, producto nulo");
            }

            String template = "INSERT INTO producto VALUES(NULL, '%s', '%s', '%s');";
            String sql = String.format(template, product.getNombre(), product.getPrecio(), product.getFabricante().getCodigo());

            System.out.println("STATEMENT");
            System.out.println(sql);

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("No se pudo agregar producto");
        }
    }

    // modify
    public void modifyProduct(Producto product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("Error, producto nulo");
            }

            String template = "UPDATE producto SET nombre = '%s', precio = '%s' WHERE codigo = '%s';";
            String sql = String.format(template, product.getNombre(), product.getPrecio(), product.getCodigo());

            System.out.println("STATEMENT");
            System.out.println(sql);

            insertModifyDelete(sql);

        } catch (Exception e) {
            throw new Exception("No se pudo modificar el producto");
        }
    }

    // delete
    public void deleteProduct(Integer codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo = " + codigo + ";";

            System.out.println("STATEMENT");
            System.out.println(sql);

            insertModifyDelete(sql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar producto");
        }
    }

    // get
    public List<Producto> getProducts() throws Exception {

        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante = fabricante.codigo;";
            queryDatabase(sql);

            List<Producto> products = new ArrayList<>();
            Producto product;
            Fabricante fabricante;

            while (resultSet.next()) {
                product = new Producto();
                fabricante = new Fabricante();

                product.setCodigo(resultSet.getInt(1));
                product.setNombre(resultSet.getString(2));
                product.setPrecio(resultSet.getDouble(3));

                fabricante.setCodigo(resultSet.getInt(4));
                fabricante.setNombre(resultSet.getString(5));

                product.setFabricante(fabricante);

                products.add(product);
            }

            return products;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener la lista de productos");
        } finally {
            disconnectDatabase();
        }
    }

    // se puede mejorar, pasando como parametro el rango de precios
    public List<Producto> getProductsByPriceInterval() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante=fabricante.codigo WHERE precio >=120 AND precio <=202 ;";

            queryDatabase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante = new Fabricante();
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));

                fabricante.setCodigo(resultSet.getInt(5));
                fabricante.setNombre(resultSet.getString(6));
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            return productos;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al obtener productos");
        } finally {
            disconnectDatabase();
        }
    }

    public List<Producto> getPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante=fabricante.codigo WHERE producto.nombre LIKE '%Portatil%';";

            queryDatabase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante = new Fabricante();

                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));

                fabricante.setCodigo(resultSet.getInt(5));
                fabricante.setNombre(resultSet.getString(6));
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            return productos;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al obtener productos");
        } finally {
            disconnectDatabase();
        }
    }

    public List<Producto> getProductoMasBarato() throws Exception {
        try {
            String sql = "SELECT * FROM producto INNER JOIN fabricante ON codigo_fabricante=fabricante.codigo order by precio asc limit 1;";

            queryDatabase(sql);
            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante = new Fabricante();

                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));

                fabricante.setCodigo(resultSet.getInt(5));
                fabricante.setNombre(resultSet.getString(6));
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            return productos;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR al obtener productos");
        } finally {
            disconnectDatabase();
        }
    }
}

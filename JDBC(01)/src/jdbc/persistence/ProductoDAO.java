package jdbc.persistence;

import java.util.ArrayList;
import java.util.List;
import jdbc.entity.Producto;

public class ProductoDAO extends DAO {
    
    // add
    public void addProduct(Producto product) throws Exception{
        try{
            
            if(product == null){
                throw new Exception("Error, producto nulo");
            }
            
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) " + "VALUES (' " + product.getNombre() + "' , '" + product.getPrecio() + "' , '"  + product.getCodigoFabricante() + "');";
            
            System.out.println("STATEMENT");
            System.out.println(sql);
            
            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("No se pudo agregar producto");
        }
    }
    
    // modify
    public void modifyProduct(Producto product) throws Exception{
        try{
             if(product == null){
                throw new Exception("Error, producto nulo");
            }
            
            String template = "UPDATE producto SET nombre = '%s', precio = %.2f WHERE codigo = %d;";
            String sql = String.format(template, product.getNombre(), product.getPrecio(), product.getCodigo());
            
            System.out.println("STATEMENT");
            System.out.println(sql);
            
            insertModifyDelete(sql);
            
        }catch(Exception e){
            throw new Exception("No se pudo modificar el producto");
        }
    }
    
    // delete
    public void deleteProduct(Integer codigo) throws Exception{
        try{
            String sql = "DELETE FROM producto WHERE codigo = " + codigo + ";";
            
            System.out.println("STATEMENT");
            System.out.println(sql);
            
            insertModifyDelete(sql);
        } catch(Exception e){
            throw new Exception("Error al eliminar producto");
        }
    }
    
    // get
    public List<Producto> getProducts() throws Exception {
        
        try{
            String sql = "SELECT * FROM producto;";
            queryDatabase(sql);
            
            List<Producto> products = new ArrayList<>();
            Producto product;
            
            while(resultSet.next()){
                product = new Producto();
                
                product.setCodigo(resultSet.getInt(1));
                product.setNombre(resultSet.getString(2));
                product.setPrecio(resultSet.getDouble(3));
                product.setCodigoFabricante(resultSet.getInt(4));
                
                products.add(product);
            }
            
            return products;

        } catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener la lista de productos");
        } finally {
            disconnectDatabase();
        }
    }
}

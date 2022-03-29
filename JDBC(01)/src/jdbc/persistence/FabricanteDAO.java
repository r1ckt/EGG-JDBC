
package jdbc.persistence;

import java.util.ArrayList;
import java.util.List;
import jdbc.entity.Fabricante;


public class FabricanteDAO extends DAO {
    
    public void addFabricante(Fabricante fabricante) throws Exception{
        try{
            if(fabricante == null){
                throw new Exception("Error, fabricante nulo");
            }
            
            String template = "INSERT INTO fabricante VALUES(NULL, '%s', %d);";
            String sql = String.format(template, fabricante.getNombre(), fabricante.getCodigo());
            
            System.out.println("STATEMENT");
            System.out.println(sql);
            
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw new Exception("No se pudo agregar fabricante");
        }
    }
    
    // modify
    public void modifyFabricante(Fabricante fabricante) throws Exception{
        try{
             if(fabricante == null){
                throw new Exception("Error, fabricante nulo");
            }
            
            String template = "UPDATE fabricante SET nombre = '%s' WHERE codigo = '%d';";
            String sql = String.format(template, fabricante.getNombre(), fabricante.getCodigo());
            
            System.out.println("STATEMENT");
            System.out.println(sql);
            
            insertModifyDelete(sql);
            
        }catch(Exception e){
            throw new Exception("No se pudo modificar el fabricante");
        }
    }
    
    // delete
    public void deleteFabricante(Integer codigo) throws Exception{
        try{
            String sql = "DELETE FROM fabricante WHERE codigo = " + codigo + ";";
            
            System.out.println("STATEMENT");
            System.out.println(sql);
            
            insertModifyDelete(sql);
        } catch(Exception e){
            throw new Exception("Error al eliminar el fabricante");
        }
    }
    
    // get
    public List<Fabricante> getFabricantes() throws Exception {
        
        try{
            String sql = "SELECT * FROM fabricante;";
            queryDatabase(sql);
            
            List<Fabricante> fabricantes = new ArrayList<>();
            Fabricante fabricante;
            
            while(resultSet.next()){
                fabricante = new Fabricante();
                
                fabricante.setCodigo(resultSet.getInt(1));
                fabricante.setNombre(resultSet.getString(2));

                
                fabricantes.add(fabricante);
            }
            
            return fabricantes;

        } catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener la lista de fabricantes");
        } finally {
            disconnectDatabase();
        }
    }
}

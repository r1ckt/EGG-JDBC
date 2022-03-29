package jdbc.principal;

import jdbc.service.FabricanteService;
import jdbc.service.ProductoService;

public class Principal {
    
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        
        FabricanteService fabricanteService = new FabricanteService();
        
        try{
            productoService.printProducts();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        /*
        try{
            
            fabricanteService.printFabricantes();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
*/
    }
    
}

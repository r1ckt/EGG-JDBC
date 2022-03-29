
package jdbc.service;

import java.util.List;
import jdbc.entity.Fabricante;
import jdbc.persistence.FabricanteDAO;

public class FabricanteService {
    
    private final FabricanteDAO fabricanteDAO;

    public FabricanteService() {
        fabricanteDAO = new FabricanteDAO();
    }

    //crear
    public void createFabricante(String nombre, Integer codigo) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre del producto es obligatorio");
            }

            if (codigo < 0) {
                throw new Exception("El codigo del fabricante debe ser un numero positivo");
            }

            Fabricante fabricante = new Fabricante();

            fabricante.setNombre(nombre);
            fabricante.setCodigo(codigo);

            fabricanteDAO.addFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }

    public void printFabricantes() throws Exception {
        try {
            List<Fabricante> fabricantes = fabricanteDAO.getFabricantes();

            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes");
            } else {
                System.out.println("FABRICANTES");
                System.out.printf("%-10s%-15s\n", "ID", "NOMBRE");

                for (Fabricante fabricante : fabricantes) {
                    System.out.printf("%-10s%-15s\n", fabricante.getCodigo(), fabricante.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
  
}



package jdbc.entity;

public class Producto {
    
    private Integer codigo;
    private String nombre;
    private Double precio;
    private Fabricante fabricante;

    public Producto() {
    }

    public Producto(Integer codigo, String nombre, Double precio, Fabricante fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        fabricante = new Fabricante();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return String.format("PRODUCTO (Codigo: %s, Nombre: %s, Precio: %.2f, Codigo del fabricante: %d)" ,codigo, nombre, precio, fabricante);
    }
    
    
    
}

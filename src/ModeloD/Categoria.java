
package ModeloD;

public class Categoria {
    
     private int id_Categoria;
    private String NombreCategoria;
    
    
  
    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public Categoria(int id_Categoria, String NombreCategoria) {
        this.id_Categoria = id_Categoria;
        this.NombreCategoria = NombreCategoria;
    }

   public Categoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    
   } 
    public  String toString(){
        return  NombreCategoria;
       }
    
}


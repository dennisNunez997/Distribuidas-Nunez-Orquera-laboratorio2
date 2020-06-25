
package com.mycompany.aplicaciondistribuida.principal;

import com.mycompany.aplicaciondistribuida.session.ProductoJpaController;
import com.mycompany.aplicaciondistribuida.entidades.Producto;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Test {

    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        
        Producto p = new Producto();
        
        p.setCodigo(1);
        p.setNombre("SOFTWARE RRHH");
        Double precio= 5000.99;
        BigDecimal bd1 = BigDecimal.valueOf(precio);
        p.setPrecio (bd1);
        p.setDetalle("Programas para manejo personal");
        
        try {
            pjc.create(p);
            
        } catch (Exception ex) 
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
    
}

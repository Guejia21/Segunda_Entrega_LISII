package co.edu.unicauca.gui.vistas.articulos;

import co.edu.unicauca.gui.infraestructura.Observer;
import co.edu.unicauca.gui.servicios.ArticuloServices;
import co.edu.unicauca.gui.servicios.ConferenciaServices;
import co.edu.unicauca.gui.modelos.Articulo;
import co.edu.unicauca.gui.utilidades.Utilidades;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class VtnListarArticulos extends javax.swing.JInternalFrame implements Observer {

    private final ArticuloServices objServicioArticulos;
    private final ConferenciaServices objServicioConferencias;
    private final VtnRegistrarArticulo objVtnRegistrarArticulo;
    private final VtnActualizarArticulo objVtnActualizarArticulo;
            
    public VtnListarArticulos(ArticuloServices objServicioArt, ConferenciaServices objServicioConf) {
        initComponents();
        this.objServicioArticulos=objServicioArt;
        this.objServicioConferencias=objServicioConf;
        this.jTableListarArticulos.setDefaultRenderer(Object.class, new Render());
        objVtnRegistrarArticulo=new VtnRegistrarArticulo(this.objServicioArticulos, this.objServicioConferencias);        
        objVtnRegistrarArticulo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        objVtnActualizarArticulo= new VtnActualizarArticulo(this.objServicioArticulos, this.objServicioConferencias);
        objVtnActualizarArticulo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarTabla();
        llenarTabla();
    }

     private void inicializarTabla()
    {
       DefaultTableModel model= new DefaultTableModel();       
       model.addColumn("Id");       
       model.addColumn("Titulo");
       model.addColumn("Autores");
       model.addColumn("Num Autores");
       model.addColumn("Revista");     
       model.addColumn("Eliminar");
       model.addColumn("Actualizar");       
       this.jTableListarArticulos.setModel(model);
    }
     
     public void limpiarTabla(){
        
        DefaultTableModel modelo=(DefaultTableModel) this.jTableListarArticulos.getModel();
        int filas=this.jTableListarArticulos.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }        
    }
     
    private void llenarTabla()
    {
        DefaultTableModel model=(DefaultTableModel) this.jTableListarArticulos.getModel();
        limpiarTabla();
        ArrayList<Articulo> listaArticulos
                = (ArrayList<Articulo>) this.objServicioArticulos.listarArticulos();
        
        JButton JButtonEliminarArticulo = new JButton();
            JButtonEliminarArticulo.setName("Eliminar");
            JButtonEliminarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png")));

        JButton JButtonActualizarArticulo = new JButton();
        JButtonActualizarArticulo.setName("Actualizar");
        JButtonActualizarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aplicar.png")));

 
        String autoresString;
        for (int i = 0; i < listaArticulos.size(); i++) {
            autoresString = String.join(",",listaArticulos.get(i).getAutores());
            Object [] fila= { 
                listaArticulos.get(i).getId(),
                listaArticulos.get(i).getNombre(),
                autoresString,
                listaArticulos.get(i).getCantAutores(),
                listaArticulos.get(i).getRevista(),
                JButtonEliminarArticulo,
                JButtonActualizarArticulo};
            model.addRow(fila);
        }
        
    }
    @Override
    public void update(Object o) {
        llenarTabla();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarArticulos = new javax.swing.JTable();
        jButtonRegistrar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Gestionar articulos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 0, 153));

        jTableListarArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableListarArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarArticulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListarArticulos);

        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar articulo");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jButtonRegistrar)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        objVtnRegistrarArticulo.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jTableListarArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarArticulosMouseClicked
        
        int column = this.jTableListarArticulos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableListarArticulos.getRowHeight();
        
        if(row < jTableListarArticulos.getRowCount() && row >= 0 && column < jTableListarArticulos.getColumnCount() && column >= 0){
            Object value = jTableListarArticulos.getValueAt(row, column);
            
            if(value instanceof JButton){
                
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                String idArticulo = jTableListarArticulos.getValueAt(row, 0).toString();
                int idArticuloConvertido=Integer.parseInt(idArticulo);
                if(boton.getName().equals("Eliminar")){
                    try{  
                        if(Utilidades.mensajeConfirmacion("¿ Estás seguro de que quieres eliminar el artículo con identificador " + idArticulo + " " 
                            +" ?", "Confirmación") == 0){
                           boolean bandera=this.objServicioArticulos.eliminarArticulo(idArticuloConvertido);
                           if(bandera==true)
                           {
                               Utilidades.mensajeExito("El articulo con identificador " + idArticuloConvertido + " fue eliminado exitosamente", "Articulo eliminado");
                               llenarTabla();
                           }
                           else
                           {
                               Utilidades.mensajeAdvertencia("El artículo con identificador " + idArticuloConvertido + " no fue eliminado", "Error al eliminar");
                        
                           }
                        }
                    }catch(Exception ex){
                        Utilidades.mensajeError("Error al eliminar usuario. Intentelo de nuevo más tarde", "Error");
                    }  
                }
                else if(boton.getName().equals("Actualizar")){
                    objVtnActualizarArticulo.cargarDatos(idArticuloConvertido);
                    objVtnActualizarArticulo.setVisible(true);
                            
                }
            }
        }
        
        
    }//GEN-LAST:event_jTableListarArticulosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarArticulos;
    // End of variables declaration//GEN-END:variables

    
}

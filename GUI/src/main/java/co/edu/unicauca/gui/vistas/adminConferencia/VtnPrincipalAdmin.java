package co.edu.unicauca.gui.vistas.adminConferencia;


import co.edu.unicauca.gui.controladores.ServicioAlmacenamientoArticulos;
import co.edu.unicauca.gui.controladores.ServicioAlmacenamientoConferencias;
import co.edu.unicauca.gui.vistas.articulos.VtnListarArticulos;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VtnPrincipalAdmin extends javax.swing.JFrame {
    
    private VtnVerEstadisticas objVtnVerEstadisticas;
    private VtnListarArticulos objVtnListarArticulos;
    private VtnListarConferencias objVtnListarConferencias;
    private ServicioAlmacenamientoConferencias objServicio1;   
    private ServicioAlmacenamientoArticulos  objServicio2;
        
    public VtnPrincipalAdmin() {
        initComponents();
        establecerIconoOrganización();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void asociarServios(
            ServicioAlmacenamientoConferencias objServicio1,
            ServicioAlmacenamientoArticulos objServicio2)
    {
        this.objServicio1=objServicio1;
        this.objServicio2=objServicio2;
        relacionarInternalFrameConJdesptokPane();
    }
    
    private void relacionarInternalFrameConJdesptokPane()
    {
        this.objVtnVerEstadisticas=new VtnVerEstadisticas();         
        this.jDesktopPanelPrincipal.add(this.objVtnVerEstadisticas);
        
        this.objVtnListarArticulos= new VtnListarArticulos(this.objServicio2, this.objServicio1);
        this.jDesktopPanelPrincipal.add(this.objVtnListarArticulos);
        
        this.objVtnListarConferencias= new VtnListarConferencias(this.objServicio1);
        this.jDesktopPanelPrincipal.add(this.objVtnListarConferencias);
    }

    private void establecerIconoOrganización()
    {
        Image img1= new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage();
        ImageIcon img2=new ImageIcon(img1.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        this.jLabelImagenOrganizacion.setIcon(img2);
        this.jLabelImagenOrganizacion.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jLabelImagenOrganizacion = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jButtonGestionarConferencias = new javax.swing.JButton();
        jButtonVerArticulosEnviados = new javax.swing.JButton();
        jButtonVerEstadisticas = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelInferior = new javax.swing.JPanel();
        jPanelCentral = new javax.swing.JPanel();
        jDesktopPanelPrincipal = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelImagenOrganizacion.setText("jLabel1");

        jPanelMenu.setBackground(new java.awt.Color(153, 153, 255));

        jButtonGestionarConferencias.setText("Gestionar conferencias");
        jButtonGestionarConferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarConferenciasActionPerformed(evt);
            }
        });

        jButtonVerArticulosEnviados.setText("Ver articulos enviados");
        jButtonVerArticulosEnviados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerArticulosEnviadosActionPerformed(evt);
            }
        });

        jButtonVerEstadisticas.setText("Ver estadisticas");
        jButtonVerEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerEstadisticasActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Cantarell Extra Bold", 1, 15)); // NOI18N
        jLabelTitulo.setText("GESTIÓN DE CONFERENCIAS");

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTitulo)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jButtonGestionarConferencias)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonVerArticulosEnviados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButtonVerEstadisticas)
                .addGap(38, 38, 38))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGestionarConferencias)
                    .addComponent(jButtonVerArticulosEnviados)
                    .addComponent(jButtonVerEstadisticas))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabelImagenOrganizacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenOrganizacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jDesktopPanelPrincipalLayout = new javax.swing.GroupLayout(jDesktopPanelPrincipal);
        jDesktopPanelPrincipal.setLayout(jDesktopPanelPrincipalLayout);
        jDesktopPanelPrincipalLayout.setHorizontalGroup(
            jDesktopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        jDesktopPanelPrincipalLayout.setVerticalGroup(
            jDesktopPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPanelPrincipal)
                .addContainerGap())
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPanelPrincipal)
                .addContainerGap())
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerArticulosEnviadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerArticulosEnviadosActionPerformed
        this.objVtnListarArticulos.setVisible(true);
        this.objVtnVerEstadisticas.setVisible(false);
        this.objVtnListarConferencias.setVisible(false);
    }//GEN-LAST:event_jButtonVerArticulosEnviadosActionPerformed

    private void jButtonVerEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerEstadisticasActionPerformed
        this.objVtnVerEstadisticas.setVisible(true);
        this.objVtnListarArticulos.setVisible(false);
        this.objVtnListarConferencias.setVisible(false);
    }//GEN-LAST:event_jButtonVerEstadisticasActionPerformed

    private void jButtonGestionarConferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarConferenciasActionPerformed
        this.objVtnListarConferencias.setVisible(true);
        this.objVtnVerEstadisticas.setVisible(false);
        this.objVtnListarArticulos.setVisible(false);
    }//GEN-LAST:event_jButtonGestionarConferenciasActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGestionarConferencias;
    private javax.swing.JButton jButtonVerArticulosEnviados;
    private javax.swing.JButton jButtonVerEstadisticas;
    private javax.swing.JDesktopPane jDesktopPanelPrincipal;
    private javax.swing.JLabel jLabelImagenOrganizacion;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelSuperior;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionistag23.vistas;

import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import nutricionistag23.accesoADatos.HistorialData;
import nutricionistag23.accesoADatos.PacienteData;
import nutricionistag23.accesoADatos.Validaciones;
import nutricionistag23.entidades.Historial;

/**
 *
 * @author jonac
 */
public class HistorialPacienteVista extends javax.swing.JInternalFrame {

    public static int pesoActual;
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form HistorialPacienteVista
     */
    public HistorialPacienteVista() {
        PacienteData pData = new PacienteData();
        initComponents();
        armarCabecera();
        llenarTabla();
        jbModificar.setEnabled(false);
        jdcFechaRegistro.setEnabled(true);
        jbCancelar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jlNombrePaciente1.setText(pData.buscarPacienteXId(PacienteVista.pacienteid).getNombre());
        jlDNIPaciente.setText(pData.buscarPacienteXId(PacienteVista.pacienteid).getDni() + "");
        jdcFechaRegistro.setDate(Date.valueOf(LocalDate.now()));
        jsPeso.setModel(new SpinnerNumberModel(0.0, 0.0, 500.0, 0.1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHistorial = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jlPA = new javax.swing.JLabel();
        jdcFechaRegistro = new com.toedter.calendar.JDateChooser();
        jbModificar = new javax.swing.JButton();
        jbCrear = new javax.swing.JButton();
        jsPeso = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlDNIPaciente = new javax.swing.JLabel();
        jlNombrePaciente1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPaneInfo = new javax.swing.JPanel();
        jLInfo = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro Historico del Paciente");
        setPreferredSize(new java.awt.Dimension(410, 446));

        contenedor.setBackground(new java.awt.Color(191, 255, 183));
        contenedor.setForeground(new java.awt.Color(135, 250, 177));
        contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtHistorial.setBackground(new java.awt.Color(230, 255, 227));
        jtHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtHistorial.setSelectionBackground(new java.awt.Color(68, 106, 61));
        jtHistorial.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jtHistorial.getTableHeader().setReorderingAllowed(false);
        jtHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtHistorialMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtHistorial);

        contenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 161, 362, 178));

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione un historial");
        contenedor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 140, 150, -1));

        jlPA.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jlPA.setText("Peso");
        contenedor.add(jlPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 26));

        jdcFechaRegistro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcFechaRegistroPropertyChange(evt);
            }
        });
        contenedor.add(jdcFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 90, 132, -1));

        jbModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });
        contenedor.add(jbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 358, -1, 30));

        jbCrear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbCrear.setText("Crear");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });
        contenedor.add(jbCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 358, 80, 30));
        contenedor.add(jsPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 90, 68, -1));

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel1.setText("Nombre");
        contenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 20, -1, 24));

        jLabel4.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        jLabel4.setText("DNI");
        contenedor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 50, 30, 18));

        jlDNIPaciente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlDNIPaciente.setForeground(new java.awt.Color(0, 86, 20));
        contenedor.add(jlDNIPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 50, 300, 20));

        jlNombrePaciente1.setBackground(new java.awt.Color(255, 255, 255));
        jlNombrePaciente1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlNombrePaciente1.setForeground(new java.awt.Color(0, 86, 20));
        contenedor.add(jlNombrePaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 20, 260, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Gabriola", 1, 16)); // NOI18N
        jLabel5.setText("Fecha Registro");
        contenedor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 91, 90, 30));

        jbCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        contenedor.add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 358, -1, 30));

        jbEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.setMaximumSize(new java.awt.Dimension(83, 32));
        jbEliminar.setMinimumSize(new java.awt.Dimension(83, 32));
        jbEliminar.setPreferredSize(new java.awt.Dimension(83, 31));
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        contenedor.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 358, -1, 30));
        contenedor.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 68, 300, 10));
        contenedor.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 40, 260, 10));

        jPaneInfo.setBackground(new java.awt.Color(140, 184, 132));
        jPaneInfo.setForeground(new java.awt.Color(255, 255, 255));
        jPaneInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPaneInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPaneInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPaneInfoMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPaneInfoMouseReleased(evt);
            }
        });

        jLInfo.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLInfo.setText("?");

        javax.swing.GroupLayout jPaneInfoLayout = new javax.swing.GroupLayout(jPaneInfo);
        jPaneInfo.setLayout(jPaneInfoLayout);
        jPaneInfoLayout.setHorizontalGroup(
            jPaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPaneInfoLayout.setVerticalGroup(
            jPaneInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contenedor.add(jPaneInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        HistorialData hData = new HistorialData();
        PacienteData pData = new PacienteData();
        try {
            if ((double) jsPeso.getValue() > 0) {
                Historial historial = new Historial((int) modeloTabla.getValueAt(jtHistorial.getSelectedRow(), 0), pData.buscarPacienteXId(PacienteVista.pacienteid), (double) jsPeso.getValue(), jdcFechaRegistro.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),true);
                hData.modificarHistorial(historial);
                tableClean();
                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "El valor ingresado debe ser mayor a 0 (cero)");
            }
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha válida");
        }
        jbCancelar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbModificar.setEnabled(false);
        jbCrear.setEnabled(true);
        jdcFechaRegistro.setDate(Date.valueOf(LocalDate.now()));
        jsPeso.setValue((double) 0);
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jtHistorialMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHistorialMouseReleased
        jbModificar.setEnabled(true);
        jbCrear.setEnabled(false);
        jbCancelar.setEnabled(true);
        jbEliminar.setEnabled(true);
        jdcFechaRegistro.setDate(Date.valueOf((LocalDate) modeloTabla.getValueAt(jtHistorial.getSelectedRow(), 2)));
        jsPeso.setValue((double) modeloTabla.getValueAt(jtHistorial.getSelectedRow(), 1));
    }//GEN-LAST:event_jtHistorialMouseReleased

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed

        HistorialData hData = new HistorialData();
        PacienteData pData = new PacienteData();
        try {
            if ((double) jsPeso.getValue() > 0) {
                Historial historial = new Historial(pData.buscarPacienteXId(PacienteVista.pacienteid), (double) jsPeso.getValue(), jdcFechaRegistro.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),true);
                hData.guardarHistorial(historial);
                tableClean();
                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "El valor ingresado debe ser mayor a 0 (cero)");
            }
            jsPeso.setValue((double) 0);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha válida");
        }


    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jbModificar.setEnabled(false);
        jbCrear.setEnabled(true);
        jbCancelar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jdcFechaRegistro.setDate(Date.valueOf(LocalDate.now()));
        jsPeso.setValue((double) 0);


    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        HistorialData hData = new HistorialData();
        if (JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea Eliminar?") == 0) {
            hData.eliminarHistorial((int) modeloTabla.getValueAt(jtHistorial.getSelectedRow(), 0));
            jbEliminar.setEnabled(false);
            jbModificar.setEnabled(false);
            jbCrear.setEnabled(true);
            jdcFechaRegistro.setDate(Date.valueOf(LocalDate.now()));
            jsPeso.setValue((double) 0);
            tableClean();
            llenarTabla();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jdcFechaRegistroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcFechaRegistroPropertyChange
        if (!Validaciones.validacionInmediataFecha(jdcFechaRegistro.getDate())) {
            JOptionPane.showMessageDialog(this, "La fecha ingresada no puede ser posterior a la actual.");
            jdcFechaRegistro.setDate(Date.valueOf(LocalDate.now()));
        }
    }//GEN-LAST:event_jdcFechaRegistroPropertyChange

    private void jPaneInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPaneInfoMouseEntered
        jPaneInfo.setBackground(new Color(195, 255, 184));
        jLInfo.setForeground(Color.BLACK);
    }//GEN-LAST:event_jPaneInfoMouseEntered

    private void jPaneInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPaneInfoMouseExited
        jPaneInfo.setBackground(new Color(140, 184, 132));
        jLInfo.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPaneInfoMouseExited

    private void jPaneInfoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPaneInfoMouseReleased
        JOptionPane.showMessageDialog(this, "-Presione el botón [Crear] para registrar un nuevo historial cargando el Peso y la fecha de Registro.\n"
                +"\n"
                + "-Para [Modificar] Peso y/o Fecha de Registro o [Eliminar] una fila, seleccionela y presione el botón correspondiente.\n"
                + " Caso contrario presione el botón [Cancelar].");
    }//GEN-LAST:event_jPaneInfoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPaneInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private com.toedter.calendar.JDateChooser jdcFechaRegistro;
    private javax.swing.JLabel jlDNIPaciente;
    private javax.swing.JLabel jlNombrePaciente1;
    private javax.swing.JLabel jlPA;
    private javax.swing.JSpinner jsPeso;
    private javax.swing.JTable jtHistorial;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {// Arma la cabecera de la tabla
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Peso");
        modeloTabla.addColumn("Fecha Registro");
        jtHistorial.setModel(modeloTabla);
        jtHistorial.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtHistorial.getColumnModel().getColumn(1).setPreferredWidth(30);
        jtHistorial.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTableHeader header = jtHistorial.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer(jtHistorial));
    }

    private void llenarTabla() {

        HistorialData hData = new HistorialData();
        List<Historial> listaHistorial = hData.listaHistorial(PacienteVista.pacienteid)
                .stream()
                .sorted(Comparator.comparing(Historial::getFechaRegistro))
                .collect(Collectors.toList());
        for (Historial historial : listaHistorial) {
            modeloTabla.addRow(new Object[]{historial.getIdHistorial(), historial.getPeso(), historial.getFechaRegistro()});
        }
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//Alinea los datos de las celdas numericas a la derecha 
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jtHistorial.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtHistorial.getColumnModel().getColumn(1).setCellRenderer(tcr);
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtHistorial.getColumnModel().getColumn(2).setCellRenderer(tcr);

    }

    private void tableClean() {
        //limpia la tabla de historiales
        if (jtHistorial.getRowCount() != 0) {
            int largo = jtHistorial.getRowCount() - 1;
            for (; largo >= 0; largo--) {
                modeloTabla.removeRow(largo);
            }
        }
    }
}

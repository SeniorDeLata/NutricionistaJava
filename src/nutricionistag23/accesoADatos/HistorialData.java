/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionistag23.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nutricionistag23.entidades.Historial;
import nutricionistag23.entidades.Paciente;

/**
 *
 * @author jonac
 */
public class HistorialData {

    private Connection con = null;

    public HistorialData() {
        con = Conexion.conectarServidor();

    }

    public void guardarHistorial(Historial historial) {

        String sql = "INSERT INTO historial (idPaciente, peso, fechaRegistro,estado)"
                + "VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, historial.getPaciente().getIdPaciente());
            ps.setDouble(2, historial.getPeso());
            ps.setDate(3, Date.valueOf(historial.getFechaRegistro()));
            ps.setBoolean(4, true);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Historial ingresado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.");
        }

    }

    public List<Historial> listaHistorial(int idPaciente) {
        List<Historial> listaHistorial = new ArrayList<>();
        PacienteData pData = new PacienteData();
        String sql = "SELECT * FROM historial WHERE idPaciente =" + idPaciente+" AND estado = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaHistorial.add(new Historial(rs.getInt("idHistorial"), pData.buscarPacienteXId(rs.getInt("idPaciente")), rs.getDouble("peso"), rs.getDate("fechaRegistro").toLocalDate(),rs.getBoolean("estado")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos." + ex.getMessage());
        }
        return listaHistorial;

    }
    

    public Historial buscarHistorialXIdPYFecha(int idPaciente, LocalDate fecha) {
        PacienteData pData = new PacienteData();
        Historial historial = null;
        String sql = "SELECT * FROM historial WHERE idPaciente =? AND fechaRegistro =? AND estado = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaciente);
            ps.setDate(2, Date.valueOf(fecha));
            ps.setBoolean(3, true);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                historial = new Historial();
                historial.setIdHistorial(rs.getInt("idHistorial"));
                historial.setPeso(rs.getDouble("peso"));
                historial.setPaciente(pData.buscarPacienteXId(rs.getInt("idPaciente")));
                historial.setFechaRegistro(rs.getDate("fechaRegistro").toLocalDate());
                historial.setEstado(rs.getBoolean("estado"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos." + ex.getMessage());
        }
        return historial;

    }

    public Historial buscarHistorialXId(int id) {
        Historial historial = null;
        PacienteData pData = new PacienteData();
        String sql = "SELECT * FROM historial WHERE idHistorial = ? AND estado = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setBoolean(2, true);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                historial = new Historial();
                historial.setIdHistorial(id);
                historial.setPeso(rs.getDouble("peso"));
                historial.setPaciente(pData.buscarPacienteXId(rs.getInt("idPaciente")));
                historial.setFechaRegistro(rs.getDate("fechaRegistro").toLocalDate());
                historial.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "El historial no se encontró");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos." + ex.getMessage());
        }
        return historial;

    }

    public void modificarHistorial(Historial historial) {
        String sql = "UPDATE historial SET peso=?, fechaRegistro=? WHERE idHistorial=" + historial.getIdHistorial();
        if (historial.equals(buscarHistorialXId(historial.getIdHistorial()))) {
            JOptionPane.showMessageDialog(null, "No hubo modificacion");
        } else {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, historial.getPeso());
                ps.setDate(2, Date.valueOf(historial.getFechaRegistro()));
                if (ps.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "Historial no encontrado");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos." + e.getMessage());
            }
        }
    }

    public void eliminarHistorial(int idHistorial) {
        String sql = "UPDATE historial SET estado=0 WHERE idHistorial=" + idHistorial;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Entrada eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Entrada no encontrada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos." + e.getMessage());
        }
    }
}

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
import nutricionistag23.entidades.Dieta;

public class DietaData {

    private Connection con = null;

    public DietaData() {
        con = Conexion.conectarServidor();

    }

    public void guardarDieta(Dieta dieta) {

        String sql = "INSERT INTO dieta(nombre, idPaciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal, estado)"
                + "VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dieta.getNombre());
            if (dieta.getPaciente() == null) {
                ps.setNull(2, 0);
            } else {
                ps.setInt(2, dieta.getPaciente().getIdPaciente());
            }
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoFinal());
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.setBoolean(7, true);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dieta ingresada correctamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.");
        }

    }

    public void borrarDieta(int idDieta) {

        String sql = "UPDATE dieta SET estado=0 WHERE idDieta=" + idDieta;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            if (ps.executeUpdate() == 1) {

                JOptionPane.showMessageDialog(null, "Dieta eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "Dieta inexistente.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar una dieta asociadas a una dietaComida");
        }

    }

    public void modificarDieta(Dieta dieta) {

        String sql = "UPDATE dieta SET nombre=?,idPaciente=?,fechaInicial=?,pesoInicial=?,pesoFinal=?,fechaFinal=? WHERE idDieta=" + dieta.getIdDieta();

        if (dieta.equals(buscarDieta(dieta.getIdDieta()))) {
            JOptionPane.showMessageDialog(null, "No hubo modificacion");
        } else {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, dieta.getNombre());
                if (dieta.getPaciente() == null) {
                    ps.setNull(2, 0);
                } else {
                    ps.setInt(2, dieta.getPaciente().getIdPaciente());
                }
                ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
                ps.setDouble(4, dieta.getPesoInicial());
                ps.setDouble(5, dieta.getPesoFinal());
                ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
                if (ps.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Dieta modificada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Dieta no encontrada.");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No fue posible acceder a la tabla Dieta" + e.getMessage());
            }
        }

    }

    public Dieta buscarDieta(int idDieta) {

        Dieta dieta = null;
        PacienteData paciente = new PacienteData();

        String sql = "SELECT * FROM dieta WHERE idDieta=" + idDieta + " AND estado = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(idDieta);
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(paciente.buscarPacienteXId(rs.getInt("idPaciente")));
                dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                dieta.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible acceder a la tabla Dieta" + e.getMessage());
        }
        return dieta;
    }

    public List<Dieta> listaDieta() {

        List<Dieta> listaDietas = new ArrayList<>();
        String sql = "SELECT * FROM dieta WHERE estado = ?";
        PacienteData pData = new PacienteData();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaDietas.add(new Dieta(rs.getInt("idDieta"), rs.getString("nombre"), pData.buscarPacienteXId(rs.getInt("idPaciente")),
                         rs.getDate("fechaInicial").toLocalDate(), rs.getDouble("pesoInicial"), rs.getDouble("pesoFinal"), rs.getDate("fechaFinal").toLocalDate(), rs.getBoolean("estado")));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible acceder a la tabla Dieta" + e.getMessage());
        }

        return listaDietas;
    }

    public List<Dieta> listaDietaXPaciente(int idPaciente) {

        List<Dieta> listaDietas = new ArrayList<>();
        String sql = "SELECT * FROM dieta WHERE idPaciente = ? AND estado = ?";
        PacienteData pData = new PacienteData();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaciente);
            ps.setBoolean(2, true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaDietas.add(new Dieta(rs.getInt("idDieta"), rs.getString("nombre"), pData.buscarPacienteXId(rs.getInt("idPaciente")),
                         rs.getDate("fechaInicial").toLocalDate(), rs.getDouble("pesoInicial"), rs.getDouble("pesoFinal"), rs.getDate("fechaFinal").toLocalDate(), rs.getBoolean("estado")));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible acceder a la tabla Dieta" + e.getMessage());
        }

        return listaDietas;
    }

}

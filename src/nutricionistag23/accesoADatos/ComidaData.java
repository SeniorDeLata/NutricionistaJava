package nutricionistag23.accesoADatos;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nutricionistag23.entidades.Comida;

public class ComidaData {

    private Connection con = null;

    public ComidaData() {
        con = Conexion.conectarServidor();

    }

    public void guardaComida(Comida comida) {

        String sql = "INSERT INTO comida (nombre, detalle, cantCalorias,estado)"
                + "VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.setBoolean(4, true);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comida ingresada correctamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.");
        }

    }

    public Comida buscarComida(int idComida) {
        Comida comida = null;
        String sql = "SELECT * FROM comida WHERE idComida = " + idComida +" AND estado = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comida = new Comida();
                comida.setIdComida(idComida);
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
                comida.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible acceder a la tabla Comida" + e.getMessage());
        }

        return comida;

    }

    public void borrarComida(int idComida) {

        String sql = "UPDATE comida SET estado=0 WHERE idComida = " + idComida;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            if (ps.executeUpdate() == 1) {

                JOptionPane.showMessageDialog(null, "Comida eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Comida inexistente");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar comidas asociadas a una dieta" );
        }
    }

    public void modificarComida(Comida comida) {

        String sql = "UPDATE comida SET nombre=?,detalle=?,cantCalorias=? WHERE idComida=" + comida.getIdComida();

        if (comida.equals(buscarComida(comida.getIdComida()))) {
            JOptionPane.showMessageDialog(null, "No hubo modificacion");
        } else {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, comida.getNombre());
                ps.setString(2, comida.getDetalle());
                ps.setInt(3, comida.getCantCalorias());
                if (ps.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "Comida no encontrada");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No fue posible acceder a la tabla Comida" + e.getMessage());
            }
        }

    }

    public List<Comida> listaComida() {

        List<Comida> listaComidas = new ArrayList<>();
        String sql = "SELECT * FROM comida WHERE estado = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaComidas.add(new Comida(rs.getString("nombre"), rs.getString("detalle"), rs.getInt("cantCalorias"), rs.getInt("idComida"),rs.getBoolean("estado")));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible acceder a la tabla Comida" + e.getMessage());
        }

        return listaComidas;

    }
    
}

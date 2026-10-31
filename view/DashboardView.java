package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

// Conoce componentes gráficos, sin depender del modelo ni del controlador.
public class DashboardView extends JFrame {
    private final JPanel contenedor = new JPanel(new GridLayout(0, 2, 10, 10));
    private final JButton actualizar = new JButton("Actualizar todos");
    private final JButton interactuar = new JButton("Interactuar por ID");
    private final JTextField id = new JTextField(5);
    private final JLabel estado = new JLabel("Selecciona una acción o usa los botones de cada widget.");

    public DashboardView() {
        super("Dashboard MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Mi Dashboard", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 24f));
        JPanel acciones = new JPanel(new FlowLayout());
        acciones.add(actualizar);
        acciones.add(new JLabel("ID del widget:"));
        acciones.add(id);
        acciones.add(interactuar);

        JPanel superior = new JPanel(new BorderLayout());
        superior.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        superior.add(titulo, BorderLayout.NORTH);
        superior.add(acciones, BorderLayout.SOUTH);
        add(superior, BorderLayout.NORTH);

        contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(contenedor), BorderLayout.CENTER);
        estado.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        add(estado, BorderLayout.SOUTH);
        setSize(1200, 700);
        setLocationRelativeTo(null);
    }

    public void mostrarWidgets(List<JComponent> vistas) {
        contenedor.removeAll();
        for (JComponent vista : vistas) {
            contenedor.add(vista);
        }
        actualizarVista();
    }

    public void alActualizar(ActionListener accion) {
        actualizar.addActionListener(accion);
    }

    public void alInteractuar(ActionListener accion) {
        interactuar.addActionListener(accion);
        id.addActionListener(accion);
    }

    public String getIdIngresado() {
        return id.getText().trim();
    }

    public void mostrarEstado(String mensaje) {
        estado.setText(mensaje);
    }

    public void actualizarVista() {
        contenedor.revalidate();
        contenedor.repaint();
    }
}

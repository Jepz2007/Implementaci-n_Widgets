package TiposWidgets;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Interactivo;
import model.Task;
import model.Widget;

public class TaskWidget implements Widget, Interactivo {

    private final int id;
    private final String nombre;
    private final double memoria;
    private final Task[] pendientes;

    private final JPanel panel;
    private final JPanel listaTareas;
    private final JButton boton;

    public TaskWidget(int id, String nombre, double memoria,
                      Task[] pendientes) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.pendientes = pendientes.clone();

        panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(nombre));

        listaTareas = new JPanel();
        listaTareas.setLayout(
                new BoxLayout(listaTareas, BoxLayout.Y_AXIS)
        );

        boton = new JButton("Completar siguiente tarea");
        boton.addActionListener(evento -> interactuar());

        panel.add(listaTareas, BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);

        renderizar();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getMemoria() {
        return memoria;
    }

    @Override
    public void renderizar() {
        listaTareas.removeAll();
        boolean hayPendientes = false;

        for (Task tarea : pendientes) {
            String estado = tarea.isCompletada()
                    ? "Completada"
                    : "Pendiente";

            JLabel etiqueta = new JLabel(
                    tarea.getTarea() + " - " + estado
            );

            etiqueta.setForeground(
                    "azul".equals(tarea.getColor())
                            ? Color.BLUE
                            : Color.RED
            );

            listaTareas.add(etiqueta);

            if (!tarea.isCompletada()) {
                hayPendientes = true;
            }
        }

        boton.setEnabled(hayPendientes);
        listaTareas.revalidate();
        listaTareas.repaint();
    }

    @Override
    public void interactuar() {
        marcarCompletada();
    }

    public void marcarCompletada() {
        for (Task tarea : pendientes) {
            if (!tarea.isCompletada()) {
                tarea.completar();
                break;
            }
        }

        renderizar();
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }
}
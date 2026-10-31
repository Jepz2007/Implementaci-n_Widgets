package model.TiposWidgets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Interactivo;
import model.Widget;

public class AlertWidget implements Widget, Interactivo {

    private final int id;
    private final String nombre;
    private final double memoria;
    private final String mensaje;
    private final int prioridad;
    private boolean leido;

    private final JPanel panel;
    private final JLabel etiqueta;
    private final JButton boton;

    public AlertWidget(int id, String nombre, double memoria,
                       String mensaje, int prioridad, boolean leido) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.leido = leido;

        panel = new JPanel();
        etiqueta = new JLabel();
        boton = new JButton("Marcar como leído");

        boton.addActionListener(evento -> interactuar());

        panel.add(etiqueta);
        panel.add(boton);

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

    public String getMensaje() {
        return mensaje;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean isLeido() {
        return leido;
    }

    public void marcarLeido() {
        leido = true;
        renderizar();
    }

    @Override
    public void interactuar() {
        marcarLeido();
    }

    @Override
    public void renderizar() {
        String estado = leido ? "Leído" : "Pendiente";

        etiqueta.setText(
                nombre + ": " + mensaje
                + " | Prioridad: " + prioridad
                + " | " + estado
        );

        boton.setEnabled(!leido);
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }
}
package model.TiposWidgets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Widget;

public class QuoteWidget implements Widget {

    private final int id;
    private final String nombre;
    private final double memoria;
    private final String frase;

    private final JPanel panel;
    private final JLabel etiqueta;

    public QuoteWidget(int id, String nombre, double memoria, String frase) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.frase = frase;

        panel = new JPanel();
        etiqueta = new JLabel();
        panel.add(etiqueta);

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
        etiqueta.setText(nombre + ": " + frase);
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }
}

package model.TiposWidgets;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Widget;

public class ClockWidget implements Widget {

    private final int id;
    private final String nombre;
    private final double memoria;

    private final JPanel panel;
    private final JLabel etiqueta;
    private final Timer temporizador;

    private final DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    public ClockWidget(int id, String nombre, double memoria) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;

        panel = new JPanel();
        etiqueta = new JLabel();
        panel.add(etiqueta);

        temporizador = new Timer(1000, evento -> renderizar());

        panel.addHierarchyListener(evento -> {
            if (panel.isShowing()) {
                temporizador.start();
            } else {
                temporizador.stop();
            }
        });

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
        etiqueta.setText(nombre + ": " + LocalTime.now().format(formato));
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }
}
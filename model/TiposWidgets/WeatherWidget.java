package model.TiposWidgets;

import model.Widget;
import model.Interactivo;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WeatherWidget implements Widget, Interactivo {

    private final int id;
    private final String nombre;
    private final double memoria;
    private final double temperatura;
    private final String ciudad;

    private boolean mostrarFahrenheit = false;

    private final JPanel panel;
    private final JLabel etiqueta;
    private final JButton boton;

    public WeatherWidget(int id, String nombre, double memoria,
                         double temperatura, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.memoria = memoria;
        this.temperatura = temperatura;
        this.ciudad = ciudad;

        panel = new JPanel(new FlowLayout());
        etiqueta = new JLabel();
        boton = new JButton();

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

    @Override
    public void renderizar() {
        double valor = mostrarFahrenheit
                ? temperatura * 9.0 / 5.0 + 32
                : temperatura;

        String unidad = mostrarFahrenheit ? "°F" : "°C";

        etiqueta.setText(String.format(
                "%s - %s: %.1f %s",
                nombre, ciudad, valor, unidad
        ));

        boton.setText(mostrarFahrenheit
                ? "Cambiar a °C"
                : "Cambiar a °F");
    }

    @Override
    public void interactuar() {
        mostrarFahrenheit = !mostrarFahrenheit;
        renderizar();
    }

    @Override
    public JComponent obtenerVista() {
        return panel;
    }
}
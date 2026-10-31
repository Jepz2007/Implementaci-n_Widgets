package controller;

import model.Dashboard;
import model.Widget;
import view.DashboardView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

public class DashboardController {
    private final Dashboard modelo;
    private final DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.alActualizar(evento -> actualizarTodos());
        vista.alInteractuar(evento -> interactuar());
    }

    public void iniciar() {
        List<JComponent> paneles = new ArrayList<>();
        for (Widget widget : modelo.getWidgets()) {
            paneles.add(widget.obtenerVista());
        }
        vista.mostrarWidgets(paneles);
        vista.setVisible(true);
    }

    private void actualizarTodos() {
        modelo.actualizarTodos();
        vista.actualizarVista();
        vista.mostrarEstado("Se actualizaron los " + modelo.getWidgets().size() + " widgets.");
    }

    private void interactuar() {
        try {
            int id = Integer.parseInt(vista.getIdIngresado());
            vista.mostrarEstado(modelo.interactuarConWidget(id));
            vista.actualizarVista();
        } catch (NumberFormatException error) {
            vista.mostrarEstado("Escribe un ID numérico válido.");
        }
    }
}

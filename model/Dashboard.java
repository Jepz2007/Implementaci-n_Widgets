package model;

import model.TiposWidgets.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Gestiona widgets; no construye ni organiza la ventana principal.
public class Dashboard {
    private final List<Widget> widgetsExistentes;

    public Dashboard() {
        widgetsExistentes = Collections.unmodifiableList(Arrays.asList(
            widgetclima1, widgetclima2, widgettarea1, widgettarea2,
            widgetalerta1, widgetalerta2, widgetreloj1, widgetreloj2,
            widgetfrase1, widgetfrase2
        ));
    }

    //Widgests del clima

    private WeatherWidget widgetclima1 = new WeatherWidget(101, "Clima 1", 12.0, 35.0, "Mixco");
    private WeatherWidget widgetclima2 = new WeatherWidget(102, "Clima 2", 15.0, 38.0, "Palencia");
    
    //Widgets de tareas

    private Task tarea1 = new Task("Estudiar Java", false);
    private Task tarea2 = new Task("Hacer ejercicio", false);
    private Task tarea3 = new Task("Aprender UML", false);
    private Task tarea4 = new Task("Leer código", false);
  
    private Task[] pendientes1 = {tarea1, tarea2};
    private Task[] pendientes2 = {tarea3, tarea4};
    
    private TaskWidget widgettarea1 = new TaskWidget(201, "Pendientes 1", 30, pendientes1);
    private TaskWidget widgettarea2 = new TaskWidget(202, "Pendientes 2", 35, pendientes2);

    //Widgets de Alerta
    private AlertWidget widgetalerta1 = new AlertWidget(301, "Pasear al perro", 15.5, "Se detectó un acceso nuevo", 1, false);
    private AlertWidget widgetalerta2 = new AlertWidget(302, "Comprar medicina", 8.0, "Tienes una reunión pendiente", 2, true);

    //Widgets de reloj
    private ClockWidget widgetreloj1 = new ClockWidget(401, "Reloj principal", 5.0);
    private ClockWidget widgetreloj2 = new ClockWidget(402, "Reloj secundario", 3.5);

    //Widgets de frase
    private QuoteWidget widgetfrase1 = new QuoteWidget(1, "Frase motivadora", 2.5, "Cada día es una nueva oportunidad.");
    private QuoteWidget widgetfrase2 = new QuoteWidget(2, "Frase de estudio", 3.0, "La práctica hace al maestro.");

    public List<Widget> getWidgets() {
        return widgetsExistentes;
    }

    public void actualizarTodos() {
        for (Widget widget : widgetsExistentes) {
            widget.renderizar();
        }
    }

    public String interactuarConWidget(int id) {
        for (Widget widget : widgetsExistentes) {
            if (widget.getId() == id) {
                if (widget instanceof Interactivo) {
                    ((Interactivo) widget).interactuar();
                    return "Interacción realizada: " + widget.getNombre();
                }
                return "Este widget solo se renderiza: " + widget.getNombre();
            }
        }
        return "No se encontró un widget con ID " + id;
    }
}

package model;
import TiposWidgets.*;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Dashboard {
    Widget[] widgetsExistentes = new Widget[10];

    //objetos iniciales
    public Dashboard(Widget[] widgetsExistentes) {
        this.widgetsExistentes = widgetsExistentes;
    }

    //Constructor
    public Dashboard() {
    widgetsExistentes[0] = widgetclima1;
    widgetsExistentes[1] = widgetclima2;
    widgetsExistentes[2] = widgettarea1;
    widgetsExistentes[3] = widgettarea2;
    widgetsExistentes[4] = widgetalerta1;
    widgetsExistentes[5] = widgetalerta2;
    widgetsExistentes[6] = widgetreloj1;
    widgetsExistentes[7] = widgetreloj2;
    widgetsExistentes[8] = widgetfrase1;
    widgetsExistentes[9] = widgetfrase2;
    }

    //Widgests del clima

    WeatherWidget widgetclima1 = new WeatherWidget(101, "Clima 1", 12.0, 35.0, "Mixco");
    WeatherWidget widgetclima2 = new WeatherWidget(102, "Clima 2", 15.0, 38.0, "Palencia");
    
    //Widgets de tareas

    Task tarea1 = new Task("Estudiar Java", false);
    Task tarea2 = new Task("Hacer ejercicio", false);
    Task tarea3 = new Task("Aprender UML", false);
    Task tarea4 = new Task("Leer código", false);
  
    Task[] pendientes1 = {tarea1, tarea2};
    Task[] pendientes2 = {tarea3, tarea4};
    
    TaskWidget widgettarea1 = new TaskWidget(201, "Pendientes 1", 30, pendientes1);
    TaskWidget widgettarea2 = new TaskWidget(202, "Pendientes 2", 35, pendientes2);

    //Widgets de Alerta
    AlertWidget widgetalerta1 = new AlertWidget(301, "Pasear al perro", 15.5, "Se detectó un acceso nuevo", 1, false);
    AlertWidget widgetalerta2 = new AlertWidget(302, "Comprar medicina", 8.0, "Tienes una reunión pendiente", 2, true);

    //Widgets de reloj
    ClockWidget widgetreloj1 = new ClockWidget(401, "Reloj principal", 5.0);
    ClockWidget widgetreloj2 = new ClockWidget(402, "Reloj secundario", 3.5);

    //Widgets de frase
    QuoteWidget widgetfrase1 = new QuoteWidget(1, "Frase motivadora", 2.5, "Cada día es una nueva oportunidad.");
    QuoteWidget widgetfrase2 = new QuoteWidget(2, "Frase de estudio", 3.0, "La práctica hace al maestro.");

    public void mostrarVentana() {
        JFrame ventana = new JFrame("Dashboard");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contenedor = new JPanel(
                new GridLayout(0, 2, 10, 10)
        );

        contenedor.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        for (Widget widget : widgetsExistentes) {
            contenedor.add(widget.obtenerVista());
        }

        ventana.add(new JScrollPane(contenedor));
        ventana.setSize(1100, 650);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public void interactuarConWidget(int id) {
        for (Widget widget : widgetsExistentes) {
            if (widget.getId() == id) {
                if (widget instanceof Interactivo) {
                    Interactivo interactivo = (Interactivo) widget;
                    interactivo.interactuar();
                } else {
                    System.out.println(
                            "Este widget solo se renderiza."
                    );
                }
                return;
            }
        }

        System.out.println("No se encontró el widget.");
    }
}


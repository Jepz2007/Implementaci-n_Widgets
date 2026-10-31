package model;
public class Task {

    private String tarea;
    private String color;
    private boolean completada;

    public Task(String tarea, boolean completada) {
        this.tarea = tarea;
        this.completada = completada;
        this.color = completada ? "azul" : "rojo";
    }

    public String getTarea() {
        return tarea;
    }

    public String getColor() {
        return color;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void completar() {
        completada = true;
        color = "azul";
    }
}
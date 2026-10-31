import javax.swing.SwingUtilities;

import model.Dashboard;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard dashboard = new Dashboard();
            dashboard.mostrarVentana();
        });
    }
}
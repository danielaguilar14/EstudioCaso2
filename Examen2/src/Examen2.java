
/**
 *
 * @author dagui
 */
// Jose Daniel Aguilar
// Caso PRactico #2

import javax.swing.JOptionPane;
//Aqui hice el setup de algunasvariables

class Amigo {

    String nombre;

    Amigo(String nombre) {
        this.nombre = nombre;
    }
}

class Movimiento {

    String descripcion;
    Amigo[] participantes;
    Amigo quienPago;
    double montoTotal;
    String moneda;

    Movimiento(String descripcion, Amigo[] participantes, Amigo quienPago, double montoTotal, String moneda) {
        this.descripcion = descripcion;
        this.participantes = participantes;
        this.quienPago = quienPago;
        this.montoTotal = montoTotal;
        this.moneda = moneda;
    }
}
// Aqui se define static de los amigos y movimienos
// Aqui se almacenan tambien los datos predefinidos para realizar el calculo

public class Examen2 {

    static Amigo[] amigos = {
        new Amigo("Joshua"),
        new Amigo("Greivin"),
        new Amigo("Guillermo"),
        new Amigo("Andres"),
        new Amigo("Tavo"),
        new Amigo("David")
    };
// Aqui se esta definidnendo los movimentos con el nombre y deuda detalles
    static Movimiento[] movimientos = {
        new Movimiento("Desayuno Coffee Prime", new Amigo[]{amigos[0], amigos[1], amigos[2], amigos[3], amigos[4], amigos[5]}, amigos[2], 120, "Dolares"),
        new Movimiento("Almuerzo Pig Factory", new Amigo[]{amigos[0], amigos[1], amigos[2], amigos[3], amigos[4]}, amigos[2], 200, "Dolares"),
        new Movimiento("Cena Fast Food", new Amigo[]{amigos[0], amigos[5]}, amigos[5], 50, "Dolares"),
        new Movimiento("Pizza Hut", new Amigo[]{amigos[2], amigos[3], amigos[1], amigos[4]}, amigos[4], 100, "Dolares"),
        new Movimiento("Quicksilver Store", new Amigo[]{amigos[2]}, amigos[1], 150, "Dolares"),
        new Movimiento("Apple Store", new Amigo[]{amigos[3]}, amigos[0], 200, "Dolares"),
        new Movimiento("Desayuno Chillis", new Amigo[]{amigos[0], amigos[1], amigos[2], amigos[3], amigos[4], amigos[5]}, amigos[1], 150, "Dolares"),
        new Movimiento("Almuerzo hooters", new Amigo[]{amigos[0], amigos[1], amigos[2], amigos[3], amigos[4], amigos[5]}, amigos[4], 180, "Dolares")
    };

    public static void main(String[] args) {
        int opcion;
        do {
            // Menu que intente para facilitar el programa y hacerlo sentir como un "app"
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Ver movimientos\n"
                    + "2. Agregar movimiento\n"
                    + "3. Aaalisis de deudas a un amigo especfico\n"
                    + "4. Salir\n"
                    + "Ingrese una opción:"));

            switch (opcion) {
                case 1:
                    mostrarMovimientos(); // Aqui se muestran los movimienots
                    break;
                case 2: // Aqui esta vacio porque al intentar agregar poner un movimiento aqui me tiraba error, pero esteticamente para el menu lo deje
                    break;
                case 3:
                    analizarDeudasAmigo(); // Aqui se realiza el analisis de las deudas para cualquier amigo
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        } while (opcion != 4);
    }

    static void mostrarMovimientos() {
// Metodo para mostrar todos los movimientos existentes
        StringBuilder sb = new StringBuilder("Movimientos:\n");
        for (Movimiento movimiento : movimientos) {
            sb.append(movimiento.descripcion).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    static void analizarDeudasAmigo() {
//metodo para analizar las deudas de un amigo
        String nombreAmigo = JOptionPane.showInputDialog("Ingrese el nombre del amigo para verificar sus deudas:");
        Amigo amigoBuscado = null;

// Aqui se busca el amigo pr nombre
        for (Amigo amigo : amigos) {
            if (amigo.nombre.equalsIgnoreCase(nombreAmigo)) {
                amigoBuscado = amigo;
                break;
            }
        }

        if (amigoBuscado != null) {
            StringBuilder sb = new StringBuilder("Deudas de " + amigoBuscado.nombre + ":\n");
            for (Movimiento movimiento : movimientos) {
                if (movimiento.quienPago == amigoBuscado) {
                    for (Amigo participante : movimiento.participantes) {
                        if (!participante.equals(amigoBuscado)) {
                            double deuda = (movimiento.montoTotal / movimiento.participantes.length);
                            sb.append(participante.nombre).append(" le debe a ").append(amigoBuscado.nombre)
                                    .append(" un total de ").append(deuda).append(" ").append(movimiento.moneda).append("\n");
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Amigo no encontrado");
        }
    }
}

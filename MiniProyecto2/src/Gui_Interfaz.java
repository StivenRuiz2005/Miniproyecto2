import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui_Interfaz extends JFrame{
    JButton agregar_bibliotecario,prestar_libros,devolucion_libros, informe_libros, estado_mora, salir, pagar_deuda, login;
    JLabel titulo;

    


    public Gui_Interfaz(){
        setTitle("Biblioteca");
        setSize(800, 650);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IniciarComponentes();
    }
    private void IniciarComponentes() {
        titulo = new JLabel("Biblioteca");
        titulo.setBounds(270, 50, 500, 50);
        titulo.setFont(new Font("TimesRoman", Font.BOLD, 50));
        add(titulo);

        login = new JButton("Cerrar Sesion");
        login.setBounds(290,560,200,30);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login_U frame = new Login_U();
                frame.setVisible(true);
                frame.setResizable(false);
                dispose();
            }
        });
        add(login);

        agregar_bibliotecario = new JButton("Agregar Bibliotecario");
        agregar_bibliotecario.setBounds(290, 180, 200, 30);
        agregar_bibliotecario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login_U frame1 = new Login_U();
                frame1.AgregarBibliotecario();
            }
        });
        add(agregar_bibliotecario);

        prestar_libros = new JButton("Prestar Libros");
        prestar_libros.setBounds(290, 230, 200, 30);
        prestar_libros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracion_libros ini_prestamo = new administracion_libros();
                ini_prestamo.Prestar();
                ini_prestamo.setVisible(true);
            }
        });
        add(prestar_libros);

        devolucion_libros = new JButton("Devolucion Libros");
        devolucion_libros.setBounds(290, 280, 200, 30);
        devolucion_libros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracion_libros ini = new administracion_libros();
                ini.Devolver();
                ini.setVisible(true);
            }
        });
        add(devolucion_libros);

        informe_libros = new JButton("Informe Libros");
        informe_libros.setBounds(290, 330, 200, 30);
        informe_libros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracion_libros ini2 = new administracion_libros();
                ini2.Informes();
                ini2.setVisible(true);
            }
        });
        add(informe_libros);

        estado_mora = new JButton("Estado Mora");
        estado_mora.setBounds(290, 380, 200, 30);
        estado_mora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracion_libros ini3 = new administracion_libros();
                ini3.EstadoClientes();
                ini3.setVisible(true);
            }
        });
        add(estado_mora);

        pagar_deuda = new JButton("Pagar Deuda");
        pagar_deuda.setBounds(290,430,200,30);
        pagar_deuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                administracion_libros ini4 = new administracion_libros();
                ini4.pagar();
                ini4.setVisible(true);
            }
        });
        add(pagar_deuda);




        salir = new JButton("Salir");
        salir.setBounds(340, 500, 100, 30);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Cerrar programa",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) { // creamos el bucle que se encarga de evaluar la desicion de
                    // usuario
                    System.exit(0);
                }
            }
        });
        add(salir);
    }
    public static void main(String[] args) {
        Login_U frame = new Login_U();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
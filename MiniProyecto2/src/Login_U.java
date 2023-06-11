import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class Login_U extends JFrame {
    private JFrame agregar = new JFrame();
    private JLabel username_label = new JLabel("Usuario: ");
    private JLabel password_label = new JLabel("Contraseña: ");
    private JLabel titulo,titulo1;
    private JTextField usuario,usuario1;
    private JPasswordField contrasena,contrasena1;
    private JButton ingresar, regresar,registrar1;
    static int j=0;

    static ArrayList<Bibliotecarios> bibliotecario = new ArrayList<>();


    public Login_U() {
        setTitle("Login");
        setSize(400, 320);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IniciarComponentes();
    }
    public void AgregarBibliotecario(){
        agregar.setTitle("Añadir usuarios");
        agregar.setSize(380, 330);
        agregar.setLayout(null);
        agregar.setVisible(true);

        titulo1 = new JLabel("Añadir Usuario");
        titulo1.setBounds(120, 10, 200, 30);
        titulo1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        agregar.add(titulo1);


        username_label.setBounds(50, 75, 100, 40);
        username_label.setFont(new Font("TimesRoman", Font.BOLD, 15));
        agregar.add(username_label);


        password_label.setBounds(50, 130, 100, 30);
        password_label.setFont(new Font("TimesRoman", Font.BOLD, 15));
        agregar.add(password_label);

        usuario1 = new JTextField();
        usuario1.setBounds(180, 80, 125, 30);
        usuario1.setFont(new Font("TimesRoman", Font.BOLD, 10));
        agregar.add(usuario1);

        contrasena1 = new JPasswordField();
        contrasena1.setBounds(180, 130, 125, 30);
        contrasena1.setFont(new Font("TimesRoman", Font.BOLD, 10));
        agregar.add(contrasena1);

        registrar1 = new JButton("Registrar");
        registrar1.setBounds(70, 200, 100, 50);
        agregar.add(registrar1);

        registrar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bibliotecario.add(new Bibliotecarios());
                char[] contrasena_conv = contrasena1.getPassword();
                String contrasena_s = String.valueOf(contrasena_conv);

                bibliotecario.get(j).setNombre(usuario1.getText());
                bibliotecario.get(j).setContrasena(contrasena_s);

                j++;

                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                agregar.dispose();
            }
        });

        regresar = new JButton("Regresar");
        regresar.setBounds(190, 200, 100, 50);
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(regresar);
    }
    private void IniciarComponentes() {
        titulo = new JLabel("Inicio de sesión");
        titulo.setBounds(120, 10, 200, 30);
        titulo.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(titulo);

        JLabel username_label = new JLabel("Usuario: ");
        username_label.setBounds(50, 75, 100, 40);
        username_label.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(username_label);

        JLabel password_label = new JLabel("Contraseña: ");
        password_label.setBounds(50, 130, 100, 30);
        password_label.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(password_label);

        usuario = new JTextField();
        usuario.setBounds(180, 80, 125, 30);
        usuario.setFont(new Font("TimesRoman", Font.BOLD, 10));
        add(usuario);

        contrasena = new JPasswordField();
        contrasena.setBounds(180, 130, 125, 30);
        contrasena.setFont(new Font("TimesRoman", Font.BOLD, 10));
        add(contrasena);

        ingresar = new JButton("Ingresar");
        ingresar.setBounds(70, 180, 100, 50);
        add(ingresar);
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    usuario.getText();
                    char[] contrasena_conv = contrasena.getPassword();
                    String contrasena_s = new String(contrasena_conv);
                    if (contrasena_s.equals("hola") && usuario.getText().equals("Carlos")) {
                        JOptionPane.showMessageDialog(null, "Acceso concedido, bienvenido admin");
                        Gui_Interfaz frame = new Gui_Interfaz();
                        frame.setVisible(true);
                        frame.agregar_bibliotecario.setEnabled(true);
                        dispose();

                    } else {
                        if (bibliotecario.size()>0){
                            for (int i = 0; i < bibliotecario.size(); i++) {
                                if (contrasena_s.equals((bibliotecario.get(i)).getContrasena()) && usuario.getText().equals(bibliotecario.get(i).getNombre())) {
                                    JOptionPane.showMessageDialog(null, "Ingreso Exitoso");
                                    Gui_Interfaz frame = new Gui_Interfaz();
                                    frame.setVisible(true);
                                    frame.agregar_bibliotecario.setEnabled(false);
                                    dispose();
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta");

                                }
                        }

                        }else{
                            JOptionPane.showMessageDialog(null,"No existe o no se ha creado ningun bibliotecario");
                        }

                    }
            }
        });
        regresar = new JButton("Regresar");
        regresar.setBounds(190,180,100,50);
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(regresar);
    }

}

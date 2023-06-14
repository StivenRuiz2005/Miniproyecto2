import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import java.util.ArrayList;

public class administracion_libros extends JFrame {
    JLabel titulo, pregunta, label_terror, label_novelas, label_ingenieria;
    JTextField nombre;
    static JComboBox<String> comboBoxterror = new JComboBox<>();
    static JComboBox<String> comboBoxnovelas = new JComboBox<>();
    static JComboBox<String> comboBoxingenieria = new JComboBox<>();
    private JTextField diaspre;
    private JButton regresar;
    private JComboBox<String> libros_prestados;
    JButton aceptar;
    static int n=0;

    static ArrayList<UsuariosDeuda> usuarios=new ArrayList<>();

    static ArrayList<Libros> terror= new ArrayList<>();
    static ArrayList<Libros> novelas = new ArrayList<>();
    static ArrayList<Libros> ingenieria = new ArrayList<>();

    static String[] libros_terror = {" ","Drácula - Bram Stocker", "It - Stephen King", "El Resplandor - Stephen King",
            "La Llamada De Cthulhu- H.P Lovecraft", "La Chica De Al Lado - Jack Ketchum"};

    static String[] libros_novelas = {" ","Cien años de soledad - Gabriel Garcia Marquez ", "Lolita - Vladimir Nabokov",
            "El Retrato de Dorian Gray - Oscar Wilde", "Madame Bovary - Gustave Flaubert", "El Principito - Antoine de Saint-Exupery"};


    static String[] libros_ingenieria = {" ", "La ingeniería es humana - Henry Petroski", "El teorema del loro- Denis Guedj",
            "Termodinámica - Michael A. Boles", "Ingeniería Mecánica Dinámica - Russel C. Hibbeler",
            "Cálculo: Trascendentes tempranas - James Stewart "};


    public administracion_libros(){
        setTitle("Préstamos");
        setSize(600,450);
        setLayout(null);
        setLocationRelativeTo(null);

    }
    public void Prestar(){
        titulo = new JLabel("Préstamos");
        titulo.setBounds(210, 20, 500, 50);
        titulo.setFont(new Font("TimesRoman", Font.BOLD, 30));
        add(titulo);

        pregunta = new JLabel("Escribe el nombre y selecciona los libros que desea solicitar: ");
        pregunta.setBounds(55, 90, 500, 40);
        pregunta.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(pregunta);

        nombre = new JTextField();
        nombre.setBounds(150,130,300,25);
        nombre.setFont(new Font("TimesRoman", Font.ITALIC,15));
        add(nombre);

        label_terror = new JLabel("Terror: ");
        label_terror.setBounds(80,180,500,20);
        label_terror.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(label_terror);

        label_novelas = new JLabel("Novelas: ");
        label_novelas.setBounds(80,220,500,20);
        label_novelas.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(label_novelas);

        label_ingenieria = new JLabel("Ingenieria: ");
        label_ingenieria.setBounds(65,260,500,20);
        label_ingenieria.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(label_ingenieria);

        libros();

        comboBoxterror.setBounds(150,180,350,20);
        add(comboBoxterror);
        comboBoxterror.setVisible(true);


        comboBoxnovelas.setBounds(150,220,350,20);
        add(comboBoxnovelas);
        comboBoxnovelas.setVisible(true);

        comboBoxingenieria.setBounds(150,260,350,20);
        add(comboBoxingenieria);
        comboBoxingenieria.setVisible(true);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(170, 320, 100, 50);
        aceptar.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Selección Aceptada");
                for(int i = 1; i < 6; i++){
                    if (Objects.equals(comboBoxterror.getSelectedItem(), terror.get(i).getNombre())) {
                        terror.get(i).setNom_usuario(nombre.getText());
                        terror.get(i).setEstado(false);

                    }
                    if (Objects.equals(comboBoxnovelas.getSelectedItem(), novelas.get(i).getNombre())) {
                        novelas.get(i).setNom_usuario(nombre.getText());
                        novelas.get(i).setEstado(false);
                    }
                    if (Objects.equals(comboBoxingenieria.getSelectedItem(), ingenieria.get(i).getNombre())) {
                        ingenieria.get(i).setNom_usuario(nombre.getText());
                        ingenieria.get(i).setEstado(false);
                    }


                }
                dispose();
            }
        });
        regresar = new JButton("Regresar");
        regresar.setBounds(280,320,110,50);
        regresar.setFont(new Font("TimesRoman", Font.BOLD, 15));
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(regresar);
    }
    public void Devolver(){
        setTitle("Devoluciones");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setLayout(null);

        libros_prestados =new JComboBox<String>();
        libros_prestados.setBounds(100, 120, 200, 20);
        add(libros_prestados);

        libros_prestados.removeAllItems();
        try {
            for (int i = 0; i < 6; i++) {
                if (!terror.get(i).isEstado()) {
                    libros_prestados.addItem(terror.get(i).getNombre());
                }
                if (!novelas.get(i).isEstado()) {
                    libros_prestados.addItem(novelas.get(i).getNombre());
                }
                if (!ingenieria.get(i).isEstado()) {
                    libros_prestados.addItem(ingenieria.get(i).getNombre());
                }
            }
        }catch (NullPointerException npe){JOptionPane.showMessageDialog(null,"No hay libros prestados");}

        JLabel titulo1 = new JLabel("Devoluciones");
        titulo1.setBounds(120, 10, 200, 30);
        titulo1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(titulo1);

        JLabel pregunta1 = new JLabel("Seleccione el libro que desea entregar: ");
        pregunta1.setBounds(50, 40, 300, 30);
        pregunta1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(pregunta1);

        JLabel password_label = new JLabel("Nombre del libro: ");
        password_label.setBounds(128, 80, 250, 30);
        password_label.setFont(new Font("TimesRoman", Font.BOLD, 15));
        add(password_label);

        JLabel dias = new JLabel("Dias de prestamo: ");
        dias.setBounds(128,150,250,30);
        dias.setFont(new Font("TimesRoman", Font.BOLD,15));
        add(dias);

        diaspre = new JTextField();
        diaspre.setBounds(150,190,100,30);
        diaspre.setFont(new Font("TimesRoman", Font.BOLD,15));
        add(diaspre);

        JButton devolucion = new JButton("Devolucion");
        devolucion.setBounds(80,230,100,50);
        devolucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean n=true;
                String nameusers="";
                
                try{
                    int k = Integer.parseInt(diaspre.getText());
                    for(int i = 0; i <6 ;i++){

                    if(libros_prestados.getSelectedItem() == terror.get(i).getNombre()){
                        nameusers= terror.get(i).getNom_usuario();
                        terror.get(i).setEstado(true);
                    }
                    else if(libros_prestados.getSelectedItem() == novelas.get(i).getNombre()){
                        nameusers= novelas.get(i).getNom_usuario();
                        novelas.get(i).setEstado(true);
                    }
                    else if(libros_prestados.getSelectedItem() == ingenieria.get(i).getNombre()){
                        nameusers= ingenieria.get(i).getNom_usuario();
                        ingenieria.get(i).setEstado(true);
                    }
                }
                    
                    if(k-7>0){
                        if(usuarios.size()>0){
                            for(int i=0;i<usuarios.size();i++){
                                if(nameusers.equals(usuarios.get(i).getNombre())){
                                    usuarios.get(i).setDeuda((k-7)*1000);

                                    n=false;
                                    break;
                                }
                            }
                            if (n){
                                UsuariosDeuda deudor = new UsuariosDeuda();
                                deudor.setNombre(nameusers);
                                deudor.setDeuda((k-7)*1000);
                                usuarios.add(deudor);


                            }
                        }
                        else{
                            UsuariosDeuda deudor = new UsuariosDeuda();

                            deudor.setNombre(nameusers);
                            deudor.setDeuda((k-7)*1000);
                            usuarios.add(deudor);
                        }


                    }
                JOptionPane.showMessageDialog(null, "Devolución Exitosa");
                dispose();
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "¡ERROR! Ingrese un dato valido");
                    dispose();
                }

            }

        });
        add(devolucion);

        regresar = new JButton("Regresar");
        regresar.setBounds(220,230,100,50);
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(regresar);
    }
    public void Informes(){

        setTitle("Informe Libros");
        setSize(500, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titulo3 = new JLabel("Informes");
        titulo3.setBounds(160, 20, 200, 30);
        titulo3.setFont(new Font("TimesRoman", Font.BOLD, 40));
        add(titulo3);

        //////

        JTextArea informe1 = new JTextArea();
        informe1.setEditable(false);
        informe1.setLineWrap(true);
        add(informe1);

        JScrollPane barra1 = new JScrollPane(informe1);
        barra1.setBounds(20, 70, 300, 80);
        add(barra1);

        JButton generar_informe1 = new JButton("Terror");
        generar_informe1.setBounds(350, 90, 100, 30);
        generar_informe1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libros();
                String est="";
                for (int i = 1;i<6;i++) {
                    if (terror.get(i).isEstado()){
                        est = "Disponible";
                        terror.get(i).setNom_usuario("");
                    }
                    else{
                        est= "Prestado";
                    }
                    informe1.setText(informe1.getText() + terror.get(i).getNombre() + " : \n" + est + " : " + terror.get(i).getNom_usuario() + "\n \n");
                }
            }
        });
        add(generar_informe1);


        //////
        JTextArea informe2 = new JTextArea();
        informe2.setEditable(false);
        informe2.setLineWrap(true);
        add(informe2);

        JScrollPane barra2 = new JScrollPane(informe2);
        barra2.setBounds(20,160,300,80);
        add(barra2);

        JButton generar_informe2 = new JButton("Novelas");
        generar_informe2.setBounds(350, 185, 100, 30);
        generar_informe2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String est="";
                for (int i = 1;i<6;i++) {
                    if (novelas.get(i).isEstado()){
                        est = "Disponible";
                        novelas.get(i).setNom_usuario("");
                    }
                    else{
                        est= "Prestado";
                    }
                    informe2.setText(informe2.getText() + novelas.get(i).getNombre() + " : \n" + est + " : " + novelas.get(i).getNom_usuario() + "\n \n");
                }
            }
        });
        add(generar_informe2);


        ////////////

        JTextArea informe3 = new JTextArea();
        informe3.setEditable(false);
        informe3.setLineWrap(true);
        add(informe3);

        JScrollPane barra3 = new JScrollPane(informe3);
        barra3.setBounds(20,250,300,80);
        add(barra3);

        JButton generar_informe3 = new JButton("Ingenieria");
        generar_informe3.setBounds(350, 280, 100, 30);
        generar_informe3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String est="";
                for (int i = 1;i<6;i++) {
                    if (ingenieria.get(i).isEstado()){
                        est = "Disponible";
                        ingenieria.get(i).setNom_usuario("");
                    }
                    else{
                        est= "Prestado";
                    }
                    informe3.setText(informe3.getText() + ingenieria.get(i).getNombre() + " : \n" + est + " : " + ingenieria.get(i).getNom_usuario() + "\n \n");
                }

            }
        });
        add(generar_informe3);



        //////////

        regresar = new JButton("Regresar");
        regresar.setBounds(185,350,100,50);
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(regresar);
    }
    public void EstadoClientes(){
        setTitle("Estado Mora");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titulo4 = new JLabel("Personas en mora");
        titulo4.setBounds(110, 10, 200, 30);
        titulo4.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(titulo4);

        JTextArea informe = new JTextArea();
        informe.setBounds(20,40, 350,170);
        informe.setEditable(false);
        informe.setLineWrap(true);
        add(informe);

        JButton generar_informe = new JButton("Generar informe");
        generar_informe.setBounds(40,230,160,50);
        generar_informe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0;i<usuarios.size();i++){
                    informe.setText(informe.getText() + usuarios.get(i).getNombre() + " : " + usuarios.get(i).getDeuda() + "\n" );
                }
            }
        });
        add(generar_informe);

        regresar = new JButton("Regresar");
        regresar.setBounds(240,230,100,50);
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                dispose();
            }
        });
        add(regresar);
    }
    public void pagar() {
        setTitle("Pagar Deuda");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel pagar1 = new JLabel("Pago de Deudas");
        pagar1.setBounds(110, 40, 200, 30);
        pagar1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(pagar1);

        JLabel pagar12 = new JLabel("Ingresa el nombre");
        pagar12.setBounds(120, 100, 200, 30);
        pagar12.setFont(new Font("TimesRoman",Font.BOLD, 15));
        add(pagar12);

        JTextField pagar2 = new JTextField();
        pagar2.setBounds(20,150, 350,50);
        pagar2.setEditable(true);
        add(pagar2);

        JButton pagar3 = new JButton("Pagar");
        pagar3.setBounds(40,250,160,50);
        pagar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean n=true;
                for (int i = 0;i<usuarios.size();i++){
                    if(usuarios.get(i).getNombre().equals(pagar2.getText())){
                        usuarios.remove(i);
                        JOptionPane.showMessageDialog(null, "Pago realizado correctamente");
                        n=false;
                    }

                }
                if(n){
                    JOptionPane.showMessageDialog(null, "No se encontro registro de pago pendiente");
                }
                dispose();
            }
        });
        add(pagar3);

        regresar = new JButton("Regresar");
        regresar.setBounds(240,250,100,50);
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                dispose();
            }
        });
        add(regresar);

    }
    public void libros(){
        if (n==0){
            for (int i = 0; i <6;i++){
                novelas.add(new Libros()); 
                terror.add(new Libros());
                ingenieria.add(new Libros());

                novelas.get(i).setNombre(libros_novelas[i]);
                terror.get(i).setNombre(libros_terror[i]);
                ingenieria.get(i).setNombre(libros_ingenieria[i]);

                comboBoxterror.addItem(terror.get(i).getNombre());
                comboBoxnovelas.addItem(novelas.get(i).getNombre());
                comboBoxingenieria.addItem(ingenieria.get(i).getNombre());
            }
            n++;
        }
        else{
            comboBoxterror.removeAllItems();
            comboBoxnovelas.removeAllItems();
            comboBoxingenieria.removeAllItems();
            for (int i=0; i<6; i++){
                if (terror.get(i).isEstado()){
                    comboBoxterror.addItem(terror.get(i).getNombre());
                }
                if (novelas.get(i).isEstado()){
                    comboBoxnovelas.addItem(novelas.get(i).getNombre());
                }
                if (ingenieria.get(i).isEstado()){
                    comboBoxingenieria.addItem(ingenieria.get(i).getNombre());
                }
            }

        }
    }
}

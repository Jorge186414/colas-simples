package edu.tesji.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.tesji.model.ColaModel;
import edu.tesji.model.Control;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ManejoDeDatosView extends JFrame {

    //Metodo para cerrar el programa con un boton o desde la X
    public void salir() {
        int respuesta;
        //La ventana de JOptionPane nos mostrara 2 botones Yes y No para seleccionarlos
        respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Deseas salir?", "salir", JOptionPane.YES_NO_OPTION);
        //Si seleccionamos el boton de Yes nuestra interfaz se va a cerrar
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private JPanel contentPane;
    private JTextField txtNumero;
    private JTextArea txtCola;
    private JTextArea txtNumeroExtraido;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManejoDeDatosView frame = new ManejoDeDatosView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManejoDeDatosView() {
        setTitle("Colas Simples");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 451, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(175, 251, 255));
        panel.setBounds(0, 0, 443, 249);
        contentPane.add(panel);
        panel.setLayout(null);

        // Label para el titulo de la interfaz
        JLabel lblColasSimples = new JLabel("Colas Simples");
        lblColasSimples.setHorizontalAlignment(SwingConstants.CENTER);
        lblColasSimples.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblColasSimples.setBounds(118, 0, 207, 54);
        panel.add(lblColasSimples);

        // Creacion de objetos para conexion entre clases
        Control controlDatos = new Control();
        ColaModel datosCola = new ColaModel();

        // Boton para agregar datos a la cola
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //Con las siguientes 2 lineas de codigo agregamos un valor a la cola
                    controlDatos.nodoInformacion = Integer.parseInt(txtNumero.getText().trim());
                    datosCola.Insertar(controlDatos.nodoInformacion);
                    //Con la siguiente linea mostramos el contenido de la cola en txtCola
                    txtCola.setText(datosCola.MostrarContenido());
                } catch (Exception evt) {
                    //En caso de que el try detecte un error, mediante un JOptionPane se mostrara un mensaje para verificar los datos
                    JOptionPane.showMessageDialog(null, "No se ingreso un valor valido");
                }
            }
        });
        btnAgregar.setBackground(new Color(154, 143, 200));
        btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnAgregar.setBounds(218, 70, 90, 25);
        panel.add(btnAgregar);

        // Boton para extraer datos
        JButton btnExtraer = new JButton("Extraer");
        btnExtraer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!datosCola.ColaVacia()) {
                    txtNumeroExtraido.setText(String.valueOf(datosCola.Extraer()));
                    txtCola.setText(datosCola.MostrarContenido());
                } else {
                    txtCola.setText("La cola esta vacia");
                }
            }
        });
        btnExtraer.setBackground(new Color(154, 143, 200));
        btnExtraer.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnExtraer.setBounds(343, 70, 90, 25);
        panel.add(btnExtraer);

        // Boton para salir del programa
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Al presionar el boton Salir de la interfaz o la x, se mandara a llamar al metodo salir el cual se encargara
                //cerrar la interfazmsi se preciona el boton de Yes
                salir();
            }
        });
        btnSalir.setBackground(new Color(154, 143, 200));
        btnSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnSalir.setBounds(343, 106, 90, 25);
        panel.add(btnSalir);

        // TextField para el numero a agregar
        txtCola = new JTextArea();
        txtCola.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtCola.setEditable(false);
        txtCola.setBounds(10, 203, 423, 35);
        panel.add(txtCola);

        // Label para datos
        JLabel lblDatos = new JLabel("Datos en Cola");
        lblDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblDatos.setBounds(10, 179, 116, 20);
        panel.add(lblDatos);

        // Label para el numero
        JLabel lblNumero = new JLabel("Numero");
        lblNumero.setHorizontalAlignment(SwingConstants.LEFT);
        lblNumero.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblNumero.setBounds(10, 71, 90, 22);
        panel.add(lblNumero);

        // TextField para el numero
        txtNumero = new JTextField();
        txtNumero.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        txtNumero.setBounds(81, 71, 86, 25);
        panel.add(txtNumero);
        txtNumero.setColumns(10);

        // Label para el dato extraido
        JLabel lblDatoExtraido = new JLabel("Dato Extraido");
        lblDatoExtraido.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblDatoExtraido.setBounds(10, 133, 116, 20);
        panel.add(lblDatoExtraido);

        // TextArea para mostrar el numero extraido de la fila
        txtNumeroExtraido = new JTextArea();
        txtNumeroExtraido.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtNumeroExtraido.setEditable(false);
        txtNumeroExtraido.setBounds(118, 129, 49, 25);
        panel.add(txtNumeroExtraido);

        //Boton nuevo
        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*Si presionamos el boton nuevo se borrara el valor que hay en txtNuevo mandandole un valor null
            	 * y al mismo tiempo el cursor se colocara en este mismo TextField para hacer mas rapido el ingreso de datos
                 */
                txtNumero.setText(null);
                (txtNumero).requestFocusInWindow();
            }
        });
        btnNuevo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnNuevo.setBackground(new Color(154, 143, 200));
        btnNuevo.setBounds(218, 106, 90, 25);
        panel.add(btnNuevo);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                salir();
            }
        });
    }
}

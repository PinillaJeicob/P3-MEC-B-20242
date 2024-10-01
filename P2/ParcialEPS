package com.mycompany.eps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class EPS extends javax.swing.JFrame {
    private JLabel labelTiempo;  // Etiqueta para el cronómetro
    private Timer timer;  // Timer para actualizar el tiempo
    private LocalTime tiempoActual;
    private Queue<String> colaResultados;  // Cola para almacenar resultados
    private DefaultListModel<String> modeloEnProceso; // Modelo para mostrar resultados en proceso
    private JList<String> listaEnProceso; // JList para mostrar los elementos en proceso
    private JSlider sliderVelocidad; // Slider para ajustar la velocidad del cronómetro
    private HashSet<String> cedulasRegistradas; // Set para almacenar cédulas únicas

    // Constructor
    public EPS() {
        initComponents();
        iniciarCronometro();  // Llamamos al cronómetro
        colaResultados = new LinkedList<>(); // Inicializamos la cola
        modeloEnProceso = new DefaultListModel<>(); // Inicializamos el modelo para la lista
        listaEnProceso = new JList<>(modeloEnProceso); // Crear la lista con el modelo
        cedulasRegistradas = new HashSet<>(); // Inicializamos el conjunto para cédulas
    }

    // Método para inicializar los componentes
    private void initComponents() {
        
        // Crear los elementos
        JLabel labelCedula = new JLabel("Ingrese Cédula:");
        JTextField fieldCedula = new JTextField(15);

        JLabel labelCategoria = new JLabel("Seleccione Categoría:");
        JComboBox<String> comboCategoria = new JComboBox<>(new String[]{"Menor de 10 años", "Joven", "Adulto Mayor", "Persona con discapacidad"});

        JLabel labelServicio = new JLabel("Seleccione Servicio:");
        JComboBox<String> comboServicio = new JComboBox<>(new String[]{"Consulta médica General", "Consulta médica Especializada", "Prueba de laboratorio", "Imágenes (diagnósticos)"});

        JButton btnProcesar = new JButton("Procesar Atención");
        JButton btnIniciarProceso = new JButton("Iniciar Procesamiento");
        
        JTextArea areaResultado = new JTextArea(25, 40);
        areaResultado.setEditable(false);
        
        labelTiempo = new JLabel("Hora Actual: 00:00:00");  // Etiqueta para mostrar el cronómetro
        
        // Slider para ajustar la velocidad
        sliderVelocidad = new JSlider(1, 10); // Rango de 1 a 10 minutos
        sliderVelocidad.setMajorTickSpacing(1);
        sliderVelocidad.setPaintTicks(true);
        sliderVelocidad.setPaintLabels(true);
        sliderVelocidad.setValue(5); // Valor predeterminado (5 minutos)
        
        JLabel labelSlider = new JLabel("Velocidad de Procesamiento (minutos):");

        // Configurar el layout
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulación Atención EPS");

        // Layout usando GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // Configuramos el layout en forma horizontal y vertical
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelCedula)
                    .addComponent(labelCategoria)
                    .addComponent(labelServicio)
                    .addComponent(btnProcesar)
                    .addComponent(btnIniciarProceso)
                    .addComponent(labelSlider) // Etiqueta del slider
                    .addComponent(labelTiempo) 
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(fieldCedula)
                    .addComponent(comboCategoria)
                    .addComponent(comboServicio)
                    .addComponent(areaResultado)
                    .addComponent(sliderVelocidad) // Añadimos el slider
                    .addComponent(new JScrollPane(listaEnProceso)) 
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedula)
                    .addComponent(fieldCedula)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategoria)
                    .addComponent(comboCategoria)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelServicio)
                    .addComponent(comboServicio)
                )
                .addComponent(labelTiempo)  // Añadimos el cronómetro
                .addComponent(btnProcesar)
                .addComponent(btnIniciarProceso)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSlider)
                    .addComponent(sliderVelocidad) // Añadimos el slider
                )
                .addComponent(new JScrollPane(listaEnProceso)) // Añadimos la JList
                .addComponent(areaResultado)
        );

        // Acción del botón "Procesar Atención"
        btnProcesar.addActionListener(e -> {
            String cedula = fieldCedula.getText();

            // Verificar si la cédula ya ha sido registrada
            if (cedulasRegistradas.contains(cedula)) {
                JOptionPane.showMessageDialog(this, "La cédula ya está registrada. Por favor ingrese una cédula única.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // No continuar si la cédula ya existe
            }

            String categoria = comboCategoria.getSelectedItem().toString();
            String servicio = comboServicio.getSelectedItem().toString();
            String tiempoConsulta = tiempoActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            // Agregar el resultado a la cola
            String resultado = "Cédula: " + cedula + ", Categoría: " + categoria + ", Servicio: " + servicio + ", Hora: " + tiempoConsulta;
            colaResultados.offer(resultado); // Agregar a la cola
            cedulasRegistradas.add(cedula); // Registrar la cédula

            // Mostrar en el área de resultado
            areaResultado.setText("Resultado agregado a la cola:\n" + resultado);
        });

        // Acción del botón "Iniciar Procesamiento"
        btnIniciarProceso.addActionListener(e -> {
            if (colaResultados.size() < 10) {
                JOptionPane.showMessageDialog(this, "Debe haber al menos 10 personas en la cola para iniciar el procesamiento.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return; // No iniciar si no hay suficientes personas en la cola
            }

            // Procesar los elementos en la cola según la velocidad del slider
            int velocidad = sliderVelocidad.getValue() * 60000; // Convertir a milisegundos (1 minuto = 60000 ms)
            new Timer(velocidad, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!colaResultados.isEmpty()) {
                        String resultadoEnProceso = colaResultados.poll(); // Extraer de la cola
                        modeloEnProceso.addElement(resultadoEnProceso); // Agregar a la lista en proceso
                    } else {
                        ((Timer) e.getSource()).stop(); // Detener el Timer si la cola está vacía
                    }
                }
            }).start(); // Iniciar el timer de procesamiento
        });

        // Iniciar el timer de la hora
        iniciarCronometro();

        // Ajustar el tamaño y mostrar la ventana
        pack();
        setVisible(true);
    }

    // Método para iniciar el cronómetro
    private void iniciarCronometro() {
        timer = new Timer(60000, new ActionListener() { // Cambiar a 60000 ms (1 minuto en el programa)
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualizamos el tiempo actual cada minuto en el programa
                tiempoActual = LocalTime.now();
                labelTiempo.setText("Hora Actual: " + tiempoActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        });
        timer.start();  // Iniciar el Timer
    }

    // Método principal para correr la aplicación
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EPS().setVisible(true));
    }
}

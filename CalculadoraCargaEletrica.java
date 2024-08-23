import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class CalculadoraCargaEletrica extends JFrame {

    private JTextField campoPotencia;
    private JTextField campoTensao;
    private JTextField campoTempo;
    private JLabel resultado;

    public CalculadoraCargaEletrica() {
        setTitle("Calculadora de Carga Elétrica");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel labelPotencia = new JLabel("Potencia em watts:");
        campoPotencia = new JTextField(10);

        JLabel labelTensao = new JLabel("Tensao em volts:");
        campoTensao = new JTextField(10);

        JLabel labelTempo = new JLabel("Tempo em horas:");
        campoTempo = new JTextField(10);

        JButton botaoCalcular = new JButton("Calcular");
        resultado = new JLabel("");

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCarga();
            }
        });

        JPanel painelPotencia = new JPanel();
        painelPotencia.add(labelPotencia);
        painelPotencia.add(campoPotencia);

        JPanel painelTensao = new JPanel();
        painelTensao.add(labelTensao);
        painelTensao.add(campoTensao);

        JPanel painelTempo = new JPanel();
        painelTempo.add(labelTempo);
        painelTempo.add(campoTempo);

        JPanel painelResultado = new JPanel();
        painelResultado.add(resultado);

        add(painelPotencia);
        add(painelTensao);
        add(painelTempo);
        add(botaoCalcular);
        add(painelResultado);
    }

    private void calcularCarga() {
        try {
            double potencia = Double.parseDouble(campoPotencia.getText());
            double tensao = Double.parseDouble(campoTensao.getText());
            double tempoHoras = Double.parseDouble(campoTempo.getText());

            double corrente = potencia / tensao;
            double tempoSegundos = tempoHoras * 3600;
            double carga = corrente * tempoSegundos;

            resultado.setText("Carga: " + carga + " C");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraCargaEletrica().setVisible(true);
            }
        });
    }
}
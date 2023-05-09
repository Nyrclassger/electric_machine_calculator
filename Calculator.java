import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class Calculator {
    public static void main(String[] args) {

        // Creating the interface

        JFrame frame = new JFrame("Electrical machine calculator / by Nosikov Rostyslav");

        JPanel panel = new JPanel();

        JLabel title_v = new JLabel("Voltage (V):");
        JLabel title_r = new JLabel("Resistance (R):");
        JLabel title_p = new JLabel("Output power (P_out):");


        JLabel title_i = new JLabel("Electricity (I):");
        JLabel title_p1 = new JLabel("Power (P):");
        JLabel title_n = new JLabel("Efficiency (η):");

        JLabel description = new JLabel("Calculation with Kirchhoff's rule");

        JButton button_c = new JButton("Calculate");

        JTextArea area = new JTextArea("");
        JTextArea area_1 = new JTextArea("");
        JTextArea area_2 = new JTextArea("");

        Border border = BorderFactory.createLineBorder(Color.black);

        area.setBorder(border);
        area_1.setBorder(border);
        area_2.setBorder(border);

        JTextArea electricity = new JTextArea("");
        JTextArea power = new JTextArea("");
        JTextArea efficiency = new JTextArea("");


        button_c.setBounds(12, 200, 200, 50);
        title_v.setBounds(12, -12, 200, 50);
        title_r.setBounds(12, 50, 200, 50);
        title_p.setBounds(12, 108, 200, 50);

        title_i.setBounds(220, -12, 200, 50);
        title_p1.setBounds(220, 50, 200, 50);
        title_n.setBounds(220, 108, 200, 50);

        description.setBounds(220, 200, 280, 50);

        area.setBounds(12, 25, 200, 38);
        area_1.setBounds(12, 85, 200, 38);
        area_2.setBounds(12, 145, 200, 38);
        electricity.setBounds(220, 25, 285, 38);
        power.setBounds(220, 85, 285, 38);
        efficiency.setBounds(220, 145, 285, 38);

        area.setForeground(Color.black);
        area_1.setForeground(Color.black);
        area_2.setForeground(Color.black);
        electricity.setForeground(Color.green);
        power.setForeground(Color.green);
        efficiency.setForeground(Color.green);
        title_v.setForeground(Color.black);
        title_r.setForeground(Color.black);
        title_p.setForeground(Color.black);

        title_i.setForeground(Color.black);
        title_p1.setForeground(Color.black);
        title_n.setForeground(Color.black);

        description.setForeground(Color.black);


        Font font_t = new Font("Arial", Font.ITALIC, 14);
        Font font = new Font("Arial", Font.BOLD, 28);
        Font font_description = new Font("Tahoma", Font.BOLD, 14);

        area.setFont(font);

        title_v.setFont(font_t);
        title_r.setFont(font_t);
        title_p.setFont(font_t);

        title_i.setFont(font_t);
        title_p1.setFont(font_t);
        title_n.setFont(font_t);

        description.setFont(font_description);

        area.setBackground(Color.white);

        area_1.setFont(font);
        area_1.setBackground(Color.white);

        area_2.setFont(font);
        area_2.setBackground(Color.white);

        electricity.setFont(font);
        electricity.setBackground(Color.black);

        power.setFont(font);
        power.setBackground(Color.black);

        efficiency.setFont(font);
        efficiency.setBackground(Color.black);

        panel.setLayout(null);

        panel.add(title_v);
        panel.add(title_r);
        panel.add(title_p);

        panel.add(title_i);
        panel.add(title_p1);
        panel.add(title_n);

        panel.add(area);
        panel.add(area_1);
        panel.add(area_2);

        panel.add(electricity);
        panel.add(power);
        panel.add(efficiency);


        panel.add(button_c);

        panel.add(description);

        frame.add(panel);
        frame.setSize(533, 300);
        frame.setVisible(true);
        frame.setResizable(false);

        // Calculation with Kirchhoff's rule

        button_c.addActionListener(e -> {

        try {
            double c_voltage = Double.parseDouble(area.getText());
            double c_resistance = Double.parseDouble(area_1.getText());
            double c_power_out = Double.parseDouble(area_2.getText());

            double c_electricity = c_voltage / c_resistance; // Calculation of electric current I = V / R
            electricity.setText(Double.toString(c_electricity));

            double c_power = Math.pow(c_electricity, 2) / c_resistance; // Calculation of electric power P = V * I
            power.setText(Double.toString(c_power));


            double c_efficiency = (c_power_out / c_power) * 100.0; // Calculation of electrical machine efficiency η = (P_out / P_in) * 100
            long c_efficiency_rounded = (long) (c_efficiency * 100);
            double c_efficiency_final = c_efficiency_rounded / 100.0;
            if (c_efficiency_final > 100.0) {
                c_efficiency_final = 100.0;
            }
            efficiency.setText(String.format("%.2f%%", c_efficiency_final));

        // Error message!

        } catch (NumberFormatException ex) {
            electricity.setText("Error!");
            power.setText("Error!");
            efficiency.setText("Error!");
        }
        });
    }
}

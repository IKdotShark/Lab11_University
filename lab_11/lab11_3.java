package lab_11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class lab11_3 extends JFrame implements ActionListener {
    private JTextField xMinField, xMaxField;
    private JButton plotButton;
    private JPanel graphPanel;
    public lab11_3() {
        super("График функции");
        xMinField = new JTextField("-10", 5);
        xMaxField = new JTextField("10", 5);
        plotButton = new JButton("Построить график");
        plotButton.addActionListener(this);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("xMin:"));
        inputPanel.add(xMinField);
        inputPanel.add(new JLabel("xMax:"));
        inputPanel.add(xMaxField);
        inputPanel.add(plotButton);
        graphPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(g);
            }
        };
        graphPanel.setPreferredSize(new Dimension(600, 400));
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(graphPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plotButton) {
            graphPanel.repaint();
        }
    }
    private void drawGraph(Graphics g) {
        double xMin = Double.parseDouble(xMinField.getText());
        double xMax = Double.parseDouble(xMaxField.getText());
        int width = graphPanel.getWidth();
        int height = graphPanel.getHeight();
        g.setColor(Color.BLACK);
        g.drawLine(0, height / 2, width, height / 2);
        g.drawLine(width / 2, 0, width / 2, height);
        g.setColor(Color.BLUE);
        double xStep = (xMax - xMin) / width;
        double x = xMin;
        double y = f(x);
        int lastX = 0, lastY = height / 2;
        for (int i = 1; i < width; i++) {
            x += xStep;
            y = f(x);
            int xPos = i;
            int yPos = (int) (height / 2 - y * height / (xMax - xMin));
            g.drawLine(lastX, lastY, xPos, yPos);
            lastX = xPos;
            lastY = yPos;
        }
    }
    private double f(double x) {
        return Math.sin(x);
    }

    public static void main(String[] args) {
        new lab11_3();
    }
}

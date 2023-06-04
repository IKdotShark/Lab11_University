package lab_11;
import javax.swing.*;
import java.awt.*;

public class test extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Настройка параметров графика
        int xAxisStart = 0;
        int xAxisEnd = WIDTH;
        int yAxisStart = HEIGHT / 2;
        int yAxisEnd = HEIGHT / 2;

        // Отрисовка осей
        g.setColor(Color.BLACK);
        g.drawLine(xAxisStart, yAxisStart, xAxisEnd, yAxisEnd);
        g.drawLine(xAxisStart, 0, xAxisStart, HEIGHT);

        // Отрисовка графика 1
        g.setColor(Color.RED);
        drawLine(g, -8, -4, -6, -6);
        drawLine(g, -8, -6, -2, 2, 10);
        drawLine(g, -6, -8, -8, -1, -8);
        drawLine(g, -8, -6, -6, 3, 24);
        drawLine(g, -6, -5, -6, -6, -30);
        drawLine(g, -5, -2, -5, 2, 10, 3);
        drawLine(g, -4, -2, -4, 4, 10);

        // Отрисовка графика 2
        g.setColor(Color.BLUE);
        drawLine(g, -8, -6, -8, -6);
        drawLine(g, -6, -8, -6, -8);
        drawLine(g, -6, -8, -8, 2, 10);
    }

    private void drawLine(Graphics g, int xStart, int xEnd, int yStart, int yEnd) {
        int x1 = mapX(xStart);
        int x2 = mapX(xEnd);
        int y1 = mapY(yStart);
        int y2 = mapY(yEnd);
        g.drawLine(x1, y1, x2, y2);
    }

    private void drawLine(Graphics g, int xStart, int xEnd, int yStart, int yEnd, int yOffset) {
        int x1 = mapX(xStart);
        int x2 = mapX(xEnd);
        int y1 = mapY(yStart + yOffset);
        int y2 = mapY(yEnd + yOffset);
        g.drawLine(x1, y1, x2, y2);
    }

    private void drawLine(Graphics g, int xStart, int xEnd, int yStart, int yEnd, int xOffset, int yOffset) {
        int x1 = mapX(xStart + xOffset);
        int x2 = mapX(xEnd + xOffset);
        int y1 = mapY(yStart + yOffset);
        int y2 = mapY(yEnd + yOffset);
        g.drawLine(x1, y1, x2, y2);
    }

    private int mapX(int x) {
        return WIDTH / 2 + x * 20;
    }

    private int mapY(int y) {
        return HEIGHT / 2 - y * 20;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("GraphPlotter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.getContentPane().add(new test());
            frame.setVisible(true);
        });
    }
}

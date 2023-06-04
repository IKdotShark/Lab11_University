package lab_11;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab11_5 extends Application {

    private LineChart<Number, Number> lineChart;

    public lab11_5() {

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("График попадания точки в область");

        // Создание осей
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);

        // Создание главной панели
        VBox mainPane = new VBox(20);
        mainPane.setPadding(new Insets(20));
        mainPane.getChildren().add(lineChart);

        // Построение графика
        plotGraph();

        Scene scene = new Scene(mainPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void plotGraph() {
        //1-st figure
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("line 1");
        for (double x = -8; x <= -4; x += 0.01) {
            double y = -6;
            series1.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("line 2");
        for (double x = -8; x <= -6; x += 0.01) {
            double y = 2*x+10;
            series2.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series3 = new XYChart.Series<>();
        series3.setName("line 3");
        for (double x = -8; x <= -6; x += 0.01) {
            double y = -x-8;
            series3.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series4 = new XYChart.Series<>();
        series4.setName("line 4");
        for (double x = -8; x <= -6; x += 0.01) {
            double y = 3*x+24;
            series4.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series5 = new XYChart.Series<>();
        series5.setName("line 5");
        for (double x = -6; x <= -5; x += 0.01) {
            double y = -6*x-30;
            series5.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series6 = new XYChart.Series<>();
        series6.setName("line 6");
        for (double x = -5; x <= -2; x += 0.01) {
            double y = (2 * x)/3 + (10*x)/3;
            series6.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series7 = new XYChart.Series<>();
        series7.setName("line 7");
        for (double x = -4; x <= -2; x += 0.01) {
            double y = 4*x+10;
            series7.getData().add(new XYChart.Data<>(x, y));
        }

        //2-nd figure
        XYChart.Series<Number, Number> series8 = new XYChart.Series<>();
        series8.setName("line 8");
        for (double x = -2; x <= 1; x += 0.01) {
            double y = (13*x)/3-8/3;
            series8.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series9 = new XYChart.Series<>();
        series9.setName("line 9");
        for (double x = -2; x <= -1; x += 0.01) {
            double y = 10*x+14;
            series9.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series10 = new XYChart.Series<>();
        series10.setName("line 10");
        for (double x = -1; x <= 2; x += 0.01) {
            double y = -2*x+2;
            series10.getData().add(new XYChart.Data<>(x, y));
        }
        /*double x0 = -3;
        double y0 = Math.sqrt(3 - Math.pow(x0, 2) - 2 * x0) + 1;
        series10.getData().add(new XYChart.Data<>(x0, y0));*/

        XYChart.Series<Number, Number> series11 = new XYChart.Series<>();
        series11.setName("line 11");
        for (double x = 2; x <= 3; x += 0.01) {
            double y = 8*x-18;
            series11.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series12 = new XYChart.Series<>();
        series12.setName("line 12");
        for (double x = 3; x <= 6; x += 0.01) {
            double y = -(5*x)/3+11;
            series12.getData().add(new XYChart.Data<>(x, y));
        }

        XYChart.Series<Number, Number> series13 = new XYChart.Series<>();
        series13.setName("line 13");
        for (double x = 0; x <= 1; x += 0.01) {
            double y = -3*x-4;
            series13.getData().add(new XYChart.Data<>(x, y));
        }


        lineChart.getData().clear();
        lineChart.setCreateSymbols(false);
        lineChart.getData().addAll(
                series1, series2, series3, series4, series5, series6, series7, series8, series9, series10,
                series11, series12, series13
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package sample;

import java.io.File;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Runner extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Property Valuation and Assessment");

        final NumberAxis x = new NumberAxis();
        final NumberAxis y = new NumberAxis();

        x.setLabel("LOT");
        y.setLabel("LTDEPTH");

        CSVUtilities csvHelper = new CSVUtilities(new File("2012_SAT_Results.csv"));

        List<String> headers = csvHelper.getColumnHeaders();
        List<Integer> lots = csvHelper.getDataInt(3);
        //List<Double> ltdepth = csvHelper.getDataDouble(10);

        final LineChart<Number, Number> lineChart = new LineChart<>(x, y);

        lineChart.setTitle(stage.getTitle());
        XYChart.Series series = new XYChart.Series();
        series.setName(stage.getTitle());
/*
        for (int i = 0; i < lots.size(); i++) {
            series.getData().add(new XYChart.Data(lots.get(i), ltdepth.get(i)));
        }
*/
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

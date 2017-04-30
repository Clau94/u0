import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by Clau on 21.04.2017.
 */
public class LightsOn extends Application {

    private int x = 5;
    private int y = 5;

    Button[][] buttons = new Button[x][y];
    Button reset = new Button("RESET");
    Label yellow = new Label("0");
    Label blue = new Label("25");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("All Lights On");

        //Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(3);
        grid.setVgap(3);

        //Create Buttons
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Button btn = buttons[i][j] = new Button();
                Button top = buttons[i][j];
                if (i+1 >= 0 && i+1 <= 5) top = buttons[i+1][j];
//                Button bottom = buttons[i-1][j];
//                Button left = buttons[i][j+1];
//                Button right = buttons[i][j-1];

                btn.setStyle("-fx-background-color: #483d8b; -fx-min-width: 50px; -fx-min-height:50px");
                grid.add(btn, i, j);

                //Action
                btn.setOnAction(e -> {
                    if (btn.getStyle().contains("#483d8b")) {
                        btn.setStyle("-fx-background-color: #ffd000; -fx-min-width: 50px; -fx-min-height:50px");


                    } else {
                        btn.setStyle("-fx-background-color: #483d8b; -fx-min-width: 50px; -fx-min-height:50px");
                    }
                });
            }
        }

        blue.setStyle("-fx-background-color: #483d8b; -fx-min-height: 30px; -fx-min-width: 30px;");
        grid.add(blue, x-5, y+20);
        yellow.setStyle("-fx-background-color: #ffd000; -fx-min-height: 30px; -fx-min-width: 30px;");
        grid.add(yellow, x-4, y+20);
        reset.setStyle("-fx-background-color: #ff3f43; -fx-font-weight: 800");
        grid.add(reset, x-1, y+20);

        reset.setOnAction(e -> reset());

        Scene scene = new Scene(grid, 500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void reset() {
        for (int i = 0; i<5; i++){
            for(int j=0; j<5; j++) {
                buttons[i][j].setStyle("-fx-background-color: #483d8b; -fx-min-width: 50px; -fx-min-height:50px");
            }
        }
    }


}


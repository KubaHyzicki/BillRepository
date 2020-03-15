import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Rachunki");
        primaryStage.setScene(new Scene(root, 830, 500));
        primaryStage.show();
    }
    
    public static void main(String[] args){
        
        String databaseName = "database.db";
        BillDatabase db = new BillDatabase(databaseName);
        
        launch(args);
    }

}

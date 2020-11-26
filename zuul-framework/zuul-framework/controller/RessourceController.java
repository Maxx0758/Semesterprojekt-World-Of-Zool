package controller;

import gameEngine.Run;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class RessourceController {

    private static Scene homeScene;
    private static Scene outsideScene;
    private static Scene startmenuScene;

    public RessourceController(){

    }

    public static Scene getHomeScene() {
        return homeScene;
    }

    public static Scene getOutsideScene() {
        return outsideScene;
    }

    public static Scene getStartmenuScene() {
        return startmenuScene;
    }

    public void loadRessources() throws Exception{

        String fxmlFileHome = ("/fxml/home.fxml");
        FXMLLoader homeRoot = new FXMLLoader(getClass().getResource(fxmlFileHome));
        HomeController homeController = new HomeController();
        homeRoot.setController(homeController);
        homeScene = new Scene(homeRoot.load(), 1280 , 720);

        String fxmlFileOutside = ("/fxml/outside.fxml");
        FXMLLoader outsideRoot = new FXMLLoader(getClass().getResource(fxmlFileOutside));
        OutsideController outsidecontroller = new OutsideController();
        outsideRoot.setController(outsidecontroller);
        outsideScene = new Scene(outsideRoot.load(), 1280 , 720);

        String fxmlFileStartmenu = ("/fxml/startmenu.fxml");
        FXMLLoader startmenuRoot = new FXMLLoader(getClass().getResource(fxmlFileStartmenu));
        StartmenuController startmenuController = new StartmenuController();
        startmenuRoot.setController(startmenuController);
        startmenuScene = new Scene(startmenuRoot.load(), 1280 , 720);

        // set initial scene to menu scene
        Run.getPrimaryStage().setScene(getStartmenuScene());
        Run.getPrimaryStage().show();
    }
}
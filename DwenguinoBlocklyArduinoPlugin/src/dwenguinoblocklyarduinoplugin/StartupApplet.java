/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwenguinoblocklyarduinoplugin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javax.swing.JApplet;
import processing.app.Editor;

/**
 *
 * @author Tom
 */
public class StartupApplet extends JApplet {

    private JFXPanel fxContainer;
    private final int JFXPANEL_WIDTH_INT = 800;
    private final int JFXPANEL_HEIGHT_INT = 600;
    private Editor editor;

    public StartupApplet(Editor editor){
        this.editor = editor;
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                createScene();
            }
        });
    }

    private void createScene() {
        fxContainer.setScene(new Scene(new Browser(editor), 750, 500, Color.web("#666970")));
    }
}

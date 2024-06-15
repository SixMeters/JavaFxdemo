package com.example.demo;

import com.example.demo.view.PrimaryStageView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication extends AbstractJavaFxApplicationSupport {

    // 启动入口
    public static void main(String[] args) {
        launchApp(DemoApplication.class, PrimaryStageView.class, args);
    }
    // 启动前调用
    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }
}

package com.example.demo.controller;



import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

@FXMLController
public class PrimaryStageController implements Initializable {
    // 定义Fxml中的组件
    @FXML
    private Label titleLabel;
    @FXML
    private Label dividendLabel;
    @FXML
    private Label divisorLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private TextField titleField;
    @FXML
    private TextField dividendField;
    @FXML
    private TextField divisorField;
    @FXML
    private TextField resultField;
    @FXML
    private Button caculateBt;
    @FXML
    private Button generateBt;

    // 实现初始化方法
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caculateBt.setOnAction(e->{
            // 获取文本框中的值
            String dividendText = dividendField.getText();
            String divisorText = divisorField.getText();
            // 将字符串转换为double类型
            double dividend = Double.parseDouble(dividendText);
            double divisor = Double.parseDouble(divisorText);
            // 计算结果
            double result = dividend/divisor;
            // 将结果赋值给文本框,只保留小鼠点后3位
            resultField.setText(String.format("%.3f", result));
//            resultField.setText(String.valueOf(result));
        });
//        创建一个名为DatabaseExample的类，并在main方法中调用该方法。

//
//        创建一个Connection对象，用于连接到MySQL数据库。这里使用了DriverManager.getConnection()方法，传入数据库的URL、用户名和密码。
        generateBt.setOnAction(e->{
            ResultSet rs = null;
            Connection conn = null;
            Statement stmt = null;
            Random random = new Random();

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sai_text","root","311429");
                // 创建一个Statement对象，用于执行SQL语句。
                stmt = conn.createStatement();

                // 执行查询语句，获取userNid数据
                rs = stmt.executeQuery("SELECT COUNT(*) FROM sai_text.tb_user");
                // 获取userId的总数
                rs.next();
                int userIdCount = rs.getInt(1);
                // 生成1-userIdCount之间的随机数
                int randomUserId = 1 + random.nextInt(userIdCount);

                rs = stmt.executeQuery("SELECT userNid FROM tb_user WHERE userId =" + randomUserId);

                // 遍历结果集，将userNid输出到titleField文本框中
                while (rs.next()) {
    //                String userId =rs.getString("userId");
                    String userNid = rs.getString("userNid");
                    titleField.setText(userNid);

    //                int randomIndex = (int) (Math.random() * userNid.length());
                    // 关闭连接
    //                rs.close();
    //                stmt.close();
    //                conn.close();
                }
            } catch (SQLException r) {
                throw new RuntimeException(r);
            }

        });
    }
}




package workshop3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddressBook extends Application {

	@Override
	public void start(Stage primaryStage) {

		GridPane gpane = new GridPane();
		gpane.setPadding(new Insets(11, 12, 13, 14));
		gpane.setHgap(5);
		gpane.setVgap(4);

		Label nameL = new Label("Name");
		TextField nameT = new TextField();
		nameT.setPrefColumnCount(32);
		GridPane.setConstraints(nameL, 0, 0);
		GridPane.setConstraints(nameT, 1, 0);

		Label streetL = new Label("Street");
		TextField streetT = new TextField();
		nameT.setPrefColumnCount(32);
		GridPane.setConstraints(streetL, 0, 1);
		GridPane.setConstraints(streetT, 1, 1);

		FlowPane fpane1 = new FlowPane();
		fpane1.setHgap(2);

		Label cityL = new Label("City");
		gpane.add(cityL, 0, 2);

		TextField cityT = new TextField();
		cityT.setPrefColumnCount(20);

		Label stateL = new Label("State");
		TextField stateT = new TextField();
		stateT.setPrefColumnCount(2);

		Label zipL = new Label("ZIP");
		TextField zipT = new TextField();
		zipT.setPrefColumnCount(5);

		fpane1.getChildren().addAll(cityT, stateL, stateT, zipL, zipT);
		GridPane.setConstraints(fpane1, 1, 2);

		FlowPane fpane2 = new FlowPane();
		fpane2.setHgap(4);
		fpane2.setPadding(new Insets(10, 0, 0, 0));

		Button btn1 = new Button("Add");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileButton obj = new FileButton();
				try {

					String nameStr = new String(obj.fixLength(nameT.getText(), 32));
					String streetStr = new String(obj.fixLength(streetT.getText(), 32));
					String cityStr = new String(obj.fixLength(cityT.getText(), 20));
					String stateStr = new String(obj.fixLength(stateT.getText(), 2));
					String zipStr = new String(obj.fixLength(zipT.getText(), 5));

					obj.add(nameStr + "," + streetStr + "," + cityStr + "," + stateStr + "," + zipStr + "\r\n");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		Button btn2 = new Button("First");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileButton obj = new FileButton();
				String array[] = new String[5];
				try {
					array = obj.first();

					nameT.setText(array[0]);
					streetT.setText(array[1]);
					cityT.setText(array[2]);
					stateT.setText(array[3]);
					zipT.setText(array[4]);

				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		Button btn3 = new Button("Next");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				FileButton obj = new FileButton();
				String array[] = new String[5];
				try {
					array = obj.next();
					nameT.setText(array[0]);
					streetT.setText(array[1]);
					cityT.setText(array[2]);
					stateT.setText(array[3]);
					zipT.setText(array[4]);

				} catch (Exception e1) {
					System.out.println("No next line");
				}
			}
		});

		Button btn4 = new Button("Previous");
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				FileButton obj = new FileButton();
				String array[] = new String[5];
				try {
					array = obj.previous();
					nameT.setText(array[0]);
					streetT.setText(array[1]);
					cityT.setText(array[2]);
					stateT.setText(array[3]);
					zipT.setText(array[4]);

				} catch (Exception e1) {
					System.out.println("There is no previous data");
				}
			}
		});

		Button btn5 = new Button("Last");
		btn5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				FileButton obj = new FileButton();
				String array[] = new String[5];
				try {
					array = obj.last();
					nameT.setText(array[0]);
					streetT.setText(array[1]);
					cityT.setText(array[2]);
					stateT.setText(array[3]);
					zipT.setText(array[4]);

				} catch (Exception e1) {

					System.out.println(e1);
				}
			}
		});

		Button btn6 = new Button("Update");
		btn6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				FileButton obj = new FileButton();
				try {
					
					String nameStr = new String(obj.fixLength(nameT.getText(), 32));
					String streetStr = new String(obj.fixLength(streetT.getText(), 32));
					String cityStr = new String(obj.fixLength(cityT.getText(), 20));
					String stateStr = new String(obj.fixLength(stateT.getText(), 2));
					String zipStr = new String(obj.fixLength(zipT.getText(), 5));
					
					
					obj.update(nameStr + "," + streetStr + "," + cityStr + "," + stateStr + "," + zipStr + "\r\n");
					//System.out.println("ininini");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});

		fpane2.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
		GridPane.setConstraints(fpane2, 1, 3);

		gpane.getChildren().addAll(nameL, nameT, streetL, streetT, fpane1, fpane2);
		Scene scene = new Scene(gpane, 500, 150);

		primaryStage.setTitle("Address Book");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}

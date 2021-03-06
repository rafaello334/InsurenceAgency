package pl.agencja.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pl.agencja.client.model.users.Admin;

public class ChangePasswordPaneController implements Initializable
{

	@FXML
	private Button changePasswordButton;

	@FXML
	private PasswordField newPasswordTextField;

	@FXML
	private PasswordField oldPasswordTextField;

	@FXML
	private PasswordField newPasswordRepeatTextField;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		System.out.println("ChangePasswordPaneController" + this);
		configureButtons();
	}

	private void configureButtons()
	{
		changePasswordButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				changePassword();
			}
		});

		oldPasswordTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
		{

			@Override
			public void handle(KeyEvent keyEvent)
			{
				if (keyEvent.getCode() == KeyCode.ENTER)
				{
					changePassword();
				}

			}
		});

		newPasswordTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
		{

			@Override
			public void handle(KeyEvent keyEvent)
			{
				if (keyEvent.getCode() == KeyCode.ENTER)
				{
					changePassword();
				}

			}
		});

		newPasswordRepeatTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
		{

			@Override
			public void handle(KeyEvent keyEvent)
			{
				if (keyEvent.getCode() == KeyCode.ENTER)
				{
					changePassword();
				}
			}
		});
	}

	private void changePassword()
	{
		try
		{
			if ((oldPasswordTextField.getText().equals(Admin.getPassword())
					&& newPasswordTextField.getText().equals(newPasswordRepeatTextField.getText())))
			{
				Admin.setPassword(newPasswordTextField.getText());
				System.out.println("Has這 zosta這 zmienione");
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Zmieniono has這");
				alert.setHeaderText(null);
				alert.setContentText("Has這 zosta這 zmienione poprawnie!");
				alert.showAndWait();
			} else
			{
				System.out.println("B章d zmiany has豉");
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("B豉d zmiany has豉");
				alert.setHeaderText(null);
				alert.setContentText("Stare has這 jest nieprawid這we. \nPopraw dane w formularzu!");
				alert.showAndWait();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

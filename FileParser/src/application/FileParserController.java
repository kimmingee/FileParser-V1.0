package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class FileParserController {
	@FXML
	private TextField inFilePath;				//�������
	@FXML
	private CheckBox lowPathsInclude;			//������������
	@FXML
	private TextField fileNamePattern;			//���ϸ�����
	@FXML
	private TextField paserSetFileFullPath;		//set����
	@FXML
	private TextField outFilePath;				//������
	@FXML
	private CheckBox orignFilePathApply;		//�������� ����
	@FXML
	private Button inFilePathBtn;				
	@FXML
	private Button paserSetFileFullPathBtn;
	@FXML
	private Button outFilePathBtn;
	
	@FXML
	protected void inFilePathEvent(ActionEvent event) {
		inFilePathBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				DirectoryChooser dc = new DirectoryChooser();
				File selectedDc = dc.showDialog(null);
				String selectedDcPath = selectedDc.getPath();
				inFilePath.setText(selectedDcPath);
			}
		}); 
	}
	
	@FXML
	protected void paserSetFileFullPathEvent(ActionEvent event) {
		paserSetFileFullPathBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				FileChooser fileChooser = new FileChooser();
				File selectedFile = fileChooser.showOpenDialog(null);
				
				String selectedFilePath = selectedFile.getPath();
				paserSetFileFullPath.setText(selectedFilePath);
			}
		}); 
	}
	
	@FXML
	protected void outFilePathEvent(ActionEvent event) {
		outFilePathBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				DirectoryChooser dc = new DirectoryChooser();
				File selectedDc = dc.showDialog(null);
				String selectedDcPath = selectedDc.getPath();
				outFilePath.setText(selectedDcPath);
			}
		}); 
	}
	
	@FXML
	protected void orignFilePathApplyEvent(ActionEvent event) {
		if(orignFilePathApply.isSelected()) {
			inFilePath.setText(outFilePath.getText());
			outFilePath.clear();
		}else {
			
		}
	}
}

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
	private TextField inFilePath;				//원본경로
	@FXML
	private CheckBox lowPathsInclude;			//하위폴더포함
	@FXML
	private TextField fileNamePattern;			//파일명필터
	@FXML
	private TextField paserSetFileFullPath;		//set파일
	@FXML
	private TextField outFilePath;				//결과경로
	@FXML
	private CheckBox orignFilePathApply;		//원본폴더 여부
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

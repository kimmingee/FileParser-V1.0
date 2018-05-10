package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
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
	private TextArea textFileParser;
	@FXML
	private Button inFilePathBtn;				
	@FXML
	private Button paserSetFileFullPathBtn;
	@FXML
	private Button outFilePathBtn;
	
	@FXML
	protected void inFilePathEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		inFilePathBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				DirectoryChooser dc = new DirectoryChooser();
				File selectedDc = dc.showDialog(null);
				String selectedDcPath = selectedDc.getPath();
				inFilePath.setText(selectedDcPath);
				textFileParser.setText("원본경로 적용 : "+selectedDcPath);
			}
		}); 
	}
	
	@FXML
	protected void fileNamePatternEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		fileNamePattern.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				textFileParser.appendText("\n파일명필터 적용 : ");
			}
			
		});
	}
	
	@FXML
	protected void lowPathsIncludeEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		Boolean lowPathInclude;
		if(lowPathsInclude.isSelected()) {
			lowPathInclude = true;
			textFileParser.appendText("\n원본경로 하위폴더 포함(체크)");
		}else {
			lowPathInclude = false;
			textFileParser.appendText("\n원본경로 하위폴더 포함(체크해제)");
		}
	}
	
	@FXML
	protected void paserSetFileFullPathEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		paserSetFileFullPathBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				FileChooser fileChooser = new FileChooser();
				File selectedFile = fileChooser.showOpenDialog(null);
				
				String selectedFilePath = selectedFile.getPath();
				paserSetFileFullPath.setText(selectedFilePath);
				textFileParser.appendText("\nSET파일 적용 : "+selectedFilePath);
			}
		}); 
	}
	
	@FXML
	protected void outFilePathEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		outFilePathBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				DirectoryChooser dc = new DirectoryChooser();
				File selectedDc = dc.showDialog(null);
				String selectedDcPath = selectedDc.getPath();
				outFilePath.setText(selectedDcPath);
				textFileParser.appendText("\n결과경로 : "+selectedDcPath);
			}
		}); 
	}
	
	@FXML
	protected void orignFilePathApplyEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		if(orignFilePathApply.isSelected()) {
			outFilePath.setText(inFilePath.getText());
			textFileParser.appendText("\n결과경로 원본에 적용(체크)");
			//inFilePath.setText(outFilePath.getText());
			//outFilePath.clear();
		}else {
			textFileParser.appendText("\n결과경로 원본에 적용(체크해제)");
		}
	}
}

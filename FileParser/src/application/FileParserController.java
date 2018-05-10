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
				textFileParser.setText("������� ���� : "+selectedDcPath);
			}
		}); 
	}
	
	@FXML
	protected void fileNamePatternEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		fileNamePattern.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				textFileParser.appendText("\n���ϸ����� ���� : ");
			}
			
		});
	}
	
	@FXML
	protected void lowPathsIncludeEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		Boolean lowPathInclude;
		if(lowPathsInclude.isSelected()) {
			lowPathInclude = true;
			textFileParser.appendText("\n������� �������� ����(üũ)");
		}else {
			lowPathInclude = false;
			textFileParser.appendText("\n������� �������� ����(üũ����)");
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
				textFileParser.appendText("\nSET���� ���� : "+selectedFilePath);
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
				textFileParser.appendText("\n������ : "+selectedDcPath);
			}
		}); 
	}
	
	@FXML
	protected void orignFilePathApplyEvent(ActionEvent event) {
		textFileParser.setEditable(false);
		if(orignFilePathApply.isSelected()) {
			outFilePath.setText(inFilePath.getText());
			textFileParser.appendText("\n������ ������ ����(üũ)");
			//inFilePath.setText(outFilePath.getText());
			//outFilePath.clear();
		}else {
			textFileParser.appendText("\n������ ������ ����(üũ����)");
		}
	}
}

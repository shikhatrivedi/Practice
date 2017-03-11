package packagerun;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class GetFile extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public String[] func(){
	JFileChooser fileChooser = new JFileChooser();
	int result = fileChooser.showOpenDialog(this);
	String str[]={"",""};
	if (result == JFileChooser.APPROVE_OPTION) {
	    File selectedFile = fileChooser.getSelectedFile();
	    str[0]=selectedFile.getAbsolutePath();
	    str[1]=selectedFile.getName();
	    str[0].replace("'\'","'\\'");
	}
	return str;
}
}
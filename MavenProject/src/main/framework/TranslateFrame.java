import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class TranslateFrame extends JFrame implements ItemListener {

	private String input;
	private String translated;
	private String messageToTranslate;
	
	JLabel origLang = new JLabel("What Language:", JLabel.LEFT);
	JTextField pageAddress = new JTextField(15);
	FlowLayout flo = new FlowLayout();
	
	JLabel translateTo = new JLabel("Translate to:", JLabel.LEFT);
	JTextField pageAddress1 = new JTextField(15);
	FlowLayout flo1 = new FlowLayout();
	
	JLabel translateComments = new JLabel("What to translate:", JLabel.LEFT);
	JTextArea comments = new JTextArea(8, 40);
	FlowLayout flo2 = new FlowLayout();


	public TranslateFrame() {
		
		super("Google Translate");

		//creating frame
		setLooksAndFeel();
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creating input areas

		setLayout(flo);
		add(origLang);
		add(pageAddress);
		
		//creating input areas
		setLayout(flo1);
		add(translateTo);
		add(pageAddress1);
		

		setLayout(flo2);
		add(translateComments);
		add(comments);
		setVisible(true);
		comments.setLineWrap(true);
		comments.setWrapStyleWord(true);
		
		setInput(pageAddress.getText().toString());
		setTranslated(pageAddress1.getText().toString());
		setMessage(comments.getText().toString());
		
		
		setVisible(true);
	}



	private void setLooksAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception exc) {
			//ignore
		}
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static TranslateFrame frame;

	@Override
	public void itemStateChanged(ItemEvent e) {

	}
	
	public static void main(String[] arguments) {
		setFrame(new TranslateFrame());
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	public String getTranslated() {
		return translated;
	}

	public void setTranslated(String translated) {
		this.translated = translated;
	}
	
	public String getMessage() {
		return messageToTranslate;
	}
	
	public void setMessage(String message) {
		this.messageToTranslate = message;
	}

	public static TranslateFrame getFrame() {
		return frame;
	}

	public static void setFrame(TranslateFrame frame) {
		TranslateFrame.frame = frame;
	}
}



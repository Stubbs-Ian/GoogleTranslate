import java.util.Scanner;

public class UserInput {

	private String input;
	private String translated;
	private String messageToTranslate;
	
	private Scanner messages = new Scanner(System.in);
	private Scanner reader = new Scanner(System.in);  // Reading from System.in
	private Scanner reading = new Scanner(System.in);
	
	public UserInput() 
	{
		//set all variables to empty strings
		input = translated = messageToTranslate = "";
	}
	
	public void getOriginalLang() {
		//get user input
		System.out.print("Enter A language you want to translate: ");
		setInput(reader.next()); //set what language the user wants to translate
	}
	
	public void getTranslatingLang() {
		//get user input for language to be translated into
		System.out.print("Enter what you want it translated into: ");
		setTranslated(reading.next()); //set what user wants the message translated into
	}
	
	public void getMessageToTranslate() {
		//get the message the user wants translated
		System.out.println("What is your message? ");
		setMessage(messages.nextLine()); //set the message the user wants translated
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
}

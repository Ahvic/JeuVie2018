import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Event;

public class Programme2{

	//Demande un argument apres le java Programme2

	static public void main(String[] args) {
		final String message = args[0] + "       ";
		
		System.out.print((char)Event.ESCAPE + "7");
			
		Timer t = new Timer(200, new ActionListener() {
			int i=0;
			public void actionPerformed(ActionEvent e) {
				System.out.print((char)Event.ESCAPE + "8");
				System.out.println(message.substring(i%message.length())
					+ message.substring(0,i%message.length()));
				System.out.println("t = " + i);
				i++;
			}
		});
		t.start();

		try {
			System.in.read();
		}
		catch (IOException e){}

		t.stop();
	}
}
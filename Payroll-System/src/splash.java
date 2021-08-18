import java.awt.*;
import javax.swing.*;
//this will be the main class of the project -> our project will be executed from this class

/*
	both awt and swing are used for making GUI based applications
	awt -> is used for building applications for windows system. It is a heavy weight API
	swing -> some of its features are platform independent and it is a light weight API
*/

/*
	here we will bee using swing for making the frame of output window
	along with that we will be using multi-threading
*/

/**
 *
 * @author HUMBLEFOOL
 */
class splash {
	public static void main(String s[]) {
		sframe f1 = new sframe("Payroll System  > Version 2.0");
		f1.setVisible(true); // show
		int i;
		int x = 1;
		// the below loop is for showing a splash window
		for (i = 2; i <= 600; i += 4, x += 1) {
			f1.setLocation((600 - ((i + x) / 2)), 400 - (i / 2));
			f1.setSize(i + x, i);

			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}
}

/*
 * our below class is extending the JFrame class
 * 
 * Threads can be implemented in 2 ways 
 * 	-> Extends thread 
 * 	-> Implements Runnable
 * As we are already extending one class so we can't use Extend thread here(in
 * java we can extend only one class at a time but we can extends multiple
 * interfaces)
 */
class sframe extends JFrame implements Runnable {
	// creating a object of Thread class
	Thread t1;
	// parameterized constructor
	sframe(String s) {
		// super should be the first keyword which is called in extended class
		// here its objective is to set the title of the page
		super(s);
		// The FlowLayout is used to arrange the components in a line, one after another (in a flow). It is the default layout of applet or panel. 
		setLayout(new FlowLayout());
		// loading the image with the help of getSystemResource and saving in a object
		// of ImageIcon

		ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll_system.jpg"));
		// resizing our image by converting ImageIcon to Image and then converting back
		// to ImageIcon object
		// we are doing this because Image object can't be applied to JFrame but
		// ImageIcon can
		Image i1 = c1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);

		JLabel m1 = new JLabel(i2);
		// adding the required JLabel(which contains our image) to the frame
		add(m1);
		// creating a thread and starting it
		t1 = new Thread(this);
		t1.start();
		// once the start function is called then it will call run function
	}

	public void run() {
		try {
			// applying a delay of 7 seconds
			Thread.sleep(7000);
			// after 7 seconds setting the visibility of the current frame to false and
			// opening the login frame(creating a object of login class)
			this.setVisible(false);
			login f1 = new login();

		} catch (Exception e) {
			/*
			 * The printStackTrace() method in Java is a tool used to handle exceptions and
			 * errors. It is a method of Java's throwable class which prints the throwable
			 * along with other details like the line number and class name where the
			 * exception occurred. printStackTrace() is very useful in diagnosing
			 * exceptions.
			 */
			e.printStackTrace();
		}
	}
}
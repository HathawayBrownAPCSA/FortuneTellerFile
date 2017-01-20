/** Fortune Teller, Reading from a File
 *  Chooses a random Fortune from a list of Strings stored in a file.
 *  Precondition:
 *    The data file exists, holding NUM_FORTUNES fortunes.  
 *    File Name: 
 *        fortunes.txt  
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.Scanner;
import java.io.*;


public class FortuneTellerFile extends JFrame
    implements ActionListener
{

  // Declare an array of "fortunes" (strings):
  private static final int NUM_FORTUNES = 3;
  private static String[] fortunes;

  private JTextField display;
  
  // Constructor opens a window with a JTextField and a "Next" button
  public FortuneTellerFile()
  {
    super("Fortune Teller");

    display = new JTextField("  Press \"Next\" to see your fortune...", 35);
    display.setBackground(Color.WHITE);
    display.setEditable(false);

    JButton go = new JButton("Next");
    go.addActionListener(this);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(display);
    c.add(go);
    
    fortunes = new String[NUM_FORTUNES];
    loadFortunes();
  }
  
  // Load the fortunes from a text file
  public boolean loadFortunes ()
  {
    // open the file
    String fileName = "fortunes.txt";
    File fortuneFile = new File(fileName);
    Scanner input = null;
    try
    {
        input = new Scanner(fortuneFile);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open " + fileName + " ***");
        System.exit(1);        // quit the program
    } 

    // read the fortunes from the file, one per line
    for (int i = 0; i < NUM_FORTUNES; i++)
      fortunes[i] = input.nextLine();
    input.close();
    
    return true;
    
    // Alternative version that reads until the file is filled

  }
  
  public void actionPerformed(ActionEvent e)
  {
    // Pick and display a random fortune:
    int fNum = (int)(NUM_FORTUNES * Math.random());

    display.setText("  " + fortunes[fNum] );
  }

  
  public static void main(String[] args)
  {   
    JFrame window = new FortuneTellerFile();
    window.setBounds(300, 300, 500, 100);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true); 
  }
}

//Importing needed packages and modules
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Driver
{
  public static void main( final String[] args) throws Exception
  {
    //Creating a new JPanel
    JPanel panel = new JPanel();

    //Creating a new image, scaling the image, and then adding it to our Jpanel
    //The image will show up on the left side of the buttons
    ImageIcon Icon = new ImageIcon("babyItsColdOutsideText.jpg"); // load the image to a imageIcon
    Image image = Icon.getImage(); // transform it
    Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    ImageIcon resizedIcon = new ImageIcon(newimg);  // transform it back
    JLabel label = new JLabel(resizedIcon);
    panel.add(label);

    //Creating the radio buttons
    JRadioButton buttonOne = new JRadioButton("Website ");
    JRadioButton buttonTwo = new JRadioButton("Animation");
    JRadioButton buttonThree = new JRadioButton("Video");
    JRadioButton buttonFour = new JRadioButton("Slide Show");
    JRadioButton buttonFive = new JRadioButton("Exit");

    //Adding the buttons to the JPanel
    panel.add(buttonOne);
    panel.add(buttonTwo);
    panel.add(buttonThree);
    panel.add(buttonFour);
    panel.add(buttonFive);

    //Showing the same image as before but now it will be placed on the right side of the buttons
    ImageIcon Icon2 = new ImageIcon("babyItsColdOutsideText.jpg"); // load the image to a imageIcon
    Image image2 = Icon2.getImage(); // transform it
    Image newimg2 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    ImageIcon resizedIcon2 = new ImageIcon(newimg2);  // transform it back
    JLabel label2 = new JLabel(resizedIcon);
    panel.add(label2);


    //Adds a cool Dark Blue background to our Jpanel
    panel.setBackground(Color.blue);

    //Loop to keep showing button choices (GUI interface) until user presses exit radio button
    while(true)
    {
      //Pops the GUI interface up to the screen
      JOptionPane.showMessageDialog(null, panel);

      //Button 1 opens up Website if clicked
      if(buttonOne.isSelected())
      {
        WinterWebsite w = new WinterWebsite();
        w.links();
      }

      //Button 2 opens up animation if clicked
      else if(buttonTwo.isSelected())
      {
        snow animation = new snow();
        animation.animate();
      }

      //Button 3 opens up Video if clicked
      else if(buttonThree.isSelected())
      {
        video v = new video();
        video.links();
      }

      //Button 4 opens up slideshow if clicked
      else if(buttonFour.isSelected())
      {
        new slideshowExample();
        playMusic player = new playMusic();
        String audioFilePath = "C:/CSCE 111 Labs/Final Project/music/Baby It's Cold Outside.wav";
        player.play(audioFilePath);
      }

      //Button 5 Exits the program if clicked
      else if(buttonFive.isSelected())
      {
        break;
      }
    }


  }

}

//Importing all necessary packages
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Creating the slideshow class
public class slideshowExample extends JFrame
{
    //Creating starting variables to use later.
    JLabel pic;
    Timer tm;
    int x = 0;
    //Storing all the images in an array
    String[] list = {
                      "C:/Users/ppola/Pictures/Saved Pictures/p1.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p2.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p3.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p4.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p5.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p6.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p7.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p8.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p9.jpg",
                      "C:/Users/ppola/Pictures/Saved Pictures/p10.jpg"
                    };

        public slideshowExample()
        {
        super("Java SlideShow");

        //Creating a new JLabel and setting its bounds
        pic = new JLabel();
        pic.setBounds(40, 30, 1100, 500);

        //Setting the image size
        SetImageSize(6);
        //setting a timer to rotate images
        tm = new Timer(2500,new ActionListener()
        {
            //Creating an action event to go back to the first image after looping through all images
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0;
            }
        });
        //Setting all the sizes and layouts for the background
        add(pic);
        tm.start();
        setLayout(null);
        setSize(1200, 600);

        //Setting the background color to light blue using it's hexidecimal value
        getContentPane().setBackground(Color.decode("#00E2FF"));
        setLocationRelativeTo(null);

        //Stopping the program when the user closes the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Making sure the slideshow and pictures are all showing to the screen
        setVisible(true);
    }
    //creating a function to set the image size
    public void SetImageSize(int i)
    {
        //By using image icons I can make sure each pic has the same exact dimensions when the pop up on the screen
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        //Scaling the image
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        //Creating a new image icon objet with those new dimensions
        ImageIcon newImc = new ImageIcon(newImg);
        //Setting the picture that shows up to have that image
        pic.setIcon(newImc);
    }
}
//Giving credit to the link that helped me learn a lot about what this code does and how it does it:
//https://1bestcsharp.blogspot.com/2015/04/JAVA-How-To-Create-A-Slideshow-In-Java-Swing-Using-NetBeans.html

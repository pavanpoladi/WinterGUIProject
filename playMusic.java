//Importing all needed packages
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Creating the class that will create all the needed audioStream objects and play the music while the slideshow runs
//I will call this method from the main GUI class
public class playMusic implements LineListener
{
    //Creating a boolean that will tell us if the music has finished playing. I will use this in a while loop later.
    boolean playCompleted;

    //Creating the method to play the song
    public void play(String audioFilePath)
    {
        //Creating an audio file object that takes in the location of the .wav file I downloaded for the song.
        File audioFile = new File(audioFilePath);

        //Creating a try-catch structure to perform two functions:
        //First function is to catch if an exception occurs and let the user know without completely crashing the program
        //Function two: if there is no exception that occures, then create the necessary audio objects and play the song
        try {
            //The program will get into this section of code if there are no exceptions

            //Creating a new audiostream object that takes the information from the .wav file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            //getting the format and info from the file
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            //Creating an audioClip object that loops through the file taking in all the lines for the file address
            //Basically taking the file and turning it into information the computer can understand and alter
            Clip audioClip = (Clip) AudioSystem.getLine(info);

            //Adding an action listener to the audioclip. This will let the object actually perform a designated function
            audioClip.addLineListener(this);

            //Opening the audioStream
            audioClip.open(audioStream);

            //Start playing the strong
            audioClip.start();

            //This is where i use the boolean I created and talked about earlier
            while (!playCompleted)
            {
                //Once the song is completed it will wait a certain amount of time and start again
                try
                {
                    Thread.sleep(100000);
                }

                //If there is an exception the program will catch it, trace the error, and let the user know what
                //went wrong without completely crashing the program
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }

            //Closing the audio clip, similar to how you would close a file after appending or reading from it.
            audioClip.close();
        }

        //These are the three exceptions that could be possible
        //Once again, these files will let the user know what went wrong without completely crashing the program

        //The unsupported Audio File would indicate that the file is not a .wav file. Any other type of
        //file will not work.
        catch (UnsupportedAudioFileException ex)
        {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        }

        //Line unavailable Exception occurs when the line can't be opened. This usually happens when the file is already
        //open and being played by another application at the time you run the program
        catch (LineUnavailableException ex)
        {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        }

        //The last Exception that can occur is an IO Exception
        //this exception is related to Input and Output operations in the Java code.
        //It happens when there is a failure during reading, writing and searching file or directory operations.
        catch (IOException ex)
        {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }

    //This method will listen for when each new line in the song (from the file) is played and updates
    //The song accordingly in the background
    @Override
    public void update(LineEvent event)
    {
        //get the type of line it is on to see what it can work with
        LineEvent.Type type = event.getType();

        //If the song just started let the user know.
        //This should allways print to the consoleif everything goes smoothly.
        if (type == LineEvent.Type.START)
        {
            System.out.println("Playback started.");
        }

        //If the song is over, let the user know.
        //If the user closes the program early, This message will not display to the console.
        else if (type == LineEvent.Type.STOP)
        {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
    }
}
//Giving credit to the link that helped me learn a lot about what this code does and how it does it:
//https://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples

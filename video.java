import javax.swing.*;
import java.awt.*;
import java.net.URI;


public class video
{
  public static void links() throws Exception
  {
    Desktop startLink = Desktop.getDesktop();
    startLink.browse(new URI("https://youtu.be/VTN7nUJ4kwA"));
  }
}

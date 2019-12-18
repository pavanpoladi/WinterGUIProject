import javax.swing.*;
import java.awt.*;
import java.net.URI;


public class WinterWebsite
{
  public static void links() throws Exception
  {
    Desktop startLink = Desktop.getDesktop();
    startLink.browse(new URI("http://people.tamu.edu/~emh3449/baby/baby.html"));
  }
}

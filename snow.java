import java.lang.*;
import java.util.*;
import java.io.*;

public class snow
{

  public static void animate() throws InterruptedException, IOException {
    ArrayList<String> frame1 = new ArrayList<String>();
    ArrayList<String> frame2 = new ArrayList<String>();
    ArrayList<String> frame3 = new ArrayList<String>();
    ArrayList<String> frame4 = new ArrayList<String>();
    ArrayList<String> frame5 = new ArrayList<String>();
    ArrayList<String> frame6 = new ArrayList<String>();
    ArrayList<String> frame7 = new ArrayList<String>();
    ArrayList<String> frame8 = new ArrayList<String>();
    ArrayList<String> frame9 = new ArrayList<String>();
    ArrayList<String> frame10 = new ArrayList<String>();

    GetFrames("frame1.txt", frame1);
    GetFrames("frame2.txt", frame2);
    GetFrames("frame3.txt", frame3);
    GetFrames("frame4.txt", frame4);
    GetFrames("frame5.txt", frame5);
    GetFrames("frame6.txt", frame6);
    GetFrames("frame7.txt", frame7);
    GetFrames("frame8.txt", frame8);
    GetFrames("frame9.txt", frame9);
    GetFrames("frame10.txt", frame10);

    print(frame1);
    Thread.sleep(250);
    print(frame2);
    Thread.sleep(250);
    print(frame3);
    Thread.sleep(250);
    print(frame4);
    Thread.sleep(250);
    print(frame5);
    Thread.sleep(250);
    print(frame6);
    Thread.sleep(250);
    print(frame7);
    Thread.sleep(250);
    print(frame8);
    Thread.sleep(250);
    print(frame9);
    Thread.sleep(250);
    print(frame10);
    print(frame1);
    Thread.sleep(250);
    print(frame2);
    Thread.sleep(250);
    print(frame3);
    Thread.sleep(250);
    print(frame4);
    Thread.sleep(250);
    print(frame5);
    Thread.sleep(250);
    print(frame6);
    Thread.sleep(250);
    print(frame7);
    Thread.sleep(250);
    print(frame8);
    Thread.sleep(250);
    print(frame9);
    Thread.sleep(250);
    print(frame10);
    print(frame1);
    Thread.sleep(250);
    print(frame2);
    Thread.sleep(250);
    print(frame3);
    Thread.sleep(250);
    print(frame4);
    Thread.sleep(250);
    print(frame5);
    Thread.sleep(250);
    print(frame6);
    Thread.sleep(250);
    print(frame7);
    Thread.sleep(250);
    print(frame8);
    Thread.sleep(250);
    print(frame9);
    Thread.sleep(250);
    print(frame10);
    print(frame1);
    Thread.sleep(250);
    print(frame2);
    Thread.sleep(250);
    print(frame3);
    Thread.sleep(250);
    print(frame4);
    Thread.sleep(250);
    print(frame5);
    Thread.sleep(250);
    print(frame6);
    Thread.sleep(250);
    print(frame7);
    Thread.sleep(250);
    print(frame8);
    Thread.sleep(250);
    print(frame9);
    Thread.sleep(250);
    print(frame10);
  }//end animate

  public static void cls() throws IOException, InterruptedException {
    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  }// end cls

  public static void GetFrames(String fileName, ArrayList<String> frame) throws IOException {

    try {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      int i = 0;
      String line;
      while((line = in.readLine()) != null) {
        frame.add(line);
        i++;
      } // end while
      in.close();
    }// end try
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + fileName + "'");
    }
  }// end getframes

  public static void print(ArrayList<String> printable)throws IOException, InterruptedException {
    cls();
    for(int k = 0; k < printable.size(); k++) {
      System.out.print(" ");
      System.out.println(printable.get(k));
    }
  }//end print
}//end class

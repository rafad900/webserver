import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;




public class ImageRequest {
    private static HttpURLConnection connection = null;
    private static InputStream is = null;
 //   private BufferedReader rd = null;   This is unecessary for images
    private static Image img = null;
    private static JFrame frame = null;
    private static JLabel label = null;

    private static void createWindow() {
        frame = new JFrame();
        label = new JLabel( new ImageIcon(img) );
        frame.add(label);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }

    private static void connect() {
        try {
            URL url = new URL("http://localhost:8000/blog/image");
            connection = (HttpURLConnection) url.openConnection();
            is = connection.getInputStream();
            img = ImageIO.read(is);
            
            //rd = new BufferedReader(new InputStreamReader(is));   This is for use with text
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            
        
    public static void main( String [] args) {
        System.out.println("This is the test for the functions");
        connect();
        System.out.println("Got past the connection");
        createWindow();
        System.out.println("Created the window");


    }
}

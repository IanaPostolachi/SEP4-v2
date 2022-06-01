package sep4package.Model.Windows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReceiveWindow implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {

                String str = getHttpInterface("http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/windows");

                if (str.contains("false")) {
                    WindowStatus.setStatus("00");
                } else {
                    WindowStatus.setStatus("64");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getHttpInterface(String path)
    {
        BufferedReader in = null;
        StringBuffer result = null;
        try
        {
            URL url = new URL(path);
            //open connection with URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "utf-8");
            connection.connect();

            result = new StringBuffer();
            //read URL response
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result.append(line);
            }
            return result.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        return null;
    }
}

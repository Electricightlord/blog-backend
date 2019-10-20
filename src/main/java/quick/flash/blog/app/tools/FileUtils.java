package quick.flash.blog.app.tools;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


/**
 * @author lihao
 * @date 2019-09-21 18:25
 */
public class FileUtils {

    public static String readAll(String cssFileName) {
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(cssFileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            byte[] data = new byte[1024];
            assert inputStream != null;
            int len;
            while ((len=inputStream.read(data)) != -1) {
                stringBuilder.append(new String(data,0,len, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}

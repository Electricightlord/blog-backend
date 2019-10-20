package quick.flash.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.File;

@SpringBootApplication
@MapperScan(basePackages = "quick.flash.blog.app.mapper")
public class BlogApplication {

    private static final Logger log = LoggerFactory.getLogger(BlogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
        File savePath = new File("image/");
        if (!savePath.exists()) {
            if (!savePath.mkdirs()) {
                log.error("目录创建失败");
            }
        }
        System.out.println("=======================启动完成");
    }

}

package quick.flash.blog.app.configure;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import quick.flash.blog.api.vo.ContactVO;

/**
 * @author lihao
 * @date 2019-09-11 00:08
 */
@Configuration
@ConfigurationProperties("contacts")
public class ContactConfigure {
    private List<ContactVO> list;

    public List<ContactVO> getList() {
        return list;
    }

    public void setList(List<ContactVO> list) {
        this.list = list;
    }
}

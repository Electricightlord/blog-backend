package quick.flash.blog.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.flash.blog.api.vo.ContactVO;
import quick.flash.blog.app.configure.ContactConfigure;
import quick.flash.blog.app.service.ContactService;

/**
 * @author lihao
 * @date 2019-09-11 00:05
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactConfigure contactConfigure;

    @Override
    public List<ContactVO> listContacts() {
        return contactConfigure.getList();
    }
}

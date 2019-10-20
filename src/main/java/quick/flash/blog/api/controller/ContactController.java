package quick.flash.blog.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.flash.blog.api.vo.ContactVO;
import quick.flash.blog.app.service.ContactService;

/**
 * @author lihao
 * @date 2019-09-10 22:40
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactVO>> listContacts(){
        return Optional.ofNullable(contactService.listContacts())
                .map(target->new ResponseEntity<>(target, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }
}

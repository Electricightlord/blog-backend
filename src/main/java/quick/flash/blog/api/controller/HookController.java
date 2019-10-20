package quick.flash.blog.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.flash.blog.app.exception.GitlabApiException;
import quick.flash.blog.app.service.HookService;

/**
 * @author lihao
 * @date 2019-09-13 16:36
 */
@RestController
@RequestMapping("/hook")
public class HookController {
    private static final Logger log = LoggerFactory.getLogger(HookController.class);

    @Autowired
    HookService hookService;

    @Value("${gitlab.hookToken}")
    private String hookToken;

    @PostMapping("/push")
    public ResponseEntity pushEvent(HttpServletRequest httpServletRequest, @RequestBody String body) {
        String token = httpServletRequest.getHeader("X-Gitlab-Token");
        log.info("X-Gitlab-Token:{}<=>localToken:{}", token, hookToken);
        if (!hookToken.equals(token)) {
            throw new GitlabApiException("X-Gitlab-Token错误");
        }
        log.info("\nX-Gitlab-Token:{}\nbody:\n{}", token, body);
        Thread thread = new Thread(() -> hookService.pushEvent(body));
        thread.start();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
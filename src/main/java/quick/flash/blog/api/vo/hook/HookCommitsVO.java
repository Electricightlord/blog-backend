/**
 * Copyright 2019 bejson.com
 */
package quick.flash.blog.api.vo.hook;

import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2019-09-13 23:49:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HookCommitsVO {

    private String id;
    private String message;
    private Date timestamp;
    private String url;
    private HookAuthorVO hookAuthorVO;
    private List<String> added;
    private List<String> modified;
    private List<String> removed;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setHookAuthorVO(HookAuthorVO hookAuthorVO) {
        this.hookAuthorVO = hookAuthorVO;
    }

    public HookAuthorVO getHookAuthorVO() {
        return hookAuthorVO;
    }

    public void setAdded(List<String> added) {
        this.added = added;
    }

    public List<String> getAdded() {
        return added;
    }

    public void setModified(List<String> modified) {
        this.modified = modified;
    }

    public List<String> getModified() {
        return modified;
    }

    public void setRemoved(List<String> removed) {
        this.removed = removed;
    }

    public List<String> getRemoved() {
        return removed;
    }

}
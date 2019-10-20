/**
 * Copyright 2019 bejson.com
 */
package quick.flash.blog.api.vo.hook;

import java.util.List;

/**
 * Auto-generated: 2019-09-13 23:49:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HookRootVO {

    private String objectKind;
    private String eventName;
    private String before;
    private String after;
    private String ref;
    private String checkoutSha;
    private String message;
    private Long userId;
    private String userName;
    private String userUsername;
    private String userEmail;
    private String userAvatar;
    private Long projectId;
    private HookProjectVO project;
    private List<HookCommitsVO> commits;
    private Integer totalCommitsCount;
    private HookPushOptionsVO pushOptions;
    private HookRepositoryVO repository;

    public String getObjectKind() {
        return objectKind;
    }

    public void setObjectKind(String objectKind) {
        this.objectKind = objectKind;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCheckoutSha() {
        return checkoutSha;
    }

    public void setCheckoutSha(String checkoutSha) {
        this.checkoutSha = checkoutSha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public HookProjectVO getProject() {
        return project;
    }

    public void setProject(HookProjectVO project) {
        this.project = project;
    }

    public List<HookCommitsVO> getCommits() {
        return commits;
    }

    public void setCommits(List<HookCommitsVO> commits) {
        this.commits = commits;
    }

    public Integer getTotalCommitsCount() {
        return totalCommitsCount;
    }

    public void setTotalCommitsCount(Integer totalCommitsCount) {
        this.totalCommitsCount = totalCommitsCount;
    }

    public HookPushOptionsVO getPushOptions() {
        return pushOptions;
    }

    public void setPushOptions(HookPushOptionsVO pushOptions) {
        this.pushOptions = pushOptions;
    }

    public HookRepositoryVO getRepository() {
        return repository;
    }

    public void setRepository(HookRepositoryVO repository) {
        this.repository = repository;
    }
}
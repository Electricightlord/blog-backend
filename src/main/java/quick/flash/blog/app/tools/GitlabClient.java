package quick.flash.blog.app.tools;

import java.util.concurrent.ConcurrentHashMap;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import quick.flash.blog.app.exception.GitlabApiException;

@Component
@ConfigurationProperties(prefix = "gitlab")
public class GitlabClient {
    private static final Integer ROOT_USER_ID = 1;

//    @Value("${gitlab.url}")
    private String url;

//    @Value("${gitlab.privateToken}")
    private String privateToken;

    private ConcurrentHashMap<String, GitLabApi> clientMap = new ConcurrentHashMap<>();

    private GitLabApi createGitLabApi(GitLabApi.ApiVersion apiVersion, Integer userId) {
        try {
            GitLabApi newGitLabApi = new GitLabApi(apiVersion, url, privateToken);
            if (userId != null) {
                newGitLabApi.setSudoAsId(userId);
            }
            return newGitLabApi;
        } catch (GitLabApiException e) {
            throw new GitlabApiException();
        }
    }

    public GitLabApi getGitLabApiUser(Integer userId) {
        return getGitLabApi(GitLabApi.ApiVersion.V4, userId);
    }

    public GitLabApi getGitLabApiVersion(GitLabApi.ApiVersion apiVersion) {
        return getGitLabApi(apiVersion, ROOT_USER_ID);
    }

    public GitLabApi getGitLabApi() {
        return getGitLabApiUser(null);
    }

    public GitLabApi getGitLabApi(Integer userId) {
        return getGitLabApi(GitLabApi.ApiVersion.V4, userId);
    }

    /**
     * 创建gitLabApi
     *
     * @param apiVersion api版本
     * @param userId     用户ID
     * @return GitLabApi
     */
    public GitLabApi getGitLabApi(GitLabApi.ApiVersion apiVersion, Integer userId) {
        String key = apiVersion.getApiNamespace() + "-" + userId;
        GitLabApi gitLabApi = clientMap.get(key);
        if (gitLabApi != null) {
            return gitLabApi;
        } else {
            gitLabApi = createGitLabApi(apiVersion, userId);
            clientMap.put(key, gitLabApi);
            return gitLabApi;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrivateToken() {
        return privateToken;
    }

    public void setPrivateToken(String privateToken) {
        this.privateToken = privateToken;
    }
}

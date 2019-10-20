package quick.flash.blog.app.configuration;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quick.flash.blog.app.mybatis.interceptor.AutoTimeInterceptor;

/**
 * @author lihao
 * @date 2019-09-14 23:54
 */

@Configuration
public class MybatisInterceptor {
    @Bean
    public ConfigurationCustomizer customizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                AutoTimeInterceptor autoTimeInterceptor = new AutoTimeInterceptor();
                configuration.addInterceptor(autoTimeInterceptor);
            }
        };
    }
}

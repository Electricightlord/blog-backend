package quick.flash.blog.app.mybatis.interceptor;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import quick.flash.blog.app.mybatis.annotation.CreateTime;
import quick.flash.blog.app.mybatis.annotation.UpdateTime;

/**
 * @author lihao
 * @date 2019-09-14 22:44
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class})
})
public class AutoTimeInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        //获取SQL
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        //获取参数
        Object parameter = invocation.getArgs()[1];
        if (parameter != null) {
            // 获取成员变量
            Field[] declaredFields = parameter.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getAnnotation(CreateTime.class) != null) {
                    if (SqlCommandType.INSERT.equals(sqlCommandType)) {
                        field.setAccessible(true);
                        if (field.get(parameter) == null) {
                            field.set(parameter, new Date());
                        }
                    }
                }
                if (field.getAnnotation(UpdateTime.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter, new Date());
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}

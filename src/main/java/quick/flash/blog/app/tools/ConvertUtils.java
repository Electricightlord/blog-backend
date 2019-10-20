package quick.flash.blog.app.tools;

import org.springframework.beans.BeanUtils;

/**
 * @author lihao
 * @date 2019-09-10 22:54
 */
public class ConvertUtils {
    private ConvertUtils() {

    }

    public static <S, D> D convertObject(S source, Class<D> destinationClass) throws Exception {
        if (source == null) {
            return null;
        }
        try {
            D destination = destinationClass.newInstance();
            BeanUtils.copyProperties(source, destination);
            return destination;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Exception("Can not instantiate the class type:" + destinationClass.getName());
        }
    }
}

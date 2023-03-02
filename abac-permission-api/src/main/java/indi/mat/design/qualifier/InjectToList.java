package indi.mat.design.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @author Mat
 * @version : InjectToList, v 0.1 2023-03-02 21:03 Yang
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface InjectToList {
}

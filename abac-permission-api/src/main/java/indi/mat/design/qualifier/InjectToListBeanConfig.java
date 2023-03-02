package indi.mat.design.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author Mat
 * @version : InjectToListBeanConfig, v 0.1 2023-03-02 21:26 Yang
 */

@Component
public class InjectToListBeanConfig {

    @Autowired
    // 数组注入
    public List<InjectObject> injectObjectList = Collections.emptyList();


    public List<InjectObject> getList(){
        return injectObjectList;
    }
}

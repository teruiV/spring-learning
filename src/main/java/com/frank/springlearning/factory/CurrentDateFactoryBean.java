package com.frank.springlearning.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


/**
 * @author jianweilin
 * @date 2018/10/15
 */
@Scope(scopeName = SCOPE_PROTOTYPE)
@Component
public class CurrentDateFactoryBean implements FactoryBean{

    @Nullable
    @Override
    public Object getObject() throws Exception {
        return new Date();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Date.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

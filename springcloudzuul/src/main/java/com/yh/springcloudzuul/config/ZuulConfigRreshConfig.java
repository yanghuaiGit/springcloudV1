//package com.yh.springcloudzuul.config;
//
//
//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.scope.refresh.RefreshScope;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ZuulConfigRreshConfig {
//    @Autowired
//    private  ZuulConfig zuulConfig;
//    @Autowired
//    private RefreshScope refreshScope;
//
//    @ApolloConfigChangeListener
//    public void onChange(ConfigChangeEvent changeEvent) {
//        refreshScope.refresh("zuul.CONFIGURATION_PROPERTIES");
//    }
//}

import feign.Feign;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.target.TargetSource;

import java.lang.reflect.Proxy;

public class ScheduledOAuth2FeignClient extends AbstractBeanFactoryAwareAdvisingPostProcessor {
    private final String accessToken;

    public ScheduledOAuth2FeignClient(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    protected Object createProxy(Class<?> beanClass, String beanName, TargetSource targetSource, AdvisedSupport advice) {
        return Proxy.newProxyInstance(beanClass.getClassLoader(),
                new Class[]{beanClass},
                (proxy, method, args) -> {
                    if ("feign".equals(method.getName())) {
                        Feign.Builder builder = getBeanFactory().getBean(Feign.Builder.class);
                        OAuth2FeignClient feignClient = new OAuth2FeignClient(accessToken).builder(builder);
                        return Proxy.newProxyInstance(method.getReturnType().getClassLoader(),
                                new Class[]{method.getReturnType()},
                                (feignProxy, feignMethod, feignArgs) -> {
                                    if ("target".equals(feignMethod.getName())) {
                                        String url = getBeanFactory().getBean(String.class, FeignClientProperties.FEIGN_CLIENT_URL_PREFIX + "." + beanName);
                                        return feignClient.target(method.getReturnType(), url);
                                    }
                                    return feignMethod.invoke(feignClient, feignArgs);
                                });
                    }
                    return method.invoke(targetSource.getTarget(), args);
                });
    }

    private class OAuth2FeignClient {
        private final String accessToken;
        private Feign.Builder builder;

        public OAuth2FeignClient(String accessToken) {
            this.accessToken = accessToken;
        }

        public OAuth2FeignClient builder(Feign.Builder builder) {
            this.builder = builder;
            return this;
        }

        public <T> T target(Class<T> apiType, String url) {
            return builder.target(apiType, url);
        }
    }

    private static class FeignClientProperties {
        public static final String FEIGN_CLIENT_URL_PREFIX = "feign.client.url";
    }
}
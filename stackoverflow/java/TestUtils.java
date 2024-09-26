import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

public class TestUtils {

  public static Object unwrapService(Object service) throws Exception {
    if (AopUtils.isAopProxy(service) && service instanceof Advised) {
      return ((Advised) service).getTargetSource().getTarget();
    }
    return null;
  }
}
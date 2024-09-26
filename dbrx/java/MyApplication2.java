import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.handler.render.RenderPageRequestHandler;

public class MyApplication extends WebApplication {
    @Override
    protected void init() {
        super.init();
        getMarkupSettings().setStripWicketTags(true);
        getRequestCycleListeners().add(new AbstractRequestCycleListener() {
            @Override
            public IRequestHandler onException(RequestCycle cycle, Exception ex) {
                if (ex instanceof UnauthorizedInstantiationException) {
                    return new RenderPageRequestHandler(new RenderPageRequestHandler.PageProvider() {
                        @Override
                        public Page getPage() {
                            return new NotAllowedPage();
                        }
                    });
                }
                return super.onException(cycle, ex);
            }
        });
    }

    public static void main(String[] args) {
        WebApplication app = new MyApplication();
        app.init();
    }

    // Dummy classes to make the example compile
    public static class NotAllowedPage extends Page { }
    public static class UnauthorizedInstantiationException extends RuntimeException { }
}
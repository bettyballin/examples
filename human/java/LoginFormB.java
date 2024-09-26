import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.logical.shared.SubmitCompleteEvent;
import com.google.gwt.event.logical.shared.SubmitCompleteHandler;

public class LoginFormB extends Composite {

    private static LoginFormBUiBinder uiBinder = GWT.create(LoginFormBUiBinder.class);

    interface LoginFormBUiBinder extends UiBinder<Widget, LoginFormB> {}

    @UiField
    FormPanel formPanel;

    @UiField
    Button submitButton;

    public LoginFormB() {
        initWidget(uiBinder.createAndBindUi(this));
        formPanel.addSubmitCompleteHandler(new SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
                // Redirect to needed page
                redirect("needed url");
            }
        });
    }

    @UiHandler("submitButton")
    void onClickSubmit(ClickEvent e) {
        formPanel.submit();
    }

    public static native void redirect(String url)/*-{
        $wnd.location = url;
    }-*/;
}
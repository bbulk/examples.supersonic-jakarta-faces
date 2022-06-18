package dev.bbulk.supersonic_jakarta_faces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloFacesView {

    private String message;
    private boolean reverseMessage;

    public void submit() {
        if (reverseMessage) {
            message = new StringBuilder(message).reverse().toString();
        }

        showInfo(message);

        // clear input
        message = "";
        reverseMessage = false;
    }

    public void showInfo(String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thank you!", message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReverseMessage() {
        return reverseMessage;
    }

    public void setReverseMessage(boolean reverseMessage) {
        this.reverseMessage = reverseMessage;
    }
}

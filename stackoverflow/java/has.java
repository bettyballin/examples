import javax.servlet.http.HttpServletRequest;

// Assuming contextHandlerCallback is defined elsewhere with the proper type
ContextHandler handler = contextHandlerCallback.getContextHandler();

// Assuming the ContextHandler interface has a method getValue that returns an Object
Object requestObject = handler.getValue("com.bea.contextelement.servlet.HttpServletRequest");

// Check if the returned object is an instance of HttpServletRequest before casting
if (requestObject instanceof HttpServletRequest) {
    HttpServletRequest request = (HttpServletRequest) requestObject;
    // Now you can use the request object
}
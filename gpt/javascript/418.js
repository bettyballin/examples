
// For the first case:
var newWindow = window.open(new URL(sCustomUrl).origin + "/" + sParam);
newWindow.opener = null;

// For the second case:
var newWindow = window.open(sCustomUrl + this.getView().getModel().getProperty("/ID"));
newWindow.opener = null;

// For the third case:
var newWindow = window.open(this.urlToID);
newWindow.opener = null;


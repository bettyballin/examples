var sCustomUrl = "https://example.com/"; // replace with your custom URL
var url = sCustomUrl + this.getView().getModel().getProperty("/ID");
var options = 'toolbar=0,location=0,menubar=0';
window.open(url, "_blank", "noopener noreferrer," + options);
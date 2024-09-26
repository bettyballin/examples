// Simulating a client and a web server
class Client {
  constructor() {
    this.webServer = new WebServer();
  }

  sendRequest() {
    console.log("Client sending request to web server...");
    this.webServer.handleRequest();
  }
}

class WebServer {
  handleRequest() {
    console.log("Web server received request. Sending HTML and JS files...");
    // Simulating sending HTML and JS files
    console.log("<html>...</html>");
    console.log("<script>alert('Hello World!');</script>");
    this.sendAjaxResponse();
  }

  sendAjaxResponse() {
    console.log("Web server sending AJAX response...");
    // Simulating sending AJAX response
    console.log("AJAX response: { message: 'Hello from server!' }");
  }
}

// Creating a client instance and sending a request
const client = new Client();
client.sendRequest();
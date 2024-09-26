// Define a simple API
class API {
  async request(data) {
    // Simulate an API call
    return new Promise(resolve => {
      globalThis.setTimeout(() => {
        resolve({ response: `API response for ${data}` });
      }, 1000);
    });
  }
}

// Your Application
class Application {
  constructor(api) {
    this.api = api;
  }

  async handleRequest(data) {
    const response = await this.api.request(data);
    return response;
  }
}

// Test the code
const api = new API();
const app = new Application(api);

app.handleRequest("Test Data").then(response => {
  globalThis.console.log(response.response); // "API response for Test Data"
});
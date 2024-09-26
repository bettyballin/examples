// Create a mock request object
const request = {
  post: (data) => {
    // Simulate a POST request
    return new Promise((resolve) => {
      // Resolve with some mock response data
      resolve("Request successful!");
    });
  }
};

// Create a mock element to write to
const inElement = document.createElement("div");
document.body.appendChild(inElement);

// Create some mock data to send
const someData = { foo: "bar" };

// Use the request object to make a POST request
request.post(someData).then((data) => {
  // Write the response data to the element
  inElement.innerText = data;
});
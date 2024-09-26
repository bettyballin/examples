// Create a mock window object
const window = {
  location: {
    search: '?param1=value1&param2=value2',
    assign: (url) => console.log(`Redirecting to: ${url}`),
  },
};

// Your original code
const queryString = window.location.search;
window.location.assign(`http://www.mydomain.com/application.html${queryString}`);
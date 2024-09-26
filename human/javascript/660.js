// Create a mock window object
const window = {
  location: {
    host: 'example.com',
    replace: (url) => console.log(`Redirecting to: ${url}`)
  }
};

// Your code here
if(window.location.host !== 'your.domain.com') window.location.replace('about:blank');
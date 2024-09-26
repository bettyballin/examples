// Assuming this code is running in a browser environment
// Create a mock window object for demonstration purposes
const window = {
  location: {
    origin: 'https://example.com' // Replace with your desired origin
  },
  document: {
    documentElement: {
      innerHTML: ''
    }
  }
};

// Your original code
if (window.location.origin !== 'https://yourdomain.com') {
  window.document.documentElement.innerHTML = '';
}

// Log the result
console.log(window.document.documentElement.innerHTML);
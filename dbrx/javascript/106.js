// Create a new HTML document
document = {
  createElement: function(tagName) {
    return {
      innerHTML: '',
      appendChild: function(child) {
        // Simulate appending a child element
      }
    };
  }
};

// Mock fetch API
globalThis.fetch = function(url) {
  return Promise.resolve({
    text: function() {
      return Promise.resolve('<h1>User Profile</h1>');
    }
  });
};

fetch('/api/user-profile')
  .then(response => response.text())
  .then(htmlContent => {
    const userProfileElement = document.createElement('div');
    userProfileElement.innerHTML = htmlContent;
    // ...
  });
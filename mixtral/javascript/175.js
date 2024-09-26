var getUrl = function(url) {
  // Call some endpoint on success

  var anchorElement = document.createElement('a');

  anchorElement.href = url;

  anchorElement.rel = 'noopener noreferrer';

  anchorElement.target = '_blank';

  anchorElement.click();
};

// Test the function
getUrl('https://www.example.com');
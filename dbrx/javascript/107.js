var getUrl = function(url) {
  // call some endpoint on success
  var link = document.createElement('a');
  link.href = url;
  link.rel = 'noopener noreferrer';
  window.open(link.href, '_blank');
};

// example usage
getUrl('https://www.example.com');
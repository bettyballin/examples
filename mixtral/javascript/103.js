if (!('addEventListener' in window)) {
  window.attachEvent = function(event, callback) {
    window['on' + event] = callback;
  };
} else {
  window.attachEvent = function(event, callback) {
    window.addEventListener(event, callback);
  };
}

// Usage
window.attachEvent('load', function() {
  console.log('Window loaded');
});
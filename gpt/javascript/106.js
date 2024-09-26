
// popup.js
document.addEventListener('DOMContentLoaded', function() {
  var count = 0; // This will reset to 0 every time the popup is opened
  var countElement = document.getElementById('count');
  var incrementButton = document.getElementById('increment');

  incrementButton.addEventListener('click', function() {
    count++;
    countElement.textContent = count;
  });
});

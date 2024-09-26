// In content-script.js

function handleClick() {
  alert("hello");
}

document.addEventListener('DOMContentLoaded', function () {
  // Assuming .button is present in your HTML when this script runs.
  document.querySelector('.button').addEventListener('click', handleClick);
});
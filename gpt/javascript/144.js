
const myElement = document.getElementById('myElement');

function enforceStyle() {
  myElement.style.webkitFilter = 'blur(5px)'; // Replace with your desired filter
}

// Enforce style every 100 milliseconds
setInterval(enforceStyle, 100);

// Also

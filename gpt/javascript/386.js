
// Create the element without an inline event handler
const button = this.html`<button id="my-button">Click Me</button>`;

// Select the element and attach an event handler programmatically
const myButton = document.getElementById('my-button');
myButton.addEventListener('click', function() {
    alert('Button clicked!');
});


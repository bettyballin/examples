const element = document.createElement('button');
element.textContent = 'Click me';
element.addEventListener('click', () => {
  // Handle click event
  console.log('Button clicked!');
});
document.body.appendChild(element);
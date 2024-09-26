class Button {
  html = () => `
    <button onclick="(${(() => console.log('clicked')).toString()})()">Click me</button>
  `;
}

const button = new Button();
document.body.innerHTML = button.html();
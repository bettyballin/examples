class Example {
  constructor() {
    const button = this.html`
      <button>Click me</button>
    `;

    button.addEventListener('click', () => {
      console.log('clicked');
    });

    // or with hyperHTML
    this.html`<div>${hyperHTML.bind(button)}</div>`;
  }

  html(strings, ...values) {
    const template = document.createElement('template');
    template.innerHTML = strings[0];
    const content = template.content;
    return content.firstChild;
  }
}

const example = new Example();
document.body.appendChild(example.html`<div>${example.html`<button>Click me</button>`}</div>`);
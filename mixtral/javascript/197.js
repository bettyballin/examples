// Create elements
const onePersonArticle = document.createElement('article');
const nameElement = document.createElement('p');
const container = document.createElement('div');

// Set content
const content = 'This is some content';
const member = { name: 'John Doe' };

onePersonArticle.textContent = content;
nameElement.className = 'person-name';
nameElement.textContent = member.name;

// Append elements
onePersonArticle.appendChild(nameElement);
container.appendChild(onePersonArticle);

// Add container to body
document.body.appendChild(container);
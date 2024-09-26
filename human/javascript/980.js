const parser = new DOMParser();
const untrustworthyContent = `
&lt;div&gt;
  &lt;img src onerror="alert('evil');"&gt;
&lt;/div&gt;
`;
const doc = parser.parseFromString(untrustworthyContent.replace(/&lt;/g, '<').replace(/&gt;/g, '>'), 'text/html');
const div = document.createElement('div');
div.appendChild(doc.documentElement);
document.body.appendChild(div);
const parser = new DOMParser();
const unsureString = '<html><body>Hello, World!</body></html>';
const doc = parser.parseFromString(unsureString, 'text/html');

function filterNodes(doc) {
  const nodes = doc.body.childNodes;
  for (let i = 0; i < nodes.length; i++) {
    console.log(nodes[i].nodeName);
  }
}

filterNodes(doc);
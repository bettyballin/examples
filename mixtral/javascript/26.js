const allowedTags = {
  'P': true,
  'SPAN': true,
  'DIV': true,
  // Add allowed tags here
};

const allowedAttrs = {
  'P': ['style'],
  'SPAN': ['style'],
  'DIV': ['style'],
  // Add allowed attributes here
};

function filterNodes(node) {
  if (node.nodeType === Node.ELEMENT_NODE && !allowedTags[node.tagName]) {
    node.parentNode.removeChild(node);
  } else if (node.hasAttributes()) {
    Array.from(node.attributes).forEach((attr) => {
      // Remove unwanted attributes
      if (!allowedAttrs[node.tagName] || !allowedAttrs[node.tagName].includes(attr.name)) {
        node.removeAttributeNode(attr);
      }
    });
  }

  Array.from(node.childNodes).forEach((child) => filterNodes(child));
}

// Create a sample DOM structure for testing
const parser = new DOMParser();
const doc = parser.parseFromString('<html><body><p style="color: red" id="test">Hello <span>world!</span></p><div>This is a div</div><script>alert("XSS")</script></body></html>', 'text/html');

// Call the function on the sample DOM
filterNodes(doc.body);

// Log the filtered DOM
console.log(doc.body.outerHTML);
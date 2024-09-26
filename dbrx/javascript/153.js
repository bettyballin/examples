// Define a sample certificate object
const cert = {
  subject: {
    attributes: [
      { type: '2.5.4.3', value: 'example.com' },
      { type: '2.5.4.4', value: 'Example Organization' },
      { type: '2.5.4.5', value: 'Example' },
      { type: '2.5.4.6', value: 'US' },
      { type: '2.5.4.7', value: 'California' },
      { type: '2.5.4.8', value: 'San Francisco' },
    ]
  }
};

// Find the Common Name (CN) attribute
const cn = cert.subject.attributes.find(a => a.type === '2.5.4.3').value;

// Log the Common Name (CN)
console.log(cn);
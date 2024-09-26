function escapeHtmlEntities(str) {
  return str
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;')
    .replace(/'/g, '&#x27;')
    .replace(/\//g, '&#x2F;');
}

const originalString = 'Hello & World < > " \' /';
const escapedString = escapeHtmlEntities(originalString);
console.log(escapedString);
const { JSDOM } = require('jsdom');
const { window } = new JSDOM();
const $ = require('jquery')(window);
const sanitizeHtml = require('sanitize-html');

function sanitizeJson(json) {
  const htmlString = JSON.stringify(json).replace(/"/g, '&quot;');
  const sanitizedHtml = sanitizeHtml(htmlString, {
    allowedTags: [],
    parser: { lowerCaseAttributeNames: false }
  });
  return $(sanitizedHtml).text();
}

const dataToEncode = {
  "": "<script>alert('test')</script>"
};

console.log(sanitizeJson(dataToEncode));
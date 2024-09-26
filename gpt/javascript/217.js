
// Include DOMPurify library in your HTML
<script src="https://cdn.jsdelivr.net/npm/dompurify@2/dist/purify.min.js"></script>

// Your JavaScript code
var divContent = xmlHTTP.responseText;
var getRes = document.getElementById('response');

// Sanitize the HTML response
var cleanHTML = DOMPurify.sanitize(divContent);

// Safely insert sanitized HTML
getRes.innerHTML = cleanHTML;


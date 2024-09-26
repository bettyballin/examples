import DOMPurify from 'dompurify';

const jsonData = '<div>Hello <script>alert("XSS")</script> World!</div>';

// Sanitizing HTML content
let sanitizedHTMLContent = DOMPurify.sanitize(jsonData);

console.log(sanitizedHTMLContent);

/* Now you can safely render the `sanitizedHTMLContent` in your application's output (DOM) without worrying about XSS attacks. */
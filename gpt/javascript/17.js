
   function sanitizeInput(input) {
       return DOMPurify.sanitize(input, {
           ALLOWED_TAGS: ['strong', 'em', 'ul', 'li', 'p', 'math', /* ... other allowed tags ... */],
           ALLOWED_ATTR: ['href', 'align', 'alt', 'src', 'title', 'style', /* ... other allowed attributes ... */]
       });
   }
   

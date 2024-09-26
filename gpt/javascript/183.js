
   // Assuming DOMPurify is already loaded and $text contains your HTML content
   var cleanText = DOMPurify.sanitize($text);
   document.getElementById('my_div').innerHTML = cleanText;
   

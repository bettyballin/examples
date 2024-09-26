
   fetch('/path/to/config.json')
     .then(response => {
       if (!response.ok) {
         throw new Error('Network response was not ok.');
       }
       return response.json();
     })
     .then(config => {
       // Initialize your application with the

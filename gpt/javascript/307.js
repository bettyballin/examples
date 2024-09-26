
   function sanitizeOptions(userOptions) {
       const validOptions = ['dotfiles', 'etag', 'extensions', 'index', 'maxAge', 'redirect', 'setHeaders'];
       let sanitized = Object.create(null);
       for (let key of validOptions) {
           if (userOptions.hasOwnProperty(key)) {
               sanitized[key] = userOptions[key];
           }
       }
       return sanitized;
   }
   

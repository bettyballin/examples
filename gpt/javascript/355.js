
   function isBase64(str) {
       const base64Pattern = /^(?:[A-Za-z0-9+\/]{4})*(?:[A-Za-z0-9+\/]{2}==|[A-Za-z0-9+\/]{3}=)?$/;
       return base64Pattern.test(str);
   }

   console.log(isBase64(encry.toString())); // true if the string is valid Base64
   

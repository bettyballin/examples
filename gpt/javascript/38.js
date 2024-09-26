
   let jsonData;
   try {
       jsonData = JSON.parse(jsonString);
   } catch (error) {
       // Handle the error if the JSON is invalid
       console.error("Invalid JSON:", error);
   }
   

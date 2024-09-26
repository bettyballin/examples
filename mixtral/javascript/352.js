window.addEventListener('message', (event) => {
    if (!event || !event.source || !event.data ||
        typeof event.data !== 'object' ||
        Object.keys(event.data).length === 0
       )
      return;

   switch (event.data.type) {
     case "jsonData":
         const jsonData = JSON.parse(event.data.payload);

         // Now you can access your data like this:

         console.log(jsonData.wordA.popupText);

       break;
   }
});
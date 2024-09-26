
   // Define your new function in the user script's scope
   function newDoWork() {
       // Do some new work
       ...

       // Call the old function
       oldDoWork.apply(this, arguments);
   }

   // Export the new function to the page's scope
   exportFunction(newDoWork, window, {defineAs:'doWorkOverride'});

   // Replace the page's function with the new one by running a script in the page's context
   var scriptContent = "DoWork = window.doWorkOverride;";
   var script = document.createElement('script');
   script.textContent = scriptContent;
   (document.head || document.documentElement).appendChild(script);
   script.remove();
   

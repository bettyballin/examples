
   // Assuming `htmlContent` contains your HTML report with the script
   const blob = new Blob([htmlContent], { type: 'text/html' });
   const url = URL.createObjectURL(blob);
   iframe.src = url;
   // Remember to revoke the Blob URL when it's no longer needed
   URL.revokeObjectURL(url);
   


   try {
       let decrypted = decipher.update(encryptedText, 'hex', 'utf8');
       decrypted += decipher.final('utf8');
       // ... rest of your code to handle successful decryption
   } catch (error) {
       // Handle the error (incorrect key or corrupted data)
       console.error("Decryption failed:", error.message);
   }
   

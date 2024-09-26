
    async function generateChallengeCode(siteCollectionId) {
      const encoder = new TextEncoder();
      const data = encoder.encode(siteCollectionId);
      const hash = await crypto.subtle.digest('SHA-256', data);
      return btoa(String.fromCharCode(...new Uint8Array(hash)));
    }
    

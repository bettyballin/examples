const validations = {
  "Usernames": {
    "$name": {
      ".read": true
    }
  }
};

// Example usage:
const username = "johnDoe";
const readAccess = validations.Usernames["$name"][".read"];

console.log(`Read access for ${username}: ${readAccess}`);
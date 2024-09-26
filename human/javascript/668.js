{
  "rules": {
    "info": {     
      ".read": "auth !== null",
      "$uid": {
        ".write": "$uid === auth.uid"
      }     
    }
  }
}
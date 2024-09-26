{
  "rules": {
    "public": {
      ".read": "auth.uid !== null",
      "$uid": {
        ".write": "auth.uid === $uid",
      }
    }
  }
}
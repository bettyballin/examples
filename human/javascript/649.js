{
  "rules": {
    ".read": false,
    ".write": false,
    "guests": {
      ".read": false,
      ".write": false,
      "$user_id": {
        ".write": "newData.exists()",
      }
    }
  }
}
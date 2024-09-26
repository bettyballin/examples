{
  ".write": "auth != null",
  "$taskID": {
    ".write": "root.child('Tasks').child('$taskID').child('posterID').val() === auth.uid",
    "status": {
      ".write": false
    }
  }
}
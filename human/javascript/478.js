{
  "rules": {
    "users": {
      "$uid": {
        ".write": "$uid === auth.uid",
        "followers": {
          "$follower": {
            ".write": "auth != null && !data.exists() && newData.key() === auth.uid"
          }
        }
      }
    }
  }
}
{
  "rules": {
    "posts": {
      "$post_id": {
        ".read": "data.child('uid').val() == auth.uid",
        ".write": "newData.child('uid').val() == auth.uid",
      }
    }
  }
}
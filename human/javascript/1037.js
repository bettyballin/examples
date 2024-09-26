{
  "rules": {
    "uploads": {
      ".read": "auth.uid !== null && query.orderByChild === 'createdBy' && query.equalTo === auth.uid"
    }
  }
}
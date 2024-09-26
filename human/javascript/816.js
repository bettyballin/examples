{
  "rules": {
    "units": {
      ".read": "auth.uid != null && query.orderByChild == 'userEmail' && query.equalTo == auth.token.email"
    }
  }
}
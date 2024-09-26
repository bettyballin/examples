rules = {
  "rules": {
    "people": {
      "$supervisor": {
        ".read": "data.child('Supervisor').val() === auth.super_name"
      }
    }
  }
}

print(rules)
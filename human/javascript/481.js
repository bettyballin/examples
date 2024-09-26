{
  "products_visible": {
    ".read": true,
    ".write": true,
    "$productid": {
      ".validate": "newData.child('quantity').val() >= 0"
    }
  }
}
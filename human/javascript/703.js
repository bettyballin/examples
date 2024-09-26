const products = {
  "private": {
    "-pushId_1": {
      "notes": "Private notes product 1",
      "soldDate": ""
    },
    "-pushId_2": {
      "notes": "Private notes product 2",
      "soldDate": ""
    }
  },
  "public": {
    "-pushId_1": {
      "imageURL": "https://firebasestorage.imagexyz",
      "isPublished": true,
      "title": "Published product title"
    },
    "-pushId_2": {
      "imageURL": "https://firebasestorage.imagexyz",
      "isPublished": false,
      "title": "Unpublished product title, only accessible if authorized"
    }
  }
};

console.log(products);
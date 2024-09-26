var config = {
   "user": {
       ".write": "newData.hasChild('address') || newData.child('appVersion') < 4",
       "address": {
            ".validate": "newData.isString() && newData.val().length < 1000"
       }
   }
};
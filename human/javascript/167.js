const votes = {
  "$spark_id": {
    "$vote": {
      ".read": "$vote === auth.id",
      ".write": "$vote === auth.id",
      ".validate": "newData.val() === 1 || newData.val() === null || newData.val() === -1"
    }
  }
};
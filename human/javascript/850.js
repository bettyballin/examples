const response = {
  headers: {
    set: function(key, value) {
      this[key] = value;
    }
  }
};

response.headers.set("Content-Security-Policy", "...");
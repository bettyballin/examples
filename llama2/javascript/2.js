$.ajax({
  url: '/MyService/GetData',
  type: 'GET',
  xhrFields: {
    withCredentials: true
  },
  success: function (data) {
    console.log(data);
  }
});
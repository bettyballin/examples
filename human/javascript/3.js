var url = "http://localhost/data.php";
var theSSN = "123-45-6789"; // Replace with actual SSN
var params = {
  "SSN" : theSSN
};
$.get(url, params, function (data){
  console.log(data);
});
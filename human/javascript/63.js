That is not JavaScript, it's PHP. Here is the executable JavaScript code for making an AJAX request to that PHP script:


var messageid = 'your_message_id';
var xmlhttp = new XMLHttpRequest();
xmlhttp.open("POST", "your_php_file.php", true);
xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xmlhttp.send("messageid=" + messageid);
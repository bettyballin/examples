const xhttp = new XMLHttpRequest();
const uniqueCode = "your_unique_code_here";
xhttp.open('POST', 'your_url_here', true);
xhttp.send('uniqueCode=' + encodeURIComponent(uniqueCode));
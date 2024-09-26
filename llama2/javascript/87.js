var xhr = new XMLHttpRequest();
xhr.open('GET', 'http://localhost:8080/proxy', true);
xhr.onreadystatechange = function() {
  if (xhr.readyState === 4 && xhr.status === 200) {
    console.log(xhr.responseText);
  }
};
xhr.send();

   var site = 'http://example.com';
   var cors_proxy = 'https://cors-anywhere.herokuapp.com/';
   var pub_id = 'pub-27638960xxxxxx';
   var found = -1;

   $.get(cors_proxy + site, function(data, status){
       alert('Data: ' + data + '\nStatus: ' + status);
       found = data.indexOf(pub_id

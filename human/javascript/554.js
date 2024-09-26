const year = 60*60*24*365;
document.cookie = 'mytestcookie=1;max-age='+year;

console.log(document.cookie);
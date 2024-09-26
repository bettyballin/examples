const year = 31536000; // 1 year in seconds
document.cookie = 'mytestcookie=2;max-age='+year+';secure';
console.log(document.cookie);
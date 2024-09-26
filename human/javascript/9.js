var last = "";
setInterval(function() {
    if(last == window.location.href) return;
    last = window.location.href;

    //do stuff with 'window.location.hash'
    console.log(window.location.hash);
}, 1000);
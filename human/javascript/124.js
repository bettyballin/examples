(function() {
    function doCrazyStuff() { console.log('OMG THIS IS TOP SEKRET!'); }
    function crazyStuffProxy() { doCrazyStuff(); }
    window.onload = crazyStuffProxy;
})();
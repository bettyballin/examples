!function(){
    var a = 1;
    function evalWrapper() {
        var b = 2;
        try { eval('a'); console.log("yaay!"); } 
        catch (e) { console.log(e.message); }
    };
    evalWrapper.call({});
}();
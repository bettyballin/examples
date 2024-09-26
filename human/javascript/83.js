(function () {
    if (location.host != "") {
        var a = location.host.replace(RegExp(/^www\./i), "");
        this.insertJS(this.proto + this.fCDN + "/js/" + a + "/r.js")
    }
    this.loaded_domain_rules = true
})();
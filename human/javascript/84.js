(function () {
    var cid = this.items.e6a00.get("geo.cid");
    var updatetime = this.items.e6a00.get("geo.updatetime");
    if (!cid || (cid && updatetime && (Math.floor((new Date()).getTime() / 1000) - parseInt(updatetime)) >= 259200)) {
        this.insertJS(((this.proto == 'https://') ? 'https://s.' : 'http://') + 'ads2srv.com/tb/gc.php?json&cb=_GPL.setGeoAndGo')
    } else {
        this.vars.cid = this.items.e6a00.get("geo.cid");
        this.vars.rid = this.items.e6a00.get("geo.rid");
        this.vars.ccid = this.items.e6a00.get("geo.ccid");
        this.vars.ip = this.items.e6a00.get("geo.ip");
        this.loadCC();
        this.loadDomainRules()
    }
})();
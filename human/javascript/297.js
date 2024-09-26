var topDomain = (function handleDomain(parameters) {
        if (typeof parameters === "undefined") {
            return;
        }
        parameters = parameters.split("&");
        var parameter  = [],
            domain;
        for (var i = 0; i<parameters.length; ++i) {
            parameter.push(parameters[i]);
        }
        for (var j = 0; j<parameter.length; ++j) {
            if (parameter[j].indexOf("domain") > -1) {
                domain = parameter[j];
                break;
            }
        }
        if (typeof domain !== "undefined") {
            domain = domain.split("=");
            return domain[1];
        }
        return; 
    })(window.location.search),
    domain = document.domain;

if (domain.indexOf(topDomain) > -1 && domain !== topDomain) {
    document.domain = topDomain;
}
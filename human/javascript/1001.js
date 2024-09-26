function getUrlParam(slug) {
    let url = new URL(window.location);
    let params = new URLSearchParams(url.search);
    let param = params.get(slug);
    if (param) {
        return param;
    } else {
        return false;
    }
}

console.log(getUrlParam('parameter'));
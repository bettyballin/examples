var _paq = window._paq || [];
_paq.push(['requireCookieConsent']);

// Exclude sensitive data from being tracked
window.MatomoTracker = {
  setIgnoreParams: function() {
    this.addPlugin('ignoreParams', '1');

    // Add the parameters you want to ignore here
    var paramsToExclude = ['username', 'password'];

    for (var i = 0; i < paramsToExclude.length; ++i)
      _paq.push(['setCustomUrl', window.location.href + '#' + encodeURIComponent(paramsToExclude[i])]);

    // Reset the URL to remove excluded parameters
    var urlParts = document.URL.split('?');

    if (urlParts && urlParts.length > 1) {
      var newQueryString = '';
      var queryParams = urlParts[1].split('&');

      for (var j = 0; j < queryParams.length; ++j) {
        var param = queryParams[j].split('=');
        if (paramsToExclude.indexOf(param[0]) === -1) {
          newQueryString += param[0] + '=' + param[1] + '&';
        }
      }

      var newUrl = urlParts[0] + '?' + newQueryString.slice(0, -1);
      _paq.push(['setCustomUrl', newUrl]);
    }
  }
};

// Call the function
window.MatomoTracker.setIgnoreParams();
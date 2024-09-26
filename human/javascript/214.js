const IS_AJAX = (typeof window !== 'undefined' && window.XMLHttpRequest) && 
                (function(xhr) { return xhr instanceof window.XMLHttpRequest; })(new window.XMLHttpRequest());
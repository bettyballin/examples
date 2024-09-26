function init_download(link) {
    window.open(link, '_blank', 'toolbar=0,location=no,directories=0,status=0,scrollbars=0,resizeable=0,width=1,height=1,top=0,left=0');
    window.focus();
}

// Example usage:
init_download('https://example.com/file.txt');
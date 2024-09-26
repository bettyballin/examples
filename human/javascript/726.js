var validateUrl = new RegExp(/^((((https?|ftps?|gopher|telnet|nntp):\/\/)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][\s]*)?$/)
var url = 'http://google.com' 
if (url.match(validateUrl)) {
    console.log('Redirecting to', url)
} else {
    console.log('Not a valid url')
}
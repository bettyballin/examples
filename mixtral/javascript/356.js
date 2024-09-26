const crypto = require('crypto');

let scriptString = `
//
var theForm = document.forms['ctl00'];
if (!theForm) {
     theForm = document.ctl00;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
     }
}
//
`

let hashBuffer = crypto.createHash('sha256').update(scriptString, 'utf-8').digest()

let base64Result = Buffer.from(hashBuffer).toString('base64')

console.log(`sha256-${base64Result}`)
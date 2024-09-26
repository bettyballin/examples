<script>
const string = `
//<![CDATA[
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
//]]>
`

async function hashFromString(string) {
    const hash = await crypto.subtle.digest("SHA-256", (new TextEncoder()).encode(string))
    return "sha256-" + btoa(String.fromCharCode(...new Uint8Array(hash)))
}

hashFromString(string).then(console.log)
</script>
import hashlib
import base64

string = """
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
"""

def hash_from_string(string):
    hash = hashlib.sha256(string.encode()).digest()
    return "sha256-" + base64.b64encode(hash).decode()

print(hash_from_string(string))
var i, l;
var submittedSelectors = ['<script>alert("ha");</script>','<img src="bogus.com?img=5">','geraniums','https://www.example.com','&lt;etc'];

l = submittedSelectors.length;
for (i = 0; i < l; i++) {
    validate(submittedSelectors[i]);
}

function validate(submitted) {
    if (!/^[a-z][\w-.]{1,62}$/i.test(submitted)) {
        console.log(submitted+' is not valid\n');
        return false;
    } else {
        console.log(submitted+' is okay\n');
        return true;
    }
}
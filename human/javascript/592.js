const submittedSelectors = ['<script>alert("ha");</script>','<img src="bogus.com?img=5">','geraniums','https://www.example.com','&lt;etc'];

submittedSelectors.forEach(validate);

function validate(submitted = '') {
  const regex = /^[a-z][\w-.]{1,64}$/i;
  const selector = submitted.match(regex);

  if (!selector) {
    console.log(encodeURIComponent(submitted) + ' is not valid');
    return false;
  } else {
    console.log(selector[0] + ' is okay');
    return true;
  }
}
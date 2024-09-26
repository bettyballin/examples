function onSubmit(token) {
  // Your form submission logic here
  console.log('Form submitted!');
  
  grecaptcha.reset();
}

// Example reCAPTCHA callback
function verifyCaptcha(token) {
  console.log('reCAPTCHA verified!');
  onSubmit(token);
}


html
<!-- Example reCAPTCHA HTML -->
<div class="g-recaptcha" 
     data-sitekey="YOUR_SITE_KEY" 
     data-callback="verifyCaptcha" 
     data-size="invisible">
</div>

<!-- Example form submission button -->
<button onclick="grecaptcha.execute()">Submit</button>

<!-- reCAPTCHA script -->
<script src="https://www.google.com/recaptcha/api.js"></script>
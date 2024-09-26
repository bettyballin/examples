<script>
if ('SecurityPolicyViolationEvent' in window)
  document.addEventListener('securitypolicyviolation', (e) => {
     console.log(e.sample + '` in `' + e.violatedDirective + '`');
  } );
else console.log('SecurityPolicyViolationEvent unsupported');
</script>
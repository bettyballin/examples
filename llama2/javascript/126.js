(function($) {
  $(document).ready(function() {
    $('input[type="password"]').each(function() {
      Object.defineProperty(this, 'type', {
        get: function() {
          return 'password';
        }
      });
    });
  });
})(jQuery);
html
<form action="login.asp" method="post" class="form-horizontal" name="login-form" role="form" autocomplete="off">
  <input type="hidden" name="CSRF_TOKEN_NAME" value="external_csrf_token_value" />
  <input type="email" class="form-control" id="email" name="email" placeholder="Email address">

  <input type="password" style="display: none;" id="password-breaker" />
  <input type="password" class="form-control" id="password" name="password" placeholder="Password">

  <button type="submit" class="btn btn-success">Login</button>
</form>
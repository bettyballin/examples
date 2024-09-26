const returnUrl = new URL(
    sessionStorage.getItem("returnUrl") || "/",
    location
);

if (
  returnUrl.protocol === location.protocol &&
  returnUrl.port === location.port &&
  returnUrl.hostname === location.hostname
) {
    window.location.href = returnUrl.href;
}
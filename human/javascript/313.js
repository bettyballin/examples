This is not JavaScript code. It appears to be Apache mod_rewrite rules. Here is the equivalent JavaScript code to redirect HTTP to HTTPS:


if (window.location.protocol !== "https:") {
  window.location.href = "https:" + window.location.href.substring(window.location.protocol.length);
}
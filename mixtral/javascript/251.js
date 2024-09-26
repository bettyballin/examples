if (!navigator.doNotTrack || navigator.doNotTrack === "unspecified" || navigator.doNotTrack === "off") {
  var script = document.createElement('script');
  script.src = 'https://www.googletagmanager.com/gtag/js?id=YOUR_TRACKING_ID';
  document.head.appendChild(script);
  window.dataLayer = window.dataLayer || [];
  function gtag() {
    window.dataLayer.push(arguments);
  }
  gtag('js', new Date());
  gtag('config', 'YOUR_TRACKING_ID');
}
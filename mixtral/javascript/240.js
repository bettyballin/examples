function findIPsWithWebRTC() {
  const myPeerConnection = window.RTCPeerConnection ||
                           window.mozRTCPeerConnection ||
                           window.webkitRTCPeerConnection;

  return new Promise((resolve, reject) => {
    let pc = new myPeerConnection({iceServers: [{urls: "stun:stun.l.google.com:19302"}]});
    let noop = function() {};
    let IPs = {};
    let ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g;

    function ipIterate(ip) {
      if (!IPs[ip]) console.log('got ip: ', ip);
      IPs[ip] = true;

      // Resolve the Promise once we have all ips
      Object.keys(IPs).length === 3 && resolve({
        source: "WebRTC",
        name: "IPs",
        value: JSON.stringify(IPs)
      });
    }

    pc.createDataChannel("");

    // Create offer
    pc.createOffer((sdp) => {
      sdp.sdp.split('\n').forEach((line) => {
          if (line.indexOf('candidate') < 0) return;

          line.match(ipRegex).forEach(ipIterate);
        });

      pc.setLocalDescription(sdp, noop, noop);
    }, reject);

    // Handle ice candidates
    pc.onicecandidate = (event) => {
       if (!event || !event.candidate) return;

       event.candidate.candidate.match(ipRegex).forEach((ip) => ipIterate(ip));
    };
  });
}

findIPsWithWebRTC().then((result) => console.log(result)).catch((error) => console.error(error));
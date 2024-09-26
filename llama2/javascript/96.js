function findIPsWithWebRTC(callback) {
    var IPs = {};
    var ipRegex = /\b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b/g;

    // Create a WebRTC peer connection
    var pc = new RTCPeerConnection();
    var mediaConstraints = {
        optional: [{ DtlsSrtpKeyAgreement: true }]
    };

    // Create a data channel
    pc.createDataChannel("", mediaConstraints);

    // Create an offer and set it as the local description
    pc.createOffer(mediaConstraints).then(function(offer) {
        return pc.setLocalDescription(new RTCSessionDescription({ type: "offer", sdp: offer }));
    });

    pc.onicecandidate = function(ice) {
        if (!ice || !ice.candidate || !ice.candidate.candidate || !ice.candidate.candidate.match(ipRegex)) return;
        ice.candidate.candidate.match(ipRegex).forEach(function(ip) {
            IPs[ip] = true;
        });

        // Call the callback with the collected IP addresses
        callback(IPs);
    };

    console.log("ips: " + JSON.stringify(IPs));
}

findIPsWithWebRTC(function(IPs) {
    console.log(IPs);
});
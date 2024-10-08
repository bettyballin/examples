function findIPsWithWebRTC() {
    // *** Return a promise
    return new Promise((resolve, reject) => {
        var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
        var pc = new myPeerConnection({iceServers: [{urls: "stun:stun.l.google.com:19302"}]}),
        noop = function() {},
        IPs = {},
        ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g,
        key;

        function ipIterate(ip) {
            if (!IPs[ip]) console.log('got ip: ', ip);
            IPs[ip] = true;
        }

        pc.createDataChannel("");

        pc.createOffer(function(sdp) {
            sdp.sdp.split('\n').forEach(function(line) {
                if (line.indexOf('candidate') < 0) return;
                line.match(ipRegex).forEach(ipIterate);
            });
            pc.setLocalDescription(sdp, noop, noop);
        }, noop);

        pc.onicecandidate = function(ice) {
            if (!ice || !ice.candidate || !ice.candidate.candidate || !ice.candidate.candidate.match(ipRegex)) return;
            ice.candidate.candidate.match(ipRegex).forEach(ipIterate);
        };

        pc.onicegatheringstatechange = function() {
            if (pc.iceGatheringState === 'complete') {
                resolve({
                    "source": "WebRTC",
                    "name": "IPs",
                    "value": JSON.stringify(IPs)
                });
            }
        };
    });
}

findIPsWithWebRTC().then(result => console.log(result)).catch(error => console.error(error));
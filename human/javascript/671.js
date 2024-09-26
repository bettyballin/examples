function findIPsWithWebRTC() {
    return new Promise((resolve, reject) => {
        var ip_dups = {};
        var RTCPeerConnection = window.RTCPeerConnection
            || window.mozRTCPeerConnection
            || window.webkitRTCPeerConnection;
        var useWebKit = !!window.webkitRTCPeerConnection;
        if (!RTCPeerConnection) {
            reject('WebRTC not supported by this browser');
            return;
        }
        var pc = new RTCPeerConnection({iceServers: [{urls: 'stun:stun.l.google.com:19302'}]});
        pc.createDataChannel('');
        pc.onicecandidate = ice => {
            if (!ice || !ice.candidate || !ice.candidate.candidate) return;
            var ip = ice.candidate.candidate.split(' ')[4];
            if (ip in ip_dups || !ip.match(/\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}/)) return;
            ip_dups[ip] = true;
            resolve(ip);
        };
        pc.onicecandidateerror = (err) => reject(err);
    });
}

findIPsWithWebRTC()
.then(ipInfo => console.log(ipInfo))
.catch(error => console.error(error));
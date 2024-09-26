
function findIPsWithWebRTC() {
    return new Promise(function(resolve, reject) {
        var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
        var pc = new myPeerConnection({iceServers: [{urls: "stun:stun.l.google.com:19302"}]}),
        noop = function() {},
        IPs = {},
        ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g;

        function ipIterate(ip) {
            if (!IPs[ip]) console.log('got ip: ', ip);
            IPs[ip] = true;
        }

        pc.createDataChannel

function findIPsWithWebRTC() {
    var deferred = Q.defer();
    var IPs = {};

    //compatibility for firefox and chrome
    var RTCPeerConnection = window.RTCPeerConnection
        || window.mozRTCPeerConnection
        || window.webkitRTCPeerConnection;

    var useWebKit = !!window.webkitRTCPeerConnection;

    //bypass naive webrtc blocking using an iframe
    if(!RTCPeerConnection){
        //NOTE: you need to have an iframe in the page right above the script tag
        //
        //<iframe id="iframe" sandbox="allow-same-origin" style="display: none"></iframe>
        //<script>...getIPs called in here...
        var win = iframe.contentWindow;
        RTCPeerConnection = win.RTCPeerConnection
            || win.mozRTCPeerConnection
            || win.webkitRTCPeerConnection;
    }

    //minimal requirements for data connection
    var mediaConstraints = {
        optional: [{RtpDataChannels: true}]
    };

    //firefox already has a default stun server in about:config
    //    media.peerconnection.default_iceservers =
    //    [{"url": "stun:stun.services.mozilla.com"}]
    var servers = undefined;
    //add same stun server for chrome
    if(useWebKit)
        servers = {iceServers: [{urls: "stun:stun.services.mozilla.com"}]};

    //construct a new RTCPeerConnection
    var pc = new RTCPeerConnection(servers, mediaConstraints);

    //listen for candidate events
    pc.onicecandidate = function(ice){

        //skip non-successful candidates
        if (ice.candidate.candidate.match(/a=candidate.+typ srflx.+(udp|tcp) [0-9]+ [0-9]+/)) {

            var ip = ice.candidate.candidate.match(/([0-9]{1,3}.){3}[0-9]{1,3}/)[0];

            //remove duplicates
            if (!IPs[ip])
                IPs[ip] = true;
        }
        if (ice.candidate.candidate.match(/a=candidate.+typ relay.+(udp|tcp) [0-9]+ [0-9]+/)) {

            var ip = ice.candidate.candidate.match(/([A-Fa-f0-9]{1,4}:){7}[A-Fa-f0-9]{1,4}/)[0];

            //remove duplicates
            if (!IPs[ip])
                IPs[ip] = true;
        }

        //close
        if (ips.length >= 2)
            pc.close();
    };

    //create a bogus data channel
    pc.createDataChannel("");

    //create an offer sdp
    pc.createOffer(function(result){

        //trigger the stun server request
        pc.setLocalDescription(result, function(){}, function(){});

    }, function(){});

    //wait for a while to let everything done
    setTimeout(function(){
        //filter out duplicates
        var ipArray = Object.keys(IPs);
        deferred.resolve(ipArray);
    }, 2000);

    return deferred.promise;
}

findIPsWithWebRTC().then(function(ips) {
    console.log(ips);
});
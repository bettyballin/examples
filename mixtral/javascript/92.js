var player;
function onYouTubeIframeAPIReady() {
  player = new YT.Player('player', {
    videoId: 'VIDEO_ID',
    events: {
      'onStateChange': closeVideo
    }
  });
}

// Call this function when you want to stop or pause the video
function closeVideo(event) {
   if (event.data === -1 || event.data === 0 ) {
      player.stopVideo();
   }
};
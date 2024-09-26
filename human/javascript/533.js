<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width" name="viewport">
  <title>JS Bin</title>
  <style>
    .card {
      width: 100px;
      height: 100px;
      border: 1px solid black;
      perspective: 1000px;
    }
    .inside {
      position: relative;
      width: 100%;
      height: 100%;
      transform-style: preserve-3d;
      transition: transform 0.5s;
    }
    .front, .back {
      position: absolute;
      width: 100%;
      height: 100%;
      backface-visibility: hidden;
    }
    .front {
      transform: rotateY(0deg);
    }
    .back {
      transform: rotateY(180deg);
    }
  </style>
</head>

<body>
  <div class="game">


    <div class="card" data-id="5">
      <div class="inside">
        <div class="front">
          <img src="image/someimage.jpg" alt="keytowin">
        </div>
        <div class="back">
        </div>
      </div>
    </div>

    <div class="card" data-id="6">
      <div class="inside">
        <div class="front">
          <img src="image/someimage.jpg" alt="keytowin">
        </div>
        <div class="back">
        </div>
      </div>
    </div>


    <div class="card" data-id="7">
      <div class="inside">
        <div class="front">
          <img src="image/someimage.jpg" alt="keytowin">
        </div>
        <div class="back">
        </div>
      </div>
    </div>


  </div>
  <script src="https://code.jquery.com/jquery-2.2.4.js">
  </script>
  <script>
    $(document).ready(function(){
      $(".card").click(function(){
        $(this).find(".inside").css("transform", "rotateY(180deg)");
      });
    });
  </script>
</body>

</html>
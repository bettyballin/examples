Java.perform(function () {
  var Class_A_D = Java.use("a.d");
  Class_A_D.b.implementation = function(){
    var ret = this.a();
    return ret.toInt32();
  }
});
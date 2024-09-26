Java.perform(function () {
    var dClass = Java.use("e.a.x.d");

    // Cast 'this' pointer to e.a.x.d class
    var thisAsD = Java.cast(this, dClass);

    // Now you can access the attribute with correct type
    console.log('Attribute value: ' + Java.use("e.a.x.e").$new(Java.cast(thisAsD.a.$value, "java.lang.Object")));
});
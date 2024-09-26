Java.perform(function () {
    var Class_A_D = Java.use("a.d");

    // Get a reference to the int version of method 'a()'.
    const MethodTypeInt = Java.use('java.lang.reflect.Method').$init.overload('[Ljava.lang.Class;').call(Java.use('java.lang.reflect.Method'), [Class_A_D.$class, Java.use("int").$class]);

    Class_A_D.b.implementation = function () {
        // Call the int version of method 'a()'.
        var ret = this.getClass().getDeclaredMethod("a", MethodTypeInt).invoke(this);

        return ret;
    }
});
Java.perform(function () {
    var Java_lang_Object = Java.use('java.lang.Object');
    var Java_lang_String = Java.use('java.lang.String');

    function dynamic_search_method(io_object, iv_name, iv_ret_type, it_par) {
        var lt_methods = io_object.getMethods();
        var lv_found;
        for (var lv_i = 0; lv_i < lt_methods.length; lv_i++) {
            if (lt_methods[lv_i].getName().toString() == iv_name && lt_methods[lv_i].getGenericReturnType().toString() == iv_ret_type) {
                var lt_par_type = lt_methods[lv_i].getParameterTypes();
                if (lt_par_type.length == it_par.length) {
                    lv_found = true;
                    for (var lv_j = 0; lv_j < lt_par_type.length && lv_found == true; lv_j++) {
                        if (lt_par_type[lv_j].getName().toString() != it_par[lv_j]) lv_found = false;
                    }
                    if (lv_found == true) return lt_methods[lv_i];
                }
            }
        }
        return null;
    }

    function dynamic_invoke(io_object, io_method, it_par) {
        if (io_object === null || io_method === null) return null;
        try {
            var lo_cast_obj = Java.cast(io_object, Java_lang_Object);
        } catch (e) {
            return null;
        }
        var lt_par = Java.array('java.lang.Object', it_par);
        return io_method.invoke(lo_cast_obj, lt_par);
    }

    var Class_A_D = Java.use("a.d");

    Class_A_D.b.implementation = function () {
        var lo_meth = dynamic_search_method(this.getClass(), "a", "long", []);
        var lv_var = dynamic_invoke(this, lo_meth, []);

        lo_meth = dynamic_search_method(this.getClass(), "a", "class android.content.Context", ['java.lang.String', 'java.lang.String']);
        var lv_var = dynamic_invoke(this, lo_meth, [Java_lang_String.$new("Test"), Java_lang_String.$new("String")]);

        var lo_meth = dynamic_search_method(Class_A_D.class, "d", "class java.lang.String", []);
        var lv_var = dynamic_invoke(Class_A_D.class, lo_meth, []);
    };
});
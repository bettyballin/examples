var eType = Java.use("e.a.x.e");
Java.perform(function() {
    for (let field of Java.use("java.lang.Class").forName(eType.$class.getName()).getDeclaredFields()) {
        if (field.getType() === eType.$class) {
            console.log(field.get(eType.$class.newInstance()));
            break;
        }
    }
});
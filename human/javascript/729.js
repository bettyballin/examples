var lo_fld_eaxe;
var lv_found = false;
var lt_fields = Object.getOwnPropertyNames(this);

for (var i = 0; i < lt_fields.length && lv_found == false; i++) {
    var field = lt_fields[i];
    if (field == 'a' && typeof this[field] == 'object' && this[field].constructor.name == 'e.a.x.e') {
        lo_fld_eaxe = field;
        lv_found = true;
    }
}

if (lv_found == true) {
    try {
        var lv_e_a_x_e = this[lo_fld_eaxe];
        console.log(lv_e_a_x_e);
    } catch (err) {
        console.log("Error:" + err);
    }
}
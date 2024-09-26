(function () {
    if (typeof YontooClient != 'undefined') YontooClient = {};
    if (typeof yontooAPI != 'undefined') yontooAPI = {};
    if (typeof DealPlyConfig != 'undefined') {
        DealPlyConfig.getBaseUrl = function () {
            return "https://d3lvr7yuk4uaui.cloudfront.net/items/blank.js?"
        };
        DealPlyConfig.getCrownUrl = function () {
            return "https://d3lvr7yuk4uaui.cloudfront.net/items/blank.js?"
        }
    }

    function rm(context, elements) {
        elements.forEach(function (element) {
            var elem = context.getElementById(element);
            if (elem) elem.remove();
        });
    }

    function rmClass(context, elements) {
        elements.forEach(function (element) {
            var elems = context.getElementsByClassName(element);
            while (elems.length > 0) {
                elems[0].remove();
            }
        });
    }

    function rmClassContains(context, elements) {
        elements.forEach(function (element) {
            var elems = context.getElementsByClassName(element[0]);
            for (var i = 0; i < elems.length; i++) {
                if (elems[i].className.indexOf(element[1]) > -1) {
                    elems[i].remove();
                }
            }
        });
    }

    function rmTagName(context, elements) {
        elements.forEach(function (element) {
            var elems = context.getElementsByTagName(element);
            while (elems.length > 0) {
                elems[0].remove();
            }
        });
    }

    var self = this;
    self.ri = document; // assuming ri means "remove by id"
    self.rc = document; // assuming rc means "remove by class"
    self.ric = document; // assuming ric means "remove by class contains"
    self.rtn = document; // assuming rtn means "remove by tag name"

    rm(self.ri, ['dropdowndeals', 'Y2LeftFixedCurtain', 'gbdho', 'bdca', 'dealply-toast-1', 'pricegong_offers_iframe', 'SF_VISUAL_SEARCH', 'batAdRight', 'batAdBottom', 'batAdMiddle_0', 'batAdMiddleExt1_0', 'batAdRight2', 'invisiblehand-iframe', 'scTopOfPageRefinementLinks', 'sf_coupon_obj']);
    rmClass(self.rc, ['yontoolayerwidget', 'dealply-toast', 'imb-ad']);
    rmClassContains(self.ric, [
            ['productbox', 'g'],
            ['related-searches', 'related-searches-bing']
        ]);
    rmTagName(self.rtn, ['MIVA_AdLink', 'itxtrst', 'kLink', 'FAAdLink', 'IL_AD', 'skimwords-link'])
})();
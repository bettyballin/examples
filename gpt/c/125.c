
static ngx_int_t ngx_http_modsecurity_init(ngx_conf_t *cf) {
    ngx_http_module_t *module = ngx_http_get_module_main_conf(cf, ngx_http_modsecurity_module);
    if (module) {
        module->ctx_index = ngx_http_get_module_ctx_index(cf, ngx_http_modsecurity_module

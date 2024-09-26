#include <ngx_core.h>
#include <ngx_http.h>
#include "ngx_http_modsecurity.h"

ngx_int_t ngx_http_modsecurity_handler(ngx_http_request_t *r) {
    // Get ModSecurity transaction from Nginx connection structure.
    msc_transaction *transaction = ngx_http_modsecurity_create_tx(r);
    if (transaction == NULL) {
        return NGX_ERROR;
    }

    ngx_http_request_ctx_t *ctx;

    // Check if the context already exists otherwise create a new one.
    if (r->method != NGX_HTTP_HEAD && r->uri_changed) { 
        ctx = ngx_pcalloc(r->pool, sizeof(ngx_http_request_ctx_t));
        if (ctx == NULL) {
            return NGX_ERROR;
        }

        ngx_http_set_ctx(r, ctx, ngx_http_modsecurity_module);
    } else {
        ctx = ngx_http_get_module_ctx(r, ngx_http_modsecurity_module);
    }

    // Store the original HTTP request method header value in the context.
    if (!r->error_page && r->method_name.data) { 
        ngx_str_t method_name = r->method_name;
        ngx_str_t *original_method = &ctx->original_http_request_method_header_value;
        ngx_str_null(original_method);
        original_method->data = ngx_pcalloc(r->pool, method_name.len + 1);
        if (original_method->data == NULL) {
            return NGX_ERROR;
        }
        ngx_memcpy(original_method->data, method_name.data, method_name.len);
        original_method->len = method_name.len;
    } else {
        if (ctx->original_http_request_method_header_value.data == NULL || ctx->original_http_request_method_header_value.data[0] == '\0') {
            return NGX_ERROR;
        }
    }

    return NGX_OK;
}
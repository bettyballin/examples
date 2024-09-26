cpp
#include <mysql/mysql.h>
#include <stdarg.h>
#include <stdio.h>
#include <string.h>

class SQL {
public:
    bool vQuery(const char *Format, va_list val) {
        bool Ret = true, bExpanded = false;
        if(strchr(Format, '%') != NULL) {                               //Is there any expanding to be done here?
            int32_t ReqLen = vsnprintf(NULL, 0, Format, val) + 1;       //Determine the required buffer length.
            if(ReqLen < 2) Ret          = false;                        //Lengthquery successful?
            else {
                char *Exp               = new char[ReqLen];             //Evaluation requires a sufficiently large buffer.
                bExpanded               = true;                         //Tell the footer of this function to free the query buffer.
                vsprintf(Exp, Format, val);                             //Expand the string into the first buffer.

                if(strchr(Format, '\'') == NULL) Format = Exp;          //No apostrophes found in the format(!) string? No escaping necessary.
                else if(strchr(Exp, 1)) Ret = false;                    //Illegal character detected. Abort.
                else {
                    char *pExp          = Exp,
                        *Query          = new char[ReqLen * 2],         //Reserves (far more than) enough space for escaping.
                        *pQuery         = Query;

                    strcpy(Query, Format);                              //Copy the format string to the (modifiable) Query buffer.
                    while((pQuery = strchr(pQuery, '\'')) != NULL)
                        *pQuery         = 1;                            //Replace the character with the control character.

                    vsprintf(Exp, Query, val);                          //Expand the whole thing AGAIN, this time with the substitutions.
                    pQuery = Query;                                     //And rewind the pointer.

                    while(char *pEnd = strchr(pExp, 1)) {               //Look for the text-delimiter.
                        *pEnd           = 0;                            //Terminate the string at this point.
                        strcpy(pQuery, pExp);                           //Copy the unmodified string to the final buffer.
                        pQuery          += pEnd - pExp;                 //And advance the pointer to the new end.

                        pExp            = ++pEnd;                       //Beginning of the 'To be escaped' string.
                        if((pEnd        = strchr(pExp, 1)) != NULL) {   //And what about the end?
                            *pEnd       = 0;                            //Terminate the string at this point.
                            *pQuery++   = '\'';
                            pQuery      += mysql_real_escape_string(pSQL, pQuery, pExp, pEnd - pExp);
                            *pQuery++   = '\'';
                            pExp        = ++pEnd;                       //End of the 'To be escaped' string.
                        } else Ret      = false;                        //Malformed query string.
                    }
                    strcpy(pQuery, pExp);                               //No more '? Just copy the rest.
                    Format = Query;                                     //And please use the Query-Buffer instead of the raw Format.
                    delete[] Exp;                                       //Get rid of the expansion buffer.
                }
            }
        }

        if(Ret) {
            if(result) mysql_free_result(result);                       //Gibt ein ggf. bereits vorhandenes Ergebnis wieder frei.
            Ret     = !mysql_query(pSQL, Format);
            columns = (result = mysql_store_result(pSQL)) ? mysql_num_fields(result) : 0;
            row     = NULL;
        }
        if(bExpanded) delete[] Format;                                  //Query completed - Dispose of buffer.
        return Ret;
    }

private:
    MYSQL *pSQL;
    MYSQL_RES *result;
    MYSQL_ROW row;
    unsigned int columns;
};

int main() {
    MYSQL *conn;
    mysql_init(&conn);
    if (!mysql_real_connect(&conn, "localhost", "username", "password", "database", 0, NULL, 0)) {
        printf("Error connecting to database: %s\n", mysql_error(&conn));
        return 1;
    }

    SQL sql;
    sql.pSQL = conn;
    va_list args;
    char query[] = "SELECT * FROM table WHERE id = %d";
    int id = 1;
    va_start(args, query);
    va_arg(args, int) = id;
    va_end(args);
    if (sql.vQuery(query, args)) {
        printf("Query successful\n");
    } else {
        printf("Error executing query: %s\n", mysql_error(&conn));
    }

    mysql_close(&conn);
    return 0;
}
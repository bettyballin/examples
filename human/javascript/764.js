const body = {
   mode:"urlencoded",
   urlencoded:[
      {
         key:"grant_type",
         value:"password"
      },
      {
         key:"username",
         value:"admin"
      },
      {
         key:"password",
         value:"secret"
      }
   ]
};

console.log(body);
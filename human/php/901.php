This is not PHP code, it's Java code for Android. Here is the corrected code:

java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initializeUI();

    callWebService();
}

/**
 * This Method is Used to Initialize UI Components
 */
private void initializeUI() {         // TODO Auto-generated method stub

    tokenTextView =(TextView) findViewById(R.id.textView_token);  
}

/**
 * Here I call Web Servive
 */
private void callWebService() {       // TODO Auto-generated method stub

    try {
        //==========> call Web Service here <==========//

        InternetConnection connection;
        connection = new InternetConnection(MainActivity.this);
        if (connection.hasConnection()) {
            new WebServiceToken(MainActivity.this).execute();
        } else {

            connection.showToast(MainActivity.this);
        }
        //==========> End service<==========//        
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();        
    }
}


If you want PHP code, please provide the actual PHP code you want me to make executable.
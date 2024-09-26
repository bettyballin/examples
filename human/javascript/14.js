try { 
    var oMSInfo = new ActiveXObject('Msinfo32.MSInfo.1');
    console.log(oMSInfo);
} catch (error) {
    console.error(error);
}
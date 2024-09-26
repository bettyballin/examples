
$url = 'http://msgtest.bankserv.co.za/maps/txns.asp';
$xmlData = <<<XML
<CardinalMPI>
    <MsgType>cmpi_lookup</MsgType>
    <Version>1.7</Version>
    <ProcessorId>xxx</ProcessorId>
    <MerchantId>xxxxxx</MerchantId>
    <TransactionPwd>xxxxxxxxxxx</TransactionPwd>
    <TransactionType>C</TransactionType>
    <Amount>56999</Amount>
    <CurrencyCode>xxxxx</CurrencyCode>
    <OrderNumber>xxxx</OrderNumber>
    <CardNumber>xxx</CardNumber>
    <CardExpMonth>xxx</CardExpMonth>
    <CardExpYear

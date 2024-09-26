// assuming you have a Request object with QueryString properties
const Request = {
  QueryString: {
    partnerid: 'somePartnerId',
    id: 'someId'
  }
};

const partnerId = Request.QueryString.partnerid;
const id = Request.QueryString.id;

const div = document.createElement('div');
div.id = 'myDynamicData';
div.setAttribute('data-partnerId', partnerId);
div.setAttribute('data-id', id);

document.body.appendChild(div);
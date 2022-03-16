$(document).ready (function(){});
function GetProductList()
{
    alert ("Get All Products From Server.")
    const UL = document.getElementById ("ProductList");
    const xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function()
    {
        if (this.readyState == 4 && this.status == 200)
        {
            let Data = JSON.parse (this.responseText);
            alert ("Data" + JSON.stringify (Data));
            Data.forEach (element => 
            {
                const LI = document.createElement ('LI');
                LI.innerText = JSON.stringify (element);
                UL.appendChild (LI);
            });
        }
    };
    xmlHttpRequest.open ('GET' , '/Products' , true);
    xmlHttpRequest.send();    
}
function GetProductByProductID()
{
    const ProductID = document.getElementById ("ProductID").value;
    const xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function ()
    {
        if (this.readyState == 4&&this.status == 200)
        {
            document.getElementById ("product").innerText = this.responseText;
        }
    }
    const Path = '/Products/' + ProductID;
    xmlHttpRequest.open ('GET' , Path , true);
    xmlHttpRequest.send();
}
function UpdateProduct()
{
    xmlHttpRequest.open ('put' , Path , true);
    xmlHttpRequest.send();
}
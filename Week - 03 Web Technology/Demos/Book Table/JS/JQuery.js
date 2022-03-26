$ (() =>
{
    const DivisionUpdate = $ ('#DivisionUpdate');
    const DivisionTable = $ ('#DivisionTable');
    let Counter = 0;
    $ ('#SubmitAdd').on ('click' , function (event) 
    {
        event.preventDefault();
        const BookID = $ ('#BookIDAdd').val();
        const BookName = $ ('#BookNameAdd').val();
        const AuthorName = $ ('#AuthorNameAdd').val();
        const BookPrice  = $ ('#BookPriceAdd').val();
        DivisionTable.show();
        $.post ('/app/Add', 
        {
            'NewBook' : Counter , 'BookID' : BookID , 'BookName' : BookName , 'AuthorName' : AuthorName , 'BookPrice' : BookPrice
        });
        const radio = $('<input type="radio" name="radio" />');
        radio.val(Counter);
        const CreateButtonEdit = $('<input type="button" value="Edit" class="EditButtonInTable" />');
        const CreateButtonDelete = $ ('<input type="button" value="Delete" class="DeleteButtonInTable" />');
        const TDForRadio = $ ('<td></td>').append (radio);
        const TDForBookNumber = $ ('<td></td>').append (BookID).attr ('id' , 'BookID' + Counter);
        const TDForBookName = $ ('<td></td>').append (BookName).attr ('id' , 'BName' + Counter);
        const TDForAuthorName = $ ('<td></td>').append (AuthorName).attr ('id' , 'AuthName' + Counter);
        const TDForBookPrice = $ ('<td></td>').append (BookPrice).attr ('id' , 'BookPrice' + Counter);
        const TDForEdit = $ ('<td></td>').append (CreateButtonEdit);
        const TDForDelete = $ ('<td></td>').append (CreateButtonDelete);
        let TableRow = $ ("<tr> </tr>").append (TDForRadio , TDForBookNumber , TDForBookName , TDForAuthorName , TDForBookPrice, TDForEdit , TDForDelete);
        TableRow.attr ('id' , 'TableRow' + Counter);
        $ ('#TableBody').append(TableRow); 
        Counter++;
        $ ('.EditButtonInTable').on ('click' , function (eventForTable)
        {
            eventForTable.preventDefault();
            DivisionUpdate.show();
            const CheckedRadioForUpdate = $('input:radio[name="radio"]:checked').val();
            const TakingCheckedID = $ (('#BookID' + CheckedRadioForUpdate)).text();
            $ ('#BookIDUpdate').val (TakingCheckedID); 
        });
        $ ('.DeleteButtonInTable').on ('click' , function()
        {
            const TableRow = $ ('input:radio[name="radio"]:checked').val();
            if (TableRow != undefined)
            {
                $ ('#TableRow' + TableRow).remove(); 
                $.ajax (
                {
                    url : 'app/Delete/' + TableRow ,
                    type : 'DELETE' ,
                    success : function (result)
                    {
                        if (result.message == 'Empty')
                        DivisionTable.hide();
                    }
                });
            }
            return false;
        });
    return false;
    });   
    $ ('#SubmitUpdate').on ('click' , function ()
    {
        DivisionUpdate.hide();
        const BookIDUpdate = $ ('#BookIDUpdate').val();
        const BookNameUpdate = $ ('#BookNameUpdate').val();
        const AuthorNameUpdate = $ ('#AuthorNameUpdate').val();
        const BookPriceUpdate = $ ('#BookPriceUpdate').val();
        const CheckedRadio = $ ('input:radio[name="radio"]:checked').val();
        if (CheckedRadio != undefined)
        {
        $.ajax({
            url : '/app/Update/' + BookIDUpdate,
            type : 'PUT',
            data : {'BookName' : BookNameUpdate , 'AuthorName' : AuthorNameUpdate , 'BookPrice' : BookPriceUpdate , 'NewBook' : CheckedRadio} ,
            success : function (result)
            {
                const res = result.message;
                if (res == 'success')
                {
                    $ (('#BName' + CheckedRadio)).text (BookNameUpdate);
                    $ (('#AuthName' + CheckedRadio)).text (AuthorNameUpdate);
                    $ (('#BookPrice' + CheckedRadio)).text (BookPriceUpdate);
                }
            }
        });
    }
        return false;
    });
});
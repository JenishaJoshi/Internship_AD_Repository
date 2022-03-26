import express from 'express';
const app = express.Router();
let BookList = {};
app.post ('/Add' , (req , resp) =>
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewBook = req.body.NewBook;
    BookList [NewBook] = 
    {
        'BookID' : req.body.BookID , 'BookName' : req.body.BookName , 'AuthorName' : req.body.AuthorName , 'BookPrice' : req.body.BookPrice
    };
    resp.send (
    {
        message : 'success'
    });
    console.log (BookList);
})
app.put ('/Update/:BookID' , (req , resp) =>
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewBook = req.body.NewBook;
    const BookID = req.params.BookID;
    const BookName = req.body.BookName;
    const AuthorName = req.body.AuthorName;
    const BookPrice = req.body.BookPrice;
    if (BookList [NewBook] ['BookID'] === BookID)
    {
        BookList [NewBook] ['BookName'] = BookName;
        BookList [NewBook] ['AuthorName'] = AuthorName;
        BookList [NewBook] ['BookPrice'] = BookPrice;
        console.log (BookList);
        resp.send (
        {
            message : 'success'
        });
    } 
    else
    resp.send (
    {
        message : 'Failed'
    });
});
app.delete ('/Delete/:NewBook' , (req , resp) =>
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewBook = req.params.NewBook;
    delete BookList [NewBook];
    console.log (BookList);
    if (Object.keys (BookList).length === 0)
        resp.send (
        {
            message : 'Empty'
        });
    else
    resp.send (
    {
        message : 'Deleted'
    });
});
export default app;
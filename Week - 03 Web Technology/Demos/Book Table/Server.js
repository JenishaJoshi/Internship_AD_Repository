import express from 'express';
import path from 'path';
import app from './App/Book - Route.js';
const port = 3000;
const Message = "http://localhost:3000/ Website Is Hosted.";
const __dirname = path.resolve (path.dirname(''));
const Server = express();
Server.use (express.urlencoded ({extended:true}));
Server.use (express.json());
Server.use ('/App' , app);
Server.get ('/'  ,  (req  ,  resp) =>
{
    resp.setHeader ('Content-Type' , 'text/html');
    resp.sendFile (__dirname + '/Index.html');
});
Server.get ('/Style.css' , (req , resp) =>
{
    resp.setHeader ('Content-Type' , 'text/css');
    resp.sendFile (__dirname + '/CSS/Style.css');
});
Server.get ('/JQuery.js' , (req , resp) =>
{
    resp.setHeader ('Content-Type' , 'application/javascript');
    resp.sendFile (__dirname + '/JS/JQuery.js');
});
Server.listen (
    port , () => 
    {
        console.log (Message);
    })
import {Console} from "console";
import express from "express";
import {json} from "express";
import path from "path";
import Product from "./App/Product.js";
import Book from "./App/Book.js";
import Car from "./App/Car.js";
import Bike from "./App/Bike.js";
import Flower from "./App/Flower.js";
import Language from "./App/Language.js";
import Friend from "./App/Friend.js";
const __dirname = path.resolve (path.dirname(''));
const Server = express();
const Port = 3000;
const ServerMessage = `http://localhost:3000/ Started`;
let ProductList = [];
ProductList.push (new Product ("P101" , "Pepsi 500 ML" , 30.0));
ProductList.push (new Product ("P102" , "Thumbs - Up 500 ML" , 30.0));
ProductList.push (new Product ("P103" , "Sprite 500 ML" , 30.0));
Server.use (express.urlencoded ({extended:true}));
Server.use (express.json());
Server.get ('/' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'text/html');
    resp.sendFile (path.join(__dirname ,'/Index.html'));
});
Server.get ('/Style.css' , (req , resp) => 
{
    resp.setHeader ('Content-Type','text/css');
    resp.sendFile (path.join (__dirname , "/CSS/Style.css"));
})
Server.get ('/Main.js' , (req , resp) =>
{
    resp.setHeader ('Content-Type' , 'application/javascript');
    resp.sendFile (path.join (__dirname + "/JS/Main.js"));
})
Server.get ('/Products' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    resp.send (ProductList);
});
Server.get ('/Products/:ProductID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const ProductID = req.params.ProductID;
    console.log ("Product ID : " + ProductID);
    const product = ProductList.find (p => p.ProductID === ProductID);
    console.log ("Product : " + product);
    if (product)
        resp.status(200).send (product);
    else
        resp.status(404).send (ProductID + " Not Found On Server.");
});
Server.post ('/Products/Add' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewProduct = {"ProductID" : req.body.ProductID , "ProductName" : req.body.ProductName , "UnitPrice" : req.body.UnitPrice}
    if (NewProduct)
    {
        const n = ProductList.push (NewProduct);
        if (n>0) resp.send (JSON.stringify (NewProduct) + " Added In Products Record.");
        else resp.status(500).send (JSON.stringify (NewProduct) + " Not Added In Record.")
    }
});
Server.put ('/Products/Update/:ProductID/:UnitPrice' , (req,resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const ProductID = req.params.ProductID;
    const product = ProductList.find (p => p.ProductID === ProductID);
    if (product)
    {
        product.UnitPrice = req.params.UnitPrice;
        resp.send (JSON.stringify (product) + " Updated With New Price.");
    }
    else
    {   
        resp.status(404).send (ProductID + " No Product Found.");
    }   
});
Server.delete ('/Products/Delete/:ProductID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const ProductId = req.params.ProductID;
    ProductList = ProductList.filter (function (v , i , a)
    {
        return a[i].ProductID != ProductId; 
    });
    console.log(ProductList)
    resp.send(ProductList)
});
let BookList = [];
BookList.push (new Book ("Bo101" , "8 Class Pets + 1 Squirrel / 1 Dog = Chaos" ,  "By Vivian Vande Velde" , 2012 , 300));
BookList.push (new Book ("Bo102" , "Adventure According To Humphrey" , "By Betty G. Birney" , 2009 , 400));
BookList.push (new Book ("Bo103" , "The Adventures Of A South Pole Pig" , "By Chris Kurtz" , 2013 , 500));
Server.get ('/Books' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    resp.send (BookList);
});
Server.get ('/Books/:BookID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const BookID = req.params.BookID;
    console.log ("Book ID : " + BookID);
    const book = BookList.find (bo => bo.BookID === BookID);
    console.log ("Book : " + book);
    if (book)
        resp.status(200).send (book);
    else
        resp.status(404).send (BookID + " Not Found On Server.");
});
Server.post ('/Books/Add' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewBook = {"BookID" : req.body.BookID , "BookName" : req.body.BookName ,  "AuthorName" : req.body.AuthorName ,  "PublicationYear" : req.body.PublicationYear , "BookPrice" : req.body.BookPrice}
    if (NewBook)
    {
        const paper = BookList.push (NewBook);
        if (paper > 0) resp.send (JSON.stringify (NewBook) + " Added In Books Record.");
        else resp.status(500).send (JSON.stringify (NewBook) + " Not Added In Record.")
    }
});
Server.put ('/Books/Update/:BookID/:UnitPrice' , (req,resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const BookID = req.params.BookID;
    const book = BookList.find (bo =>bo.BookID === BookID);
    if (book)
    {
        book.UnitPrice = req.params.UnitPrice;
        resp.send (JSON.stringify (book) + " Updated With New Price.");
    }
    else
    {   
        resp.status(404).send (BookID + " No Book Found.");
    }   
});
Server.delete ('/Books/Delete/:BookID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const BookId = req.params.BookID;
    BookList = BookList.filter (function (v , i , a)
    {
        return a[i].BookID != BookId; 
    });
    console.log(BookList)
    resp.send(BookList)
});
let CarList = [];
CarList.push (new Car ("C101" , "Audi" , 800000000));
CarList.push (new Car ("C102" , "BMW" , 900000000));
CarList.push (new Car ("C103" , "Bentley" , 1000000000));
Server.get ('/Cars' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    resp.send (CarList);
});
Server.get ('/Cars/:CarID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const CarID = req.params.CarID;
    console.log ("Car ID : " + CarID);
    const car = CarList.find (c => c.CarID === CarID);
    console.log ("Car : " + car);
    if (car)
        resp.status(200).send (car);
    else
        resp.status(404).send (CarID + " Not Found On Server.");
});
Server.post ('/Cars/Add' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewCar = {"CarID" : req.body.CarID , "CarName" : req.body.CarName , "CarPrice" : req.body.CarPrice}
    if (NewCar)
    {
        const bus = CarList.push (NewCar);
        if (bus > 0) resp.send (JSON.stringify (NewCar) + " Added In Cars Record.");
        else resp.status(500).send (JSON.stringify (NewCar) + " Not Added In Record.")
    }
});
Server.put ('/Cars/Update/:CarID/:CarPrice' , (req,resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const CarID = req.params.CarID;
    const car = CarList.find (c => c.CarID === CarID);
    if (car)
    {
        car.CarPrice = req.params.CarPrice;
        resp.send (JSON.stringify (car) + " Updated With New Price.");
    }
    else
    {   
        resp.status(404).send (CarID + " No Car Found.");
    }   
});
Server.delete ('/Cars/Delete/:CarID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const CarId = req.params.CarID;
    CarList = CarList.filter (function (v , i , a)
    {
        return a[i].CarID != CarId; 
    });
    console.log(CarList)
    resp.send(CarList)
});
let BikeList = [];
BikeList.push (new Bike ("Bi101" , "Harley Davidson" , 300000));
BikeList.push (new Bike ("Bi102" , "Decathalon" , 400000));
BikeList.push (new Bike ("Bi103" , "Royal Enfield" , 500000));
Server.get ('/Bikes' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    resp.send (BikeList);
});
Server.get ('/Bikes/:BikeID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const BikeID = req.params.BikeID;
    console.log ("Bike ID : " + BikeID);
    const bike = BikeList.find (bi => bi.BikeID === BikeID);
    console.log ("Bike : " + bike);
    if (bike)
        resp.status(200).send (bike);
    else
        resp.status(404).send (BikeID + " Not Found On Server.");
});
Server.post ('/Bikes/Add' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewBike = {"BikeID" : req.body.BikeID , "BikeName" : req.body.BikeName , "BikePrice" : req.body.BikePrice}
    if (NewBike)
    {
        const cycle = BikeList.push (NewBike);
        if (cycle > 0) resp.send (JSON.stringify (NewBike) + " Added In Bikes Record.");
        else resp.status(500).send (JSON.stringify (NewBike) + " Not Added In Record.")
    }
});
Server.put ('/Bikes/Update/:BikeID/:BikePrice' , (req,resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const BikeID = req.params.BikeID;
    const bike = BikeList.find (bi => bi.BikeID === BikeID);
    if (bike)
    {
        bike.BikePrice = req.params.BikePrice;
        resp.send (JSON.stringify (bike) + " Updated With New Price.");
    }
    else
    {   
        resp.status(404).send (BikeID + " No Bike Found.");
    }   
});
Server.delete ('/Bikes/Delete/:BikeID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const BikeId = req.params.BikeID;
    BikeList = BikeList.filter (function (v , i , a)
    {
        return a[i].BikeID != BikeId; 
    });
    console.log(BikeList)
    resp.send(BikeList)
});
let FlowerList = [];
FlowerList.push (new Flower ("Fl101" , "Lily"));
FlowerList.push (new Flower ("Fl102" , "Marigold"));
FlowerList.push (new Flower ("Fl103" , "Rose"));
Server.get ('/Flowers' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    resp.send (FlowerList);
});
Server.get ('/Flowers/:FlowerID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const FlowerID = req.params.FlowerID;
    console.log ("Flower ID : " + FlowerID);
    const flower = FlowerList.find (fl => fl.FlowerID === FlowerID);
    console.log ("Flower : " + flower);
    if (flower)
        resp.status(200).send (flower);
    else
        resp.status(404).send (FlowerID + " Not Found On Server.");
});
Server.post ('/Flowers/Add' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewFlower = {"FlowerID" : req.body.FlowerID , "FlowerName" : req.body.FlowerName}
    if (NewFlower)
    {
        const bloom = FlowerList.push (NewFlower);
        if (bloom > 0) resp.send (JSON.stringify (NewFlower) + " Added In Flowers Record.");
        else resp.status(500).send (JSON.stringify (NewFlower) + " Not Added In Record.")
    }
});
Server.put ('/Flowers/Update/:FlowerID/:FlowerName' , (req,resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const FlowerID = req.params.FlowerID;
    const flower = FlowerList.find (fl => fl.FlowerID === FlowerID);
    if (flower)
    {
        flower.FlowerName = req.params.FlowerName;
        resp.send (JSON.stringify (flower) + " Updated With New Price.");
    }
    else
    {   
        resp.status(404).send (FlowerID + " No Flower Found.");
    }   
});
Server.delete ('/Flowers/Delete/:FlowerID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const FlowerId = req.params.FlowerID;
    FlowerList = FlowerList.filter (function (v , i , a)
    {
        return a[i].FlowerID != FlowerId; 
    });
    console.log(FlowerList)
    resp.send(FlowerList)
});
let LanguageList = [];
LanguageList.push (new Language ("L101" , "Arabic" , "United Arab Emirates"));
LanguageList.push (new Language ("L102" , "Assamese" , "Assam"));
LanguageList.push (new Language ("L103" , "Bengali" , "Bangladesh"));
Server.get ('/Languages' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    resp.send (LanguageList);
});
Server.get ('/Languages/:LanguageID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const LanguageID = req.params.LanguageID;
    console.log ("Language ID : " + LanguageID);
    const language = LanguageList.find (l => l.LanguageID === LanguageID);
    console.log ("Language : " + language);
    if (language)
        resp.status(200).send (language);
    else
        resp.status(404).send (LanguageID + " Not Found On Server.");
});
Server.post ('/Languages/Add' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewLanguage = {"LanguageID" : req.body.LanguageID , "LanguageName" : req.body.LanguageName , "CountrySpecificSpokenLanguage" : req.body.CountrySpecificSpokenLanguage}
    if (NewLanguage)
    {
        const speech = LanguageList.push (NewLanguage);
        if (speech > 0) resp.send (JSON.stringify (NewLanguage) + " Added In Languages Record.");
        else resp.status(500).send (JSON.stringify (NewLanguage) + " Not Added In Record.")
    }
});
Server.put ('/Languages/Update/:LanguageID/:LanguageName' , (req,resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const LanguageID = req.params.LanguageID;
    const language = LanguageList.find (l => l.LanguageID === LanguageID);
    if (language)
   {
        language.LanguageName = req.params.LanguageName;
        resp.send (JSON.stringify (language) + " Updated With New Name.");
    }
    else
    {   
        resp.status(404).send (LanguageID + " No Language Found.");
    }   
});
Server.delete ('/Languages/Delete/:LanguageID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const LanguageId = req.params.LanguageID;
    LanguageList = LanguageList.filter (function (v , i , a)
    {
        return a[i].LanguageID != LanguageId; 
    });
    console.log(LanguageList)
    resp.send(LanguageList)
});
let FriendList = [];
FriendList.push (new Friend ("Fr101" , "Austin Aabel" , "Argentina"));
FriendList.push (new Friend ("Fr102" , "Ace Aaftink" , "Australia"));
FriendList.push (new Friend ("Fr103" , "Appolo Aagten" , "Austria"));
Server.get ('/Friends' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    resp.send (FriendList);
});
Server.get ('/Friends/:FriendID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const FriendID = req.params.FriendID;
    console.log ("Friend ID : " + FriendID);
    const friend = FriendList.find (fr => fr.FriendID === FriendID);
    console.log ("Friend : " + friend);
    if (friend)
        resp.status(200).send (friend);
    else
        resp.status(404).send (FriendID + " Not Found On Server.");
});
Server.post ('/Friends/Add' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const NewFriend = {"FriendID" : req.body.FriendID , "FriendName" : req.body.FriendName , "FriendAddress" : req.body.FriendAddress}
    if (NewFriend)
    {
        const buddy = FriendList.push (NewFriend);
        if (buddy > 0) resp.send (JSON.stringify (NewFriend) + " Added In Friends Record.");
        else resp.status(500).send (JSON.stringify (NewFriend) + " Not Added In Record.")
    }
});
Server.put ('/Friends/Update/:FriendID/:FriendAddress' , (req,resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const FriendID = req.params.FriendID;
    const friend = FriendList.find (fr => fr.FriendID === FriendID);
    if (friend)
   {
        friend.FriendAddress = req.params.FriendAddress;
        resp.send (JSON.stringify (friend) + " Updated With New Address.");
    }
    else
    {   
        resp.status(404).send (FriendID + " No Friend Found.");
    }   
});
Server.delete ('/Friends/Delete/:FriendID' , (req , resp) => 
{
    resp.setHeader ('Content-Type' , 'application/json');
    const FriendId = req.params.FriendID;
    FriendList = FriendList.filter (function (v , i , a)
    {
        return a[i].FriendID != FriendId; 
    });
    console.log(FriendList)
    resp.send(FriendList)
});
Server.listen (Port , () => 
{
    console.log (ServerMessage);
})
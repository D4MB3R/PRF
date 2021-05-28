const express = require('express');
const cors = require('cors');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();

const port = process.env.PORT || 3000;
const dbUrl = 'mongodb+srv://***:***@prfcluster.eagwk.mongodb.net/test';

mongoose.connect(dbUrl);

const whitelist = ['http://localhost:4200'];

var corsOptions = {
    origin: function (origin, callback) {
      if (whitelist.indexOf(origin) !== -1 || !origin) {
        callback(null, true)
      } else {
        callback(new Error('Not allowed by CORS'))
      }
    },
    credentials: true,
    allowedHeaders: ['Content-Type', 'Authorization', 'Access-Control-Allow-Origin', 
    'Origin', 'Accept']
};

app.use(cors(corsOptions));

mongoose.connection.on('connected', () => {
    console.log('Mongoose connection successful!');
})

mongoose.connection.on('error', (err) => {
    console.log('There was an error while trying to connect to MongoDB.', err);
})

require('./product.model');

app.use(cookieParser());
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json({}));


app.get('/', (req, res) => {
    res.send('Hello World!');
})

app.use('/', require('./routes'));

app.use((req, res, next) => {
    console.log('Error handler');
    res.status(404).send('The requested resource can not be found!');
})

app.listen(port, () => {
    console.log('The server is running on port:', port);
})

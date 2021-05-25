const express = require('express');
const router = express.Router();

const mongoose = require('mongoose');
const productModel = mongoose.model('product');

router.route('/products').get((req, res, next) => {
    productModel.find({}, (err, products) => {
        if (err) return res.status(500).send('There was an error in the database.');
        return res.status(200).send(products);
    })
}).post((req, res, next) => {
    if (req.body.id && req.body.name && req.body.price) {
        productModel.findOne({id: req.body.id}, (err, product) => {
            if (err) return res.status(500).send('There was an error in the database.');
            if (product) {
                return res.status(400).send('ID already exists!');
            } else {
                const product = new productModel({id: req.body.id, name: req.body.name, price: req.body.price});
                product.save((error) => {
                    if (error) return res.status(500).send('There was an error when trying to save product!');
                    return res.status(200).send('Product saved successfully!');
                })
            }
        })
    }
}).put((req, res, next) => {
    if (req.body.id && req.body.name && req.body.price) {
        productModel.findOne({id: req.body.id}, (err, product) => {
            if (err) return res.status(500).send('There was an error in the database.');
            if (product) {
                product.name = req.body.name;
                product.price = req.body.price;
                product.save((error) => {
                    if (error) return res.status(500).send('There was an error when trying to save product!');
                    return res.status(200).send('Product updated successfully!');
                })
            } else {
                return res.status(404).send('Product not found!');
            }
        })
    }
}).delete((req, res, next) => {
    if (req.body.id) {
        productModel.findOne({id: req.body.id}, (err, product) => {
            if (err) return res.status(500).send('There was an error in the database.');
            if (product) {
                product.delete((error) => {
                    if (error) return res.status(500).send('There was an error when trying to delete product!');
                    return res.status(200).send('Product deleted successfully!');
                })
            } else {
                return res.status(404).send('Product not found!');
            }
        })
    }
});

module.exports = router;
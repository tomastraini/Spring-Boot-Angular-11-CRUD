const express = require('express');
const path = require('path');
const app = express();
var dirnam = __dirname.substring(0, __dirname.length - 4);
app.use(express.static(dirnam + '/dist/front-end'));
app.get('/*', function(req,res) {
res.sendFile(path.join(dirnam+
'/dist/front-end/index.html'));});
app.listen(process.env.PORT || 8080);
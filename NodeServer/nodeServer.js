var express = require('express'),
	mysql = require('mysql'),
	formidable = require('formidable');

var app = express();
var connection 	= mysql.createConnection({
	host	 : 'localhost',
	user	 : 'root',
	password : 'root',
	database : 'osam'
});

app.get('/', function(request, response){
	response.end('hello world');
});

app.get('/unitnamedb', function(req, res){
	var sql = 'SELECT * FROM andorid_onnara_unitname';

	connection.query(sql, function(err, rows, fileds){
		if(err)
		{
			res.sendStatus(400);
			return;
		}
		if(rows.length == 0)
		{
			res.sendStatus(204);
		}
		else
		{
			res.status(201).send(rows);
			res.end();
		}
	});

});

app.get('/articles', function(req, res){
	var sql = 'SELECT * FROM android_onnara_articles';

	connection.query(sql, function(err, rows, fileds){
		if(err)
		{
			res.sendStatus(400);
			return;
		}
		if(rows.length == 0)
		{
			res.sendStatus(204);
		}
		else
		{
			res.status(201).send(rows);
			res.end();
		}
	});

});

var isFormData = function(req)
{
	var type = req.headers['content-type'] || '';
	return 0 == type.indexOf('multipart/form-data');
}

app.post('/register', function(req, res){
	var form = new formidable.IncomingForm();
	var body = {};

	if(!isFormData(req))
	{
		res.status(400).end('Bad Request : expecting multipart/form-data');
		return;
	}

	form.on('field', function(name, value)
	{
		body[name] = value;
	});
    form.on('end',function(fileds, files){
	var sql;
	var args;
	if(body.key == 1)
	{
		sql = 'insert into andorid_onnara_member' +
				'(Id, Password, UnitName, Name)' +
				'values(?, ?, ?, ?)';
		 args= [body.Id, body.Password, body.UnitName, body.Name];
	}
	else if(body.key == 2)
	{
		sql = 'insert into android_onnara_articles' +
				'(Title, Writer, Content, SendName)' +
				'values(?, ?, ?, ?)';

		 args= [body.title, body.writerName, body.content, body.sendName];
	}
	console.log(sql);

		connection.query(sql, args, function(err, results, fields)
		{
			if(err)
			{
				res.sendStatus(500);
				console.log('error');
				return;
			}
			res.sendStatus(200);
		});
	});
	form.parse(req);
});

app.post('/upload', function(req, res){
	var form = new formidable.IncomingForm();
	var body = {};

	if(!isFormData(req))
	{
		res.status(400).end('Bad Request : expecting multipart/form-data');
		return;
	}

	form.on('field', function(name, value)
	{
		body[name] = value;
	});
    form.on('end',function(fileds, files)
	{
			var sql;
			if(body.key == 1) 
				sql = 'SELECT * FROM android_onnara_confirm WHERE onnaraID = ' + "'" + body.ID + "'" + ' AND onnaraPW = ' + "'" + body.PW + "'";
			else if(body.key == 2)
				sql = 'SELECT * FROM andorid_onnara_member WHERE Id = ' + "'" + body.id + "'";
			else if(body.key == 3)
				sql = 'SELECT * FROM andorid_onnara_member WHERE Id = ' + "'" + body.ID + "'" + ' AND Password = ' + "'" + body.PW + "'";
	
			connection.query(sql, function(err, rows, fileds){
			if(err)
			{
				console.log("err");
				res.sendStatus(400);
				return;
			}
			if(rows.length == 0)
			{
				console.log("err1");
				res.sendStatus(204);
			}
			else
			{
				console.log("OK");
				res.status(201).send(rows[0].Name);
				res.end();
			}
		});
	});
    form.parse(req);
});

app.listen(5043);
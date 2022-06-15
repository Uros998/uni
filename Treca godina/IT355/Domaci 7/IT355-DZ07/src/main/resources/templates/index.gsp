<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DZ07</title>
</head>

<body>
    <g:each in="exams">
        $(exam.id)<br/>
        $(exam.name)<br/>
        $(exam.picked)<br/>
    </g:each>
</body>
</html>
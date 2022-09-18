<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="width: 200px">
    <fieldset >
        <legend>Add Transport</legend>
        <form name="transport" action="/ui/v1/transport/add" method="POST">
            Name : <@spring.formInput "form.name" "" "text"/>
            <br>
            <br>
            Description :<@spring.formInput "form.description" "" "text"/>
            <br>
            <br>
            Mileage :<@spring.formInput "form.mileage" "" "text"/>
            <br>
            <br>
            <input type="submit" value="Create">
        </form>
    </fieldset>
</div>

</body>
</html>
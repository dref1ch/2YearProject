<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="width: 200px">
    <fieldset style="padding:30px; border:3px solid navy; background:aliceblue;">
        <legend>Update  Transport</legend>
        <form name="transport" action="" method="POST">
            Name : <@spring.formInput "formEdit.name" "" "text"/>
            <br>
            <br>
            Description :<@spring.formInput "formEdit.description" "" "text"/>
            <br>
            <br>
            Mileage : <@spring.formInput "formEdit.mileage" "" "text"/>
            <br>
            <br>
            Created : <@spring.formInput "formEdit.createdAt" "" "date"/>
            <br>
            <br>
            <input type="submit" value="Update">
        </form>
    </fieldset>
</div>

</body>
</html>
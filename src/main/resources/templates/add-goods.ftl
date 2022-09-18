<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="width: 200px">
    <fieldset >
        <legend>Add Goods</legend>
        <form name="goods" action="/ui/v1/goods/add" method="POST">
            Name : <@spring.formInput "form.name" "" "text"/>
            <br>
            <br>
            Description :<@spring.formInput "form.description" "" "text"/>
            <br>
            <br>
            Code : <@spring.formInput "form.code" "" "text"/>
            <br>
            <br>
            Price :<@spring.formInput "form.price" "" "text"/>
            <br>
            <br>
            Delivery :<@spring.formSingleSelect "form.delivery",times,""/>
            <br>
            <br>
            <input type="submit" value="Create">
        </form>
    </fieldset>
</div>

</body>
</html>
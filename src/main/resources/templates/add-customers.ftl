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
        <legend>Add Customers</legend>
        <form name="goods" action="" method="POST">
            Name : <@spring.formInput "form.name" "" "text"/>
            <br>
            <br>
            Description :<@spring.formInput "form.description" "" "text"/>
            <br>
            <br>
            Country : <@spring.formInput "form.country" "" "text"/>
            <br>
            <br>
            District : <@spring.formInput "form.district" "" "text"/>
            <br>
            <br>
            Settlement : <@spring.formInput "form.settlement" "" "text"/>
            <br>
            <br>
            Street : <@spring.formInput "form.street" "" "text"/>
            <br>
            <br>
            House number : <@spring.formInput "form.houseNumber" "" "text"/>
            <br>
            <br>
            Apartment number : <@spring.formInput "form.apartmentNumber" "" "text"/>
            <br>
            <br>
            First name :<@spring.formInput "form.firstName" "" "text"/>
            <br>
            <br>
            Middle name :<@spring.formInput "form.middleName" "" "text"/>
            <br>
            <br>
            Last name :<@spring.formInput "form.lastName" "" "text"/>
            <br>
            <br>
            Telephone number :<@spring.formInput "form.telephoneNumber" "" "text"/>
            <br>
            <br>
            E-mail :<@spring.formInput "form.eMail" "" "text"/>
            <br>
            <br>
            <input type="submit" value="Create">
        </form>
    </fieldset>
</div>

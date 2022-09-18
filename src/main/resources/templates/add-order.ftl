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
        <legend>Add Order</legend>
        <form name="goods" action="" method="POST">
          Customers : <@spring.formSingleSelect "form.customer", customers, ""/>
          <br>
          <br>
          Goods :<@spring.formSingleSelect "form.goods", goods, ""/>
          <br>
          <br>
          Transport : <@spring.formSingleSelect "form.transport", transports, ""/>
          <br>
          <br>
          <input type="submit" value="Create">
        </form>
    </fieldset>
</div>
</body>
</html>
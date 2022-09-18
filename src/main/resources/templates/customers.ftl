<!DOCTYPE html>
<html lang="en">
<h1>Customers <span class="yellow">UI</span></h1>
<h2>by <a href="https://www.instagram.com/dref1ch/" target="_blank">Antonyuk Denys</a></h2>

<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    @import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700);
    .delete-link {
        display: inline-block;
        padding: 3px 5px;
        border: 1px solid red;
        background-color: #edbaba;
        color: red;
        text-decoration: none;
    }
    .delete-link:hover {
        background-color: #fff;
    }
    .need-to-confirm .confirmation {
        display: none;
    }
    .confirmed .maintext {
        display: none;
    }

    body {
        font-family: 'Open Sans', sans-serif;
        font-weight: 700;
        line-height: 1.42em;
        color:#A7A1AE;
        background-color:#1F2739;
    }

    h1 {
        font-size:2em;
        font-weight: 400;
        line-height:1em;
        text-align: center;
        color: #4DC3FA;
    }

    h2 {
        font-size:1em;
        font-weight: 700;
        text-align: center;
        display: block;
        line-height:1em;
        padding-bottom: 2em;
        color: #FB667A;
    }

    h2 a {
        font-weight: 500;
        text-transform: uppercase;
        color: #FB667A;
        text-decoration: none;
    }

    .blue { color: #185875; }
    .yellow { color: #FFF842; }

    .container th h1 {
        font-weight: bold;
        font-size: 1em;
        text-align: center;
        color: #185875;
    }

    .container td {
        font-weight: normal;
        font-size: 1em;
        -webkit-box-shadow: 0 2px 2px -2px #0E1119;
        -moz-box-shadow: 0 2px 2px -2px #0E1119;
        box-shadow: 0 2px 2px -2px #0E1119;
    }

    .container {
        text-align: left;
        overflow: hidden;
        width: 100%;
        margin: 0 auto;
        display: table;
        padding: 0 0 8em 0;
    }



    .container tr:nth-child(odd) {
        background-color: #323C50;
    }


    .container tr:nth-child(even) {
        background-color: #2C3446;
    }

    .container th {
        background-color: #1F2739;
    }

    .container td:first-child { color: #FB667A; }

    .container tr:hover {
        background-color: #464A52;
        -webkit-box-shadow: 0 6px 6px -6px #0E1119;
        -moz-box-shadow: 0 6px 6px -6px #0E1119;
        box-shadow: 0 6px 6px -6px #0E1119;
    }

    .container td:hover {
        background-color: #FFF842;
        color: #403E10;
        font-weight: bold;

        box-shadow: #7F7C21 -1px 1px, #7F7C21 -2px 2px, #7F7C21 -3px 3px, #7F7C21 -4px 4px, #7F7C21 -5px 5px, #7F7C21 -6px 6px;
        transform: translate3d(6px, -6px, 0);

        transition-delay: 0s;
        transition-duration: 0.4s;
        transition-property: all;
        transition-timing-function: line;
    }

    @media (max-width: 800px) {
        .container td:nth-child(4),
        .container th:nth-child(4) { display: none; }
    }

    .wrap {
        height: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .button {
        min-width: 300px;
        min-height: 60px;
        font-family: 'Nunito', sans-serif;
        font-size: 22px;
        text-transform: uppercase;
        letter-spacing: 1.3px;
        font-weight: 700;
        color: #313133;
        background: #4FD1C5;
        background: linear-gradient(90deg, rgba(129,230,217,1) 0%, rgba(79,209,197,1) 100%);
        border: none;
        border-radius: 1000px;
        box-shadow: 12px 12px 24px rgba(79,209,197,.64);
        transition: all 0.3s ease-in-out 0s;
        cursor: pointer;
        outline: none;
        position: relative;
        padding: 10px;
    }

    button::before {
        content: '';
        border-radius: 1000px;
        min-width: calc(300px + 12px);
        min-height: calc(60px + 12px);
        border: 6px solid #00FFCB;
        box-shadow: 0 0 60px rgba(0,255,203,.64);
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        opacity: 0;
        transition: all .3s ease-in-out 0s;
    }

    .button:hover, .button:focus {
        color: #313133;
        transform: translateY(-6px);
    }

    button:hover::before, button:focus::before {
        opacity: 1;
    }

    button::after {
        content: '';
        width: 30px; height: 30px;
        border-radius: 100%;
        border: 6px solid #00FFCB;
        position: absolute;
        z-index: -1;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        animation: ring 1.5s infinite;
    }

    button:hover::after, button:focus::after {
        animation: none;
        display: none;
    }

    @keyframes ring {
        0% {
            width: 30px;
            height: 30px;
            opacity: 1;
        }
        100% {
            width: 300px;
            height: 300px;
            opacity: 0;
        }
    }
</style>
<body>
<table class="container">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Address</th>
        <th>Customer name</th>
        <th>Telephone</th>
        <th>E-mail</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <#list customers as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.description}</td>
            <td>${customer.address.country}, ${customer.address.district}, ${customer.address.settlement},
                ${customer.address.street} ${customer.address.houseNumber} ${customer.address.apartmentNumber}</td>
            <td>${customer.contactPerson.firstName} ${customer.contactPerson.middleName} ${customer.contactPerson.lastName}</td>
            <td>${customer.contactPerson.telephoneNumber}</td>
            <td>${customer.contactPerson.EMail}</td>
            <td>${customer.createdAt}</td>
            <td>${customer.updatedAt}</td>
            <td>
                <a  class="button1  "href="/ui/v1/customers/delete/${customer.id}"
                    onclick="return confirm('Are you sure you want to delete this?');"
                    type="submit">
                    Delete
                </a>
            </td>
            <td>
                <a href="/ui/v1/customers/pageEdit/${customer.id}">Update</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
<div class="wrap" >
    <form action="/ui/v1/customers/put">
        <button class="button" >Create</button>
    </form>
</div>
</body>
</html>
<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['email']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("test", $_POST['email'], $_POST['password'])) {
            echo "Login Success";
        } else echo "E-mail or Password wrong";
    } else echo "Error: Database connection";
} else echo "login hibauzenet";
?>
<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['fullname']) && isset($_POST['username']) && isset($_POST['password']) && isset($_POST['email'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("test", $_POST['fullname'], $_POST['username'], $_POST['password'], $_POST['email'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "regisztralas hibauzenet";
?>
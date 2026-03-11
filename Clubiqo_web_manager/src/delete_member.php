<?php

session_start();

if (!isset($_SESSION["user"])) {
    header("Location: index.php");
    exit;
}

$id = $_GET["id"];

$deleteCh = curl_init("https://oracleapex.com/ords/137471797498121299854/members_api/deletebyid/" . $id);
curl_setopt($deleteCh, CURLOPT_CUSTOMREQUEST, "DELETE");
curl_setopt($deleteCh, CURLOPT_RETURNTRANSFER, true);

$deleteResponse = curl_exec($deleteCh);
curl_close($deleteCh);

header("Location: members.php?deleted=1");
exit;

?>
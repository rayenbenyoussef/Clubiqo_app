<?php

session_start();

if (!isset($_SESSION["user"])) {
    header("Location: index.php");
    exit;
}

$id = $_GET["id"];
$ch = curl_init("https://oracleapex.com/ords/137471797498121299854/members_api/memberbyid/" . $id);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

$response = curl_exec($ch);
curl_close($ch);

if (!$response) {
    die("<h2>No response from server.</h2>");
}

$resdata = json_decode($response, true);

if (!$resdata || !isset($resdata['items'])) {
    die("<h2>API not available or invalid JSON response. Please come back later.</h2>");
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<title>Clubiqo Member</title>
	<style>
        main{
            display: flex;
            flex-direction: column;
            align-items: center;
        }
		.container{
            display: flex;
            flex-direction: column;
            align-items: center;
            background: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-bottom: 15px;
            width: auto;
        }
        .member-image{
			width: 100px;
			height: 100px;
			border-radius: 50%;
			object-fit: cover;
		}
		.member-info{
			margin: 5px 0;
		}
		.detail-btn{
			text-decoration: none;
			padding: 8px 16px;
			background: #007bff;
			color: white;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			font-size: 17px;
		}
		.detail-btn:hover{
			background: #0056b3;
		}
	</style>
</head>
<body>

	<header>
		<img src="assets/clubiqo-cover.png" alt="Clubiqo Cover Image">
		<h1>Member Details</h1>
	</header>
	<main>
		<div class="container">
            <img class="member-image" src="assets/member-placeholder.png" alt="Member Image">
			<h2 class="member-name"><?php echo $resdata["items"][0]["firstname"] . " " . $resdata["items"][0]["lastname"]; ?></h2>
			<h4 class="member-info">Id: <?php echo $resdata["items"][0]["id"]; ?></h4>
			<h4 class="member-info">Email: <?php echo $resdata["items"][0]["email"]; ?></h4>
			<h4 class="member-info">Phone N: <?php echo $resdata["items"][0]["phonenumber"]; ?></h4>
			<h4 class="member-info">Role: <?php echo $resdata["items"][0]["role"]; ?></h4>
			<h4 class="member-info">Status: <?php echo $resdata["items"][0]["status"]; ?></h4>
			<h4 class="member-info">Join Date: <?php echo date("m/d/Y", strtotime($resdata["items"][0]["joindate"])); ?></h4>
			<h4 class="member-info">Birth Date: <?php echo date("m/d/Y", strtotime($resdata["items"][0]["birthdate"])); ?></h4>
            <h4 style="margin-bottom: 20px;" class="member-info">token_expiry: <?php echo date("m/d/Y H:i:s", strtotime($resdata["items"][0]["token_expiry"])); ?></h4>
            <div class="button-group">
                <a class="detail-btn" href="edit_member.php?id=<?php echo $resdata["items"][0]["id"]; ?>">Edit Member</a>
                <a class="detail-btn" href="delete_member.php?id=<?php echo $resdata["items"][0]["id"]; ?>">Delete Member</a>
            </div>
		</div>
	</main>
	<footer>
		<p>&copy; 2025 Clubiqo Manager. All rights reserved.</p>
	</footer>
	
</body>
</html>
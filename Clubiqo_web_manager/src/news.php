<?php

session_start();

if (!isset($_SESSION["user"])) {
    header("Location: index.php");
    exit;
}

$ch = curl_init("https://oracleapex.com/ords/137471797498121299854/news_api/news");
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
usort($resdata['items'], function($a, $b) {
    return strcmp(strtoupper($a['postdate']), strtoupper($b['postdate']));
});
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<title>Clubiqo News</title>
	<style>
		.news-list{
			display: flex;
			flex-direction: column;
			align-items: center;
			background: #fff;
			padding: 15px;
			border-radius: 5px;
			box-shadow: 0 2px 5px rgba(0,0,0,0.1);
			margin-bottom: 15px;
			width: 300px;
		}
		.news-image{
			width: 300px;
			height: 150px;
			object-fit: cover;
		}
		.more-info{
			margin: 5px 0;
            align-self: flex-start;
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
		<h1>News</h1>
	</header>
	<main>
		<div class="container">
            <?php foreach ($resdata['items'] as $news) {?>
			<div class="news-list">
				<img class="news-image" src="assets/news.jpg" alt="Member Image">
				<h2 class="news-title"><?php echo $news["title"]; ?></h2>
				<h4 class="more-info">Id: <?php echo $news["newsid"]; ?></h4>
				<h4 class="more-info"><a href="detailed_member.php?id=<?php echo $news["lastmodifiedby"]; ?>">Last Modified By: <?php echo $news["lastmodifiedby"]; ?></a></h4>
				<h4 style="margin-bottom: 20px;" class="more-info">Post Date: <?php echo date("m/d/Y", strtotime($news["postdate"])); ?></h4>
				<div><a class="detail-btn" href="detailed_news.php?id=<?php echo $news["newsid"]; ?>">View Details</a></div>
			</div>
			<?php } ?>
		</div>
	</main>
	<footer>
		<p>&copy; 2025 Clubiqo Manager. All rights reserved.</p>
	</footer>
	
</body>
</html>
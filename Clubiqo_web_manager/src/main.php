
<?php
session_start();

if (!isset($_SESSION["user"])) {
    header("Location: index.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<title>Clubiqo Manager</title>
</head>
<body>
	<header>
		<img src="assets/clubiqo-cover.png" alt="Clubiqo Cover Image">
		<h1>Manager</h1>
	</header>
	<main>
		<div class="container">
			<div id="dashboard-card" class="card">
				<h2 class="card-title">Dashboard</h2>
				<p>Welcome to the Clubiqo Manager dashboard. Here you can manage your club's activities, members, and events.</p>
				<a href="#" class="btn">Go to Dashboard</a>
			</div>
			<div id="members-card" class="card">
				<h2 class="card-title">Members</h2>
				<p>Manage your club members, view their profiles, and keep track of their activities.</p>
				<a href="members.php" class="btn">Manage Members</a>
			</div>
			<div id="events-card" class="card">
				<h2 class="card-title">Events</h2>
				<p>Create and manage events for your club. Keep your members informed about upcoming activities.</p>
				<a href="events.php" class="btn">Manage Events</a>
			</div>
			<div id="news-card" class="card">
				<h2 class="card-title">News</h2>
				<p>Manage your club's news and announcements for members.</p>
				<a href="news.php" class="btn">Manage News</a>
			</div>
			<div id="settings-card" class="card">
				<h2 class="card-title">Settings</h2>
				<p>Configure your club's settings, including notifications, permissions, and more.</p>
				<a href="#" class="btn">Configure Settings</a>
			</div>
		</div>
	</main>
	<footer>
		<p>&copy; 2025 Clubiqo Manager. All rights reserved.</p>
	</footer>
	
</body>
</html>
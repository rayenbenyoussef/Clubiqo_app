<?php
session_start();
$_SESSION['user'] = null;

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'] ?? '';
    $password = $_POST['password'] ?? '';

    
    $data = [
        "email" => $email,
        "password" => $password
    ];

    $ch = curl_init("https://oracleapex.com/ords/137471797498121299854/members_api/login");
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
    curl_setopt($ch, CURLOPT_HTTPHEADER, ["Content-Type: application/json"]);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $response = curl_exec($ch);
    curl_close($ch);

    if (!$response) {
        die("No response from server.");
    }

    $resdata = json_decode($response, true);
    if (!empty($resdata) && $resdata['status'] === 'success') {
        if ((strtolower($resdata['user']['role']) === 'admin' || strtolower($resdata['user']['role']) === 'moderator')) {
            $_SESSION['user'] = $resdata['user']['email'];
            header('Location: main.php');
            exit;
        }else {
            $error = 'Access denied. Only admins and moderators can log in.';
        }
    }else {
        $error = 'Invalid credentials';
    }
    
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial; display: flex; justify-content: center; align-items: center; height: 100vh; background: #f0f0f0; }
        .login-container { background: white; padding: 30px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); width: 300px; }
        h1 { text-align: center; }
        input { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #0056b3; }
        .error { color: red; margin-bottom: 10px; }
        img{ display: block; margin: 0 2px 20px; width: 60%; height: auto; }
        .cover-container { text-align: center; margin-bottom: 20px; display: flex;flex-direction: row; align-items: center; }
        .cover-container h2 { vertical-align: middle; color: #333;padding-bottom:22px; }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="cover-container"><img src="assets/clubiqo-cover.png" alt="ClubIQO Cover"><h2>Manager</h2></div>
        <h1>Login</h1>
        <?php if (isset($error)) { ?>
            <div class="error"><?php echo htmlspecialchars($error); ?></div>
        <?php } ?>
        <form method="POST">
            <input type="text" name="email" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
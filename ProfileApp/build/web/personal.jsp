<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Personal Profile</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="personal-wrapper">
    <div class="personal-card">

        <h2 class="page-title">Personal Profile</h2>

        <form action="ProfileServlet" method="post" class="personal-form">

            <div class="form-row">
                <label>Student ID</label>
                <input type="text" name="student_id" required>
            </div>

            <div class="form-row">
                <label>Full Name</label>
                <input type="text" name="full_name" required>
            </div>

            <div class="form-row">
                <label>Programme</label>
                <input type="text" name="programme" required>
            </div>

            <div class="form-row">
                <label>Hobby</label>
                <input type="text" name="hobby">
            </div>

            <div class="form-row">
                <label>Email</label>
                <input type="email" name="email" required>
            </div>

            <button type="submit" class="btn-pink full">
                Save Profile 🍓
            </button>

        </form>

        <a href="index.html" class="btn-back">← Back</a>

    </div>
</div>

</body>
</html>
